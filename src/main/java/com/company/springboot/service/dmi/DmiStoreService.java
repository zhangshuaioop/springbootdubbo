package com.company.springboot.service.dmi;

import com.alibaba.fastjson.JSON;
import com.company.springboot.Thread.ImportDTO;
import com.company.springboot.Thread.ImportStoreThread;
import com.company.springboot.entity.bif.BifDeviceDetail;
import com.company.springboot.entity.bif.BifDeviceUploadFileWithList;
import com.company.springboot.entity.bif.BifMd5CodePool;
import com.company.springboot.entity.cfg.CfgCommunicationBrand;
import com.company.springboot.entity.cfg.CfgDeviceTypeCatalog;
import com.company.springboot.entity.dmi.*;
import com.company.springboot.entity.dmi.ret.dmiStore.IndieProductInfo;
import com.company.springboot.entity.dmi.ret.dmiStore.ListRet;
import com.company.springboot.entity.file.DeleteFile;
import com.company.springboot.entity.trc.TrcDmiBatchEmpolyeeImport;
import com.company.springboot.mapper.bif.BifMd5CodePoolMapper;
import com.company.springboot.mapper.cfg.CfgCommunicationBrandMapper;
import com.company.springboot.mapper.cfg.CfgCommunicationTypeCatalogMapper;
import com.company.springboot.mapper.cfg.CfgDeviceTypeCatalogMapper;
import com.company.springboot.mapper.dmi.DmiBrandMapper;
import com.company.springboot.mapper.dmi.DmiDeviceAssignMapper;
import com.company.springboot.mapper.dmi.DmiStoreMapper;
import com.company.springboot.mapper.dmi.DmiStoreUploadFileMapper;
import com.company.springboot.mapper.trc.TrcDmiBatchEmpolyeeImportMapper;
import com.company.springboot.service.file.FileServiceImpl;
import com.company.springboot.utils.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Maps;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 雇主门店
 *
 * @Author Niting
 * @date 2018/12/15
 **/
@Service
public class DmiStoreService extends CommonBiz {

    @Autowired
    private DmiStoreMapper dmiStoreMapper;
    @Autowired
    private DmiStoreUploadFileMapper storeUploadFileMapper;
    @Autowired
    private FileServiceImpl fileService;
    @Autowired
    private BifMd5CodePoolMapper md5CodePoolMapper;
    @Autowired
    private DmiBrandMapper brandMapper;
    @Autowired
    ImportStoreThread storeThread;
    @Autowired
    private TrcDmiBatchEmpolyeeImportMapper batchEmpolyeeImportMapper;
    @Value("${filepath}")
    private String filepath;

    //定义一个线程池
    ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);


    public List<DmiStore> listByBuildingId(int buildingId) {
        return dmiStoreMapper.listByBuildingId(buildingId);
    }

    /**
     * 根据雇主公司的ID,获取门店list
     *
     * @param store
     * @return
     * @author Niting
     * @Date 2018/07/02
     */
    public Result storeList(DmiStore store) {
        if (store.getCompanyId() == null) {
            return ResultUtil.validateError("参数错误");
        }
        Map map = new HashMap();
        if (store.getAreaId() == null || store.getAreaId() == 0) {
            map.put("areaId", store.getAreaId());
        } else {
            //查询是否有子节点
            List<Integer> list = new ArrayList<Integer>();
            //创建个空的LIST  ret 用于存放所有子节点的详细store信息
            List<Integer> ret = t1(store.getAreaId(), list);
            ret.add(store.getAreaId());
            map.put("areaList", ret);

        }
        map.put("companyId", store.getCompanyId());
        map.put("brandId", store.getBrandId());
        map.put("province", store.getProvince());
        map.put("city", store.getCity());
        map.put("district", store.getDistrict());
        PageHelper.startPage(store.getPageNum(), store.getPageSize());
        List<ListRet> persons = dmiStoreMapper.queryStoreList(map);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<ListRet> pageInfo = new PageInfo<>(persons);
        if(pageInfo.getList()==null||pageInfo.getList().size()==0){
            pageInfo.setPageNum(1);
            pageInfo.setPageSize(10);
        }
        return ResultUtil.success(pageInfo);
    }


    /**
     * 根据雇主公司的ID,获取门店list
     *
     * @return
     */
    public Result storeListByCompanyId(DmiStore dmiStore) {
        if (dmiStore.getPageNum() != null && dmiStore.getPageSize() != null) {
            PageHelper.startPage(dmiStore.getPageNum(), dmiStore.getPageSize());
            Page<DmiStore> dmiStores = dmiStoreMapper.queryStoreByCompanyId(dmiStore.getCompanyId());
            PageInfo<DmiStore> pageInfo = new PageInfo<>(dmiStores);
            if(pageInfo.getList()==null||pageInfo.getList().size()==0){
                pageInfo.setPageNum(1);
                pageInfo.setPageSize(10);
            }
            return ResultUtil.success(pageInfo);
        } else {
            List<DmiStore> dmiStores = dmiStoreMapper.queryStoreByCompanyId(dmiStore.getCompanyId());
            return ResultUtil.success(dmiStores);
        }
    }


    public DmiStoreWithBusinessLicense getStoreBasicInfo(int id) {
        DmiStoreWithBusinessLicense result = dmiStoreMapper.selectWithBizLicByPrimaryKey(id);
        if(result!=null){
            result.setStoreUploadFileList(storeUploadFileMapper.selectByStoreId(id));
        }
        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    public Result handle(Integer userId, DmiStore dmiStore, BifDeviceUploadFileWithList bifDeviceUploadFileWithList) {
        if (dmiStore.getBrandId() == null || dmiStore.getBrandId() == 0) {
            return ResultUtil.validateError("操作失败，雇主品牌不能为空！");
        }
        if (dmiStore.getBusinessLicenseId() == null) dmiStore.setBusinessLicenseId(0);
        if (dmiStore.getId() == null || dmiStore.getId() == 0) {
            insertStore(dmiStore, userId, bifDeviceUploadFileWithList);

            return ResultUtil.successMsg("新增成功!");
        } else {
            dmiStore.setUpdateTime(new Date());
            dmiStore.setUpdatePerson(userId);
            dmiStoreMapper.updateByPrimaryKeySelective(dmiStore);

            // 查询该门店所有的设备资料
            List<DmiStoreUploadFile> sqlResultList = storeUploadFileMapper.selectByStoreId(dmiStore.getId());
            Map<Integer, DmiStoreUploadFile> sqlResultMap = Maps.newHashMap();
            List<Integer> sqlResultIdList = new ArrayList<Integer>();
            for (DmiStoreUploadFile item : sqlResultList) {
                sqlResultMap.put(item.getId(), item);
                sqlResultIdList.add(item.getId());
            }

            // 获取页面参数传入的所有设备资料
            List<DmiStoreUploadFile> paramList = bifDeviceUploadFileWithList.getStoreUploadFileList();
            Map<Integer, DmiStoreUploadFile> paramMap = Maps.newHashMap();
            List<Integer> paramIdList = new ArrayList<Integer>();
            for (DmiStoreUploadFile item : paramList) {
                paramMap.put(item.getId(), item);
                paramIdList.add(item.getId());
            }

            // 计算得到需要添加和删除的资料集合
            List<Integer> addList = new ArrayList<Integer>();
            List<Integer> delList = new ArrayList<Integer>();
            for (Integer item : paramIdList) {
                if (!sqlResultIdList.contains(item)) addList.add(item);
            }
            for (Integer item : sqlResultIdList) {
                if (!paramIdList.contains(item)) delList.add(item);
            }

            // 删除资料
            for (Integer item : delList) {
                DmiStoreUploadFile deleteItem = sqlResultMap.get(item);
                deleteItem.setFlagDeleted(true);
                storeUploadFileMapper.updateByPrimaryKeySelective(deleteItem);

                // 调用删除接口
                DeleteFile deleteFile = new DeleteFile();
                String url = sqlResultMap.get(item).getFileUrl();
                String key = url.substring(url.lastIndexOf(".com/") + 5);
                String type = url.substring(7, url.indexOf("."));
                deleteFile.setKey(key);
                deleteFile.setType(type);
                fileService.delete(deleteFile);
            }

            // 上传资料
            for (Integer item : addList) {
                DmiStoreUploadFile addItem = paramMap.get(item);
                addItem.setId(null);
                addItem.setStoreId(dmiStore.getId());
                addItem.setCreateTime(new Date());
                addItem.setCreatePerson(userId);
                addItem.setFlagDeleted(false);
                storeUploadFileMapper.insertSelective(addItem);
            }

            return ResultUtil.successMsg("更新成功！");
        }
    }

    /**
     * 门店失效
     *
     * @param userId
     * @param requestJson
     * @return
     */
    public Result handleInvalid(int userId, String requestJson) {

        DmiStore dmiStore = JSON.parseObject(requestJson, DmiStore.class);

        // 设定失效
        dmiStore.setFlagAvailable(false);
        dmiStore.setUpdateTime(new Date());
        dmiStore.setUpdatePerson(userId);

        //updateStore(dmiStore);
        if (updateStore(dmiStore)) {
            return ResultUtil.successMsg("失效成功！");
        }
        return ResultUtil.successMsg("失效失败！");
    }

    /**
     * 删除门店
     *
     * @param userId
     * @param requestJson
     * @return
     */
    public Result handleDelete(int userId, String requestJson) {
        DmiStore dmiStore = JSON.parseObject(requestJson, DmiStore.class);

        // 设定失效
        dmiStore.setFlagDeleted(true);
        dmiStore.setUpdateTime(new Date());
        dmiStore.setUpdatePerson(userId);

        updateStore(dmiStore);

        return ResultUtil.successMsg("删除门店成功！");
    }

    /**
     * 更新门店信息
     *
     * @param dmiStore
     * @return
     */
    private boolean updateStore(DmiStore dmiStore) {
        int effectRows = dmiStoreMapper.updateByPrimaryKeySelective(dmiStore);

        if (effectRows > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 新增门店的基础信息
     *
     * @param dmiStore
     * @param userId
     * @param bifDeviceUploadFileWithList
     */
    private void insertStore(DmiStore dmiStore, int userId, BifDeviceUploadFileWithList bifDeviceUploadFileWithList) {
        Date now = new Date();
        if (dmiStore.getBuildingId() == null) dmiStore.setBuildingId(0);
        dmiStore.setCompanyId(dmiStore.getCompanyId());
        dmiStore.setCreatePerson(userId);
        dmiStore.setCreateTime(new Date());
        dmiStore.setUpdatePerson(userId);
        dmiStore.setUpdateTime(now);
        dmiStore.setFlagAvailable(true);
        dmiStore.setFlagDeleted(false);
        dmiStoreMapper.insertSelective(dmiStore);

        while (true) {
            String storeToken = StoreToken(now);
            dmiStore.setStoreToken(storeToken);
            Integer md5Id = md5CodePoolMapper.selectMd5(storeToken);

            if (md5Id == null) {

                BifMd5CodePool pool = new BifMd5CodePool();
                pool.setMd5Code(storeToken);
                pool.setSource("dmi-store");
                pool.setObjectId(dmiStore.getId());
                pool.setCreateTime(now);
                pool.setCreatePerson(userId);
                md5CodePoolMapper.insertSelective(pool);
                dmiStoreMapper.updateStoreToken(pool);

                break;

            }


        }

        String storeToken = dmiStore.getStoreToken();

        SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddHHmmss");
        String st = sd.format(now);

        String imgPatch = st + ".jpg";

        File file = new File("/home/temp_image/" + imgPatch);


        try {
            QRCodeUtil.encode(storeToken, imgPatch, "/home/temp_image/", true);
            Result result = fileService.uploadLocal(file, "qrcode", "image");
            dmiStore.setStoreTokenImageUrl(result.getMsg());
            dmiStore.setId(dmiStore.getId());
            dmiStoreMapper.updateStoreUrl(dmiStore);
        } catch (Exception e) {
            e.printStackTrace();
        }


        // 门店资料
        DmiStoreUploadFile record = new DmiStoreUploadFile();
        record.setId(null);
        record.setStoreId(dmiStore.getId());
        record.setCreatePerson(userId);
        record.setCreateTime(now);
        record.setFlagDeleted(false);
        List<DmiStoreUploadFile> storeUploadFileList = bifDeviceUploadFileWithList.getStoreUploadFileList();
        for (int i = 0; i < storeUploadFileList.size(); i++) {
            record.setFileName(storeUploadFileList.get(i).getFileName());
            record.setFileUrl(storeUploadFileList.get(i).getFileUrl());
            record.setFileType(storeUploadFileList.get(i).getFileType());
            storeUploadFileMapper.insertSelective(record);
        }
    }


    /**
     * 校验texcel数据
     *
     * @param companyId
     * @return
     * @author Niting
     * @Date 2018/08/29
     */
    public Result check(CommonsMultipartFile file, int userId, int companyId) {
        HSSFWorkbook wb;
        try {
            wb = new HSSFWorkbook(file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return ResultUtil.errorExceptionMsg("发生严重错误，预判是传入的文件出现严重错误，请人工处理后再次处理");
        }
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow row;
        HSSFCell cell;
        StringBuffer message = new StringBuffer("");

        if (sheet.getLastRowNum() > 999) {
            return ResultUtil.errorExceptionMsg("Excel行数大于1000，请修改行数");
        }
        for (int i = sheet.getFirstRowNum() + 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            boolean saveFlag = true;
            row = sheet.getRow(i);
            if (row == null) {
                message.append("第 " + (i + 1) + " 行， 为空；");
                continue;
            }
            StringBuffer column = new StringBuffer(" ");
            for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
                cell = row.getCell(j);
                String value = ExcelUtil.getStringValForExcel(cell);


                switch (j) {
                    case 0:
                        // 门店名 中文不得超过50位，英文不得超过100位
                        if (ValiDateUtil.length(value) > 100) {
                            column.append((j + 1) + " | ");
                            saveFlag = false;
                        }
                        break;
                    case 1:
                        // 店长（中文不得超过50位，英文不得超过100位）
                        if (value.equals("") || ValiDateUtil.length(value) > 100) {
                            column.append((j + 1) + " | ");
                            saveFlag = false;
                        }
                        break;
                    case 2:
                        // 店编号（中文不得超过50位，英文不得超过100位，不能为空）
                        if (value.equals("") || ValiDateUtil.length(value) > 100) {
                            column.append((j + 1) + " | ");
                            saveFlag = false;
                        }
                        break;
                    case 3:
                        //店铺电话 不能超过11位 并且为纯数字
                        if (value.equals("") || ValiDateUtil.length(value) > 100) {
                            column.append((j + 1) + " | ");
                            saveFlag = false;
                        }
                        break;
                    case 4:
                        // 品牌（中文不得超过50位，英文不得超过100位、品牌必须存在）
                        DmiBrand brand = brandMapper.selectByBrandName(value, companyId);
                        if (ValiDateUtil.length(value) > 100 || brand == null) {
                            column.append((j + 1) + " | ");
                            saveFlag = false;
                        }
                        break;
                    case 5:
                        // 临时地址 （中文不得超过50位，英文不得超过100位）
                        if (value.equals("") || ValiDateUtil.length(value) > 100) {
                            column.append((j + 1) + " | ");
                            saveFlag = false;
                        }
                        break;

                    case 6:
                        // 备注 长度不得超过2000位
                        if (ValiDateUtil.length(value) > 2000) {
                            column.append((j + 1) + " | ");
                            saveFlag = false;
                        }
                        break;
                }


            }
            if (!saveFlag) message.append("第 " + (i + 1) + " 行， 第 " + column + " 列，数据有误；");
        }
        if (!"".equals(message.toString())) {
            return ResultUtil.errorExceptionMsg(message.toString());
        } else {
            String fileName = System.currentTimeMillis() + ".xls";
            String filePath = filepath + fileName;
            File copyFile = new File(filePath);
            try {
                file.transferTo(copyFile);
            } catch (IOException e) {
                e.printStackTrace();
                return ResultUtil.errorExceptionMsg("文件校验通过，系统保存时发生故障，请联系管理员！");
            }
            Result result = new Result();
            result.setData(sheet.getPhysicalNumberOfRows() - 1);
            return ResultUtil.successMsg(fileName);
        }
    }

    /**
     * 门店导入
     *
     * @param companyId
     * @return
     * @author Niting
     * @Date 2018/08/29
     */
    public Result importStore(ImportDTO importDTO, int userId, int companyId) {
        importDTO.setBelongCompanyId(companyId);
        importDTO.setUserId(userId);
        importDTO.setBatchInsertCode("IE_" + System.currentTimeMillis());
        storeThread.setImportDTO(importDTO);
        executor.execute(storeThread);
        return ResultUtil.successMsg(importDTO.getBatchInsertCode());
    }

    /**
     * 导入门店回调
     *
     * @param batchInsertCode
     * @return
     * @author Niting
     * @Date 2018/08/30
     */
    public TrcDmiBatchEmpolyeeImport importCallBack(String batchInsertCode) {
        return batchEmpolyeeImportMapper.selectByBatchInsertCode(batchInsertCode);
    }

    /**
     * 生成门店token
     *
     * @param now
     * @return
     */
    private String StoreToken(Date now) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String str = sdf.format(now);
        String random = random();
        String storeToken = "1ml8" + Encrypt.getMD5Str(str) + random;
        return storeToken;
    }

    /**
     * 生成随机数
     *
     * @return
     */
    private String random() {
        String result = "";
        while (result.length() < 6) {
            String str = String.valueOf((int) (Math.random() * 10));
            if (result.indexOf(str) == -1) {
                result += str;
            }
        }
        return result;
    }

    public List<Integer> t1(int areaId, List<Integer> list) {
        List<Integer> children = getChildren(areaId);
        if (!children.isEmpty()) {
            list.addAll(children);
            for (int x : children
            ) {
                t1(x, list);
            }
        }
        return list;
    }


    private List<Integer> getChildren(int areaId) {

        return dmiStoreMapper.selectChildrenId(areaId);
    }


    @Autowired
    private DmiContactStoreRelationService dmiContactStoreRelationService;

    @Autowired
    private DmiDeviceAssignMapper dmiDeviceAssignMapper;

    @Autowired
    private CfgDeviceTypeCatalogMapper cfgDeviceTypeCatalogMapper;

    @Autowired
    private DmiCommProductMarketingCampaignService marketingCampaignService;

    @Autowired
    private DmiStoreCommProductService productService;

    @Autowired
    private CfgCommunicationBrandMapper cfgCommunicationBrandMapper;

    @Autowired
    private CfgCommunicationTypeCatalogMapper cfgCommunicationTypeCatalogMapper;

    public DmiStoreOverallInfo showOverall(int storeId) {
        DmiStoreOverallInfo dmiStoreOverallInfo = new DmiStoreOverallInfo();

        // 设定基础信息
        dmiStoreOverallInfo.setDmiStoreWithBusinessLicense(getStoreBasicInfo(storeId));

        // 设定联系人信息
        dmiStoreOverallInfo.setDmiContactStoreRelationDetailList(dmiContactStoreRelationService.getAllRelationsByStoreId(storeId));

        //设定设备信息
        List<BifDeviceDetail> sqlResult = dmiDeviceAssignMapper.selectByStoreId(storeId);
        List<BifDeviceDetail> deviceResult = new ArrayList<BifDeviceDetail>();
        for (BifDeviceDetail item : sqlResult) {
            // 获取父级分类名称
            CfgDeviceTypeCatalog cfgDeviceTypeCatalog = cfgDeviceTypeCatalogMapper.selectByPrimaryKey(item.getCatalogId());
            int level = cfgDeviceTypeCatalog.getLevel();
            if (level == 3) {
                item.setChildNode(cfgDeviceTypeCatalog.getCatalogName());
                CfgDeviceTypeCatalog father = cfgDeviceTypeCatalogMapper.selectByPrimaryKey(cfgDeviceTypeCatalog.getParentId());
                item.setFatherNode(father.getCatalogName());
                CfgDeviceTypeCatalog grandfather = cfgDeviceTypeCatalogMapper.selectByPrimaryKey(father.getParentId());
                item.setGrandFatherNode(grandfather.getCatalogName());
            }
            if (level == 2) {
                item.setFatherNode(cfgDeviceTypeCatalog.getCatalogName());
                CfgDeviceTypeCatalog grandfather = cfgDeviceTypeCatalogMapper.selectByPrimaryKey(cfgDeviceTypeCatalog.getParentId());
                item.setGrandFatherNode(grandfather.getCatalogName());
            }
            if (level == 1) {
                item.setGrandFatherNode(cfgDeviceTypeCatalog.getCatalogName());
            }
            deviceResult.add(item);
        }
        dmiStoreOverallInfo.setDmiDeviceList(deviceResult);

        // 门店资料
//        dmiStoreOverallInfo.setStoreUploadFileList(storeUploadFileMapper.selectByStoreId(storeId));

        //设定通讯资源信息
        dmiStoreOverallInfo.setMarketingCampaignInfoList(marketingCampaignService.showListByStoreId(storeId));
        List<DmiStoreCommProduct> IndependenceProductList = productService.getIndependenceProductListByStoreId(storeId);
        List<IndieProductInfo> result = new ArrayList<IndieProductInfo>();
        for (DmiStoreCommProduct item : IndependenceProductList) {
            IndieProductInfo outItem = new IndieProductInfo();
            outItem.setSubBrand(item.getSubBrand());
            // 产品名
            outItem.setProductDescription(item.getProductDescription());
            // 产品大小类
            Map<String, String> catalogMap = getCatalogNmList(item.getCatalogId());
            outItem.setFatherCategory(catalogMap.get(CATALOG_MAP_FATHER_KEY));
            outItem.setChildCategory(catalogMap.get(CATALOG_MAP_CHILD_KEY));
            // 品牌
            if (item.getBrandId() != null) {
                CfgCommunicationBrand brandInfo = cfgCommunicationBrandMapper.selectByPrimaryKey(item.getBrandId());
                if (brandInfo != null) outItem.setBrandName(brandInfo.getBrandName());
            }
            // ISP服务商
            outItem.setIspService(outItem.getIspService());
            // 产品分类
            String productCategoryType = cfgCommunicationTypeCatalogMapper.selectByPrimaryKey(item.getCatalogId()).getCatalogName();
            outItem.setProductCategoryType(productCategoryType);
            // 产品特有信息
            outItem.setObjectInfo(getObjectProductByCatalog(item.getCatalogId(), item.getId()));
            outItem.setPmsCode(item.getPmsCode());
            result.add(outItem);
        }
        dmiStoreOverallInfo.setIndieProductInfoList(result);
        return dmiStoreOverallInfo;
    }


    public int getCountByBrandId(int brandId) {
        return dmiStoreMapper.getCountByBrandId(brandId);
    }

    public int getStoreCountByBusinessLicenseId(int id) {
        return dmiStoreMapper.selectByBusinessLicenseId(id);
    }
}
