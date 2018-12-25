package com.platform.springboot.service.dmi;

import com.alibaba.fastjson.JSON;
import com.platform.springboot.base.BaseService;
import com.platform.springboot.entity.bif.BifMd5CodePool;
import com.platform.springboot.entity.dmi.DmiCompanyInfo;
import com.platform.springboot.entity.dmi.DmiCompanyInfoWithBusinessLicense;
import com.platform.springboot.entity.dmi.DmiOrganization;
import com.platform.springboot.entity.sys.SysCompanyUsers;
import com.platform.springboot.mapper.bif.BifMd5CodePoolMapper;
import com.platform.springboot.mapper.dmi.DmiCompanyInfoMapper;
import com.platform.springboot.service.file.FileServiceImpl;
import com.platform.springboot.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * @description: 公司信息
 * @author: zhangshuai
 * @create: 2018-12-14 18:35
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class DmiCompanyInfoService extends BaseService<DmiCompanyInfoMapper,DmiCompanyInfo> {

    @Autowired
    private DmiCompanyInfoMapper dmiCompanyInfoMapper;

    @Autowired
    private FileServiceImpl fileService;

    @Autowired
    private DmiOrganizationService dmiOrganizationService;

    @Autowired
    private BifMd5CodePoolMapper md5CodePoolMapper;

    /**
     * 新增/编辑雇主基础信息
     * @param dmiCompanyInfo
     * @return
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public Result handle(DmiCompanyInfo dmiCompanyInfo) {

        SysCompanyUsers user = CurrentUtil.getCurrent();

        if (dmiCompanyInfo == null || dmiCompanyInfo.getCompanyName() == null ||
                dmiCompanyInfo.getCompanyFullName() == null) {
            return ResultUtil.validateError("参数错误");
        } else {

            if (dmiCompanyInfo.getId() > 0) {
                // 执行更新操作
                dmiCompanyInfo.setUpdatePerson(user.getId());
                dmiCompanyInfo.setUpdateTime(new Date());

                updateCompanyInfo(dmiCompanyInfo);

                return ResultUtil.successMsg("更新成功");
            } else {
                // 执行新增操作
                dmiCompanyInfo.setCreatePerson(user.getId());
                dmiCompanyInfo.setCreateTime(new Date());
                dmiCompanyInfo.setFlagAvailable(true);
                dmiCompanyInfo.setFlagDeleted(false);

                if (user != null && "VENDOR".equals(user.getActType())) dmiCompanyInfo.setVendorId(user.getActObjectId());
                else dmiCompanyInfo.setVendorId(1);
                int companyId = insertCompanyInfo(dmiCompanyInfo);
                Date now = new Date();

                while (true){

                    String companyToken = CompanyToken(now);
                    dmiCompanyInfo.setCompanyToken(companyToken);
                    Integer md5Id=  md5CodePoolMapper.selectMd5(companyToken);

                    if(md5Id==null){

                        BifMd5CodePool pool = new BifMd5CodePool();
                        pool.setMd5Code(companyToken);
                        pool.setSource("dmi-company-info");
                        pool.setObjectId(companyId);
                        pool.setCreateTime(now);
                        pool.setCreatePerson(user.getId());
                        md5CodePoolMapper.insertSelective(pool);
                        dmiCompanyInfoMapper.updateCompanyToken(pool);

                        break;

                    }

                }



                String companyToken= dmiCompanyInfo.getCompanyToken();

                SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddHHmmss");
                String st = sd.format(now);

                String imgPatch = st +random()+ ".jpg";

                File file = new File("/home/temp_image/"+imgPatch);


                try{
                    QRCodeUtil.encode(companyToken,imgPatch,"/home/temp_image/",true);
                    Result result = fileService.uploadLocal(file,"qrcode","image");
                    dmiCompanyInfo.setCompanyTokenImage(result.getMsg());
                    dmiCompanyInfo.setId(companyId);
                    dmiCompanyInfoMapper.updateCompanyUrl(dmiCompanyInfo);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                // 新增一个默认的组织结构
                DmiOrganization dmiOrganization = new DmiOrganization();
                dmiOrganization.setId(0);
                dmiOrganization.setOrganizationName("全国");
                dmiOrganization.setOrganizationCode("default_code");
                dmiOrganization.setParentId(0);
                dmiOrganization.setOrderId(1);
                dmiOrganization.setBelongsCompanyId(companyId);
                dmiOrganization.setLevel(1);
                dmiOrganization.setCreatePerson(user.getId());
                dmiOrganization.setUpdatePerson(user.getId());
                dmiOrganization.setUpdateTime(new Date());
                Result result = dmiOrganizationService.handle(user.getId(), companyId, dmiOrganization);
                return result;
            }
        }
    }


    /**
     * 查看雇主公司基础信息
     * @param id
     * @return
     */
    public Result getCompanyBasicInfo(int id) {
        HashMap<String, Object> orgMap = (HashMap<String, Object>) dmiCompanyInfoMapper.selectBasicInfoByPrimaryKey(id);
        return ResultUtil.success(new DmiCompanyInfoWithBusinessLicense(orgMap));
    }


    private boolean updateCompanyInfo(DmiCompanyInfo dmiCompanyInfo) {
        int effectRows = dmiCompanyInfoMapper.updateByPrimaryKeySelective(dmiCompanyInfo);

        if (effectRows > 0) {
            return true;
        } else {
            return false;
        }
    }


    private int insertCompanyInfo(DmiCompanyInfo dmiCompanyInfo) {
        dmiCompanyInfoMapper.insertSelective(dmiCompanyInfo);
        return dmiCompanyInfo.getId();
    }


    private String CompanyToken(Date now) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String  str = sdf.format(now);
        String random = random();
        String  companyToken= "8a2i"+Encrypt.getMD5Str(str)+random;
        return companyToken;
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

    public int getCompanyCountByBusinessLicenseId(int id) {
        return dmiCompanyInfoMapper.selectByBusinessLicenseId(id);
    }

    public Result companyList() {
        return ResultUtil.success(dmiCompanyInfoMapper.companyList());
    }
}
