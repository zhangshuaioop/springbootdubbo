package com.teekee.waterdropservice.Thread;


import com.teekee.waterdropservice.entity.dmi.DmiBrand;
import com.teekee.waterdropservice.entity.dmi.DmiOrganization;
import com.teekee.waterdropservice.entity.dmi.DmiStore;
import com.teekee.waterdropservice.entity.trc.TrcDmiBatchEmpolyeeImport;
import com.teekee.waterdropservice.mapper.dmi.DmiBrandMapper;
import com.teekee.waterdropservice.mapper.dmi.DmiBusinessLicenseMapper;
import com.teekee.waterdropservice.mapper.dmi.DmiOrganizationMapper;
import com.teekee.waterdropservice.mapper.dmi.DmiStoreMapper;
import com.teekee.waterdropservice.mapper.trc.TrcDmiBatchEmpolyeeImportMapper;
import com.teekee.waterdropservice.service.file.FileServiceImpl;
import com.teekee.waterdropservice.utils.Encrypt;
import com.teekee.waterdropservice.utils.ExcelUtil;
import com.teekee.waterdropservice.utils.QRCodeUtil;
import com.teekee.commoncomponets.utils.Result;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Niting
 * @date 2018/8/29
 **/
@Component
public class ImportStoreThread implements Runnable {
    private ImportDTO importDTO;

    @Autowired
    private DmiBrandMapper brandMapper;
    @Autowired
    private DmiBusinessLicenseMapper businessLicenseMapper;
    @Autowired
    private FileServiceImpl fService;
    @Resource
    private DmiStoreMapper storeMapper;
    @Resource
    private TrcDmiBatchEmpolyeeImportMapper batchEmpolyeeImportMapper;
    @Resource
    private DmiOrganizationMapper organizationMapper;
    @Value("${filepath}")
    private String filepath;


    public synchronized ImportDTO getImportDTO() {
        ImportDTO result = this.importDTO;
        this.importDTO = null;
        notifyAll();
        return result;
    }


    public synchronized void setImportDTO(ImportDTO importDTO) {
        if (this.importDTO != null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.importDTO = importDTO;
    }

    private void updateErrorBatchImport(int id, int operatorId) {
        TrcDmiBatchEmpolyeeImport batchEmpolyeeImport = new TrcDmiBatchEmpolyeeImport();
        batchEmpolyeeImport.setUpdateTime(new Date());
        batchEmpolyeeImport.setOperatorId(operatorId);
        batchEmpolyeeImport.setId(id);
        batchEmpolyeeImport.setStatus("FAILURE");
        batchEmpolyeeImportMapper.updateByPrimaryKeySelective(batchEmpolyeeImport);


    }


    @Override
    public void run() {
        ImportDTO importDTO = getImportDTO();
        Date now = new Date();

        // 插入批次表
        TrcDmiBatchEmpolyeeImport batchEmpolyeeImport = new TrcDmiBatchEmpolyeeImport();
        batchEmpolyeeImport.setCreateTime(now);
        batchEmpolyeeImport.setOperatorId(importDTO.getUserId());
        batchEmpolyeeImport.setCompanyId(importDTO.getBelongCompanyId());
        batchEmpolyeeImport.setStatus("PROCESSING");
        batchEmpolyeeImport.setBatchInsertCode(importDTO.getBatchInsertCode());
        batchEmpolyeeImport.setImportCount(0);
        batchEmpolyeeImportMapper.insertSelective(batchEmpolyeeImport);

        File file = new File(filepath+ importDTO.getFileName());
        HSSFWorkbook wb = null;
        try {
            wb = new HSSFWorkbook(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
            updateErrorBatchImport(batchEmpolyeeImport.getId(), importDTO.getUserId());
        }
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow row;
        HSSFCell cell;
        StringBuffer message = new StringBuffer("");
        List<DmiStore> list = new ArrayList<DmiStore>();

        for (int i = sheet.getFirstRowNum() + 1; i < sheet.getPhysicalNumberOfRows(); i++) {

            row = sheet.getRow(i);

            if (row == null) {
                message.append("第 " + (i + 1) + " 行， 为空；");
                continue;
            }
            DmiStore store = new DmiStore();
            StringBuffer column = new StringBuffer(" ");
            for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
                cell = row.getCell(j);
                String value = ExcelUtil.getStringValForExcel(cell);
                store.setAreaId(0);
                store.setBuildingId(0);
                store.setAddressId(0);
                store.setBusinessLicenseId(0);
                store.setFlagDeleted(false);
                store.setFlagAvailable(true);
                store.setCreateSource("IMPORT");
                store.setCompanyId(importDTO.getBelongCompanyId());
                store.setCreateTime(now);
                store.setCreatePerson(importDTO.getUserId());
                store.setUpdateTime(now);
                store.setUpdatePerson(importDTO.getUserId());
                String storeToken = StoreToken(now);
                store.setStoreToken(storeToken);
                //根据雇主查询组织结构
                DmiOrganization organization = organizationMapper.selectByCompanyId(importDTO.getBelongCompanyId());
                if(organization != null){
                    //默认组织节点为全国
                    store.setAreaId(organization.getId());
                }
                switch (j) {
                    case 0:
                        // 门店名 中文不得超过50位，英文不得超过100位
                        if (value == null || value == "") {
                            store.setStoreName("");
                        } else {
                            store.setStoreName(value);
                        }
                        break;

                    case 1:
                        // 店长（中文不得超过50位，英文不得超过100位，不能为空）
                        if (value == null || value == "") {
                            store.setManager("");
                        } else {
                            store.setManager(value);
                        }
                        break;
                    case 2:
                        // 店编号（中文不得超过50位，英文不得超过100位，不能为空）
                        if (value == null || value == "") {
                            store.setStoreCode("");
                        } else {
                            if (value.indexOf("E")!=-1 || value.indexOf("e")!=-1 || value.indexOf("+")!=-1) {
                                BigDecimal bd = new BigDecimal(value);
                                store.setStoreCode(bd.toString());
                            }else{
                                int num = value.indexOf(".");
                                if(num != -1){//为数值类型时转换为字符串
                                    store.setStoreCode(value.substring(0,num));
                                }else{//字符串
                                    store.setStoreCode(value);
                                }
                            }

                        }
                        break;
                    case 3:
                        // 店铺电话（中文不得超过50位，英文不得超过100位，不能为空）
                        if (value == null || value == "") {
                            store.setTelephone("");
                        } else {
                            if (value.indexOf("E")!=-1 || value.indexOf("e")!=-1 || value.indexOf("+")!=-1) {
                                BigDecimal bd = new BigDecimal(value);
                                store.setTelephone(bd.toString());
                            }else{
                                int num = value.indexOf(".");
                                if(num != -1){//为数值类型时转换为字符串
                                    store.setTelephone(value.substring(0,num));
                                }else{//字符串
                                    store.setTelephone(value);
                                }
                            }
                        }
                        break;
                    case 4:
                        // 品牌 （中文不得超过50位，英文不得超过100位）
                        DmiBrand brand = brandMapper.selectByBrandName(value,importDTO.getBelongCompanyId());
                        if(brand != null){
                            store.setBrandId(brand.getId());
                        }
                        break;
                    case 5:
                        // 临时地址 （中文不得超过50位，英文不得超过100位）
                        if(value == null || value == ""){
                            store.setImportAddress("");
                        }else {
                            store.setImportAddress(value);
                        }
                        break;
                    case 6:
                        // 备注 （中文不得超过50位，英文不得超过100位）
                        if (value == null || value == "") {
                            store.setMemo("");
                        } else {
                            store.setMemo(value);
                        }
                        break;
                }
            }
                SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddHHmmss");
                String st = sd.format(now);
                String imgPatch = st + ".jpg";
                File imageFile = new File("/home/temp_image/"+imgPatch);
                try{
                    //生成门店二维码code图片
                    QRCodeUtil.encode(store.getStoreToken(),imgPatch,"/home/temp_image/",true);
                    Result result = fService.uploadLocal(imageFile,"qrcode","image");
                    store.setStoreTokenImageUrl(result.getMsg());
                } catch (Exception e){
                    e.printStackTrace();
                }
                list.add(store);
                //  if (!saveFlag) message.append("第 " + (i + 1) + " 行， 第 " + column + " 列，数据有误；");
            }
                importDate(list, importDTO.getUserId(), batchEmpolyeeImport.getId());
        }


    @Transactional(rollbackFor = Exception.class)
    public void importDate(List<DmiStore> list, int userId, int batchId) {


        // 分批插入
        int a = 1000;//每次提交1000条
        int loop = (int) Math.ceil(list.size() / (double) a);

        List<DmiStore> tempList = new ArrayList<DmiStore>(a);
        int start, stop;
        for (int i = 0; i < loop; i++) {
            tempList.clear();
            start = i * a;
            stop = Math.min(i * a + a - 1, list.size() - 1);
            for (int j = start; j <= stop; j++) {
                tempList.add(list.get(j));

            }

            for (DmiStore store : tempList) {
                storeMapper.insertSelective(store);
            }


            System.out.println("已经插入" + (stop + 1) + " 条");
        }


        TrcDmiBatchEmpolyeeImport batchEmpolyeeImport = new TrcDmiBatchEmpolyeeImport();
        batchEmpolyeeImport.setUpdateTime(new Date());
        batchEmpolyeeImport.setOperatorId(userId);
        batchEmpolyeeImport.setId(batchId);
        batchEmpolyeeImport.setStatus("SUCCESS");
        batchEmpolyeeImport.setImportCount(list.size());
        batchEmpolyeeImportMapper.updateByPrimaryKeySelective(batchEmpolyeeImport);

    }

    private String StoreToken(Date now) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String  str = sdf.format(now);
        String random = random();
        String  storeToken= "1ml8"+ Encrypt.getMD5Str(str)+random;
        return storeToken;
    }

    private String random() {


        String result = "";

        while (result.length() <6) {
            String str = String.valueOf((int) (Math.random() * 10));
            if (result.indexOf(str) == -1) {
                result += str;
            }
        }
        return result;
    }
}