package com.platform.springboot.service.dmi;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.platform.springboot.base.BaseService;
import com.platform.springboot.entity.dmi.DmiBusinessLicense;
import com.platform.springboot.entity.dmi.DmiBusinessLicenseWithBLOBs;
import com.platform.springboot.entity.dmi.DmiContact;
import com.platform.springboot.entity.sys.SysCompanyUsers;
import com.platform.springboot.mapper.dmi.DmiBusinessLicenseMapper;
import com.platform.springboot.utils.CurrentUtil;
import com.platform.springboot.utils.PageInfo;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class DmiBusinessLicenseService{
    @Resource
    private DmiBusinessLicenseMapper dmiBusinessLicenseMapper;

    @Resource
    private DmiStoreService dmiStoreService;

    @Resource
    private DmiCompanyInfoService dmiCompanyInfoService;

    @Resource
    private DmiOrganizationService dmiOrganizationService;

    public Result pageBusinessLicense(DmiBusinessLicense dmiBusinessLicense) {
        PageHelper.startPage(dmiBusinessLicense.getPageNum(), dmiBusinessLicense.getPageSize());
        Page<DmiBusinessLicense> persons = dmiBusinessLicenseMapper.selectByCompanyId(dmiBusinessLicense.getCompanyId());
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<DmiBusinessLicense> pageInfo = new PageInfo<>(persons);
        return ResultUtil.success(pageInfo);
    }

    public Result pageBusinessLicenseDown(int companyId) {
        List<DmiBusinessLicense> list = new ArrayList<>();
        List<DmiBusinessLicense> businessLicenses = dmiBusinessLicenseMapper.selectByCompanyId(companyId);
        if(businessLicenses!=null){
            return ResultUtil.success(businessLicenses);
        }
        return ResultUtil.success(list);
    }

    public Result getBusinessLicense(Integer id) {
        DmiBusinessLicenseWithBLOBs sqlResilt = dmiBusinessLicenseMapper.selectByPrimaryKey(id);
        return ResultUtil.success(sqlResilt == null ? new DmiBusinessLicenseWithBLOBs() : sqlResilt);
    }

    public Result handle(String requestJson) {

        SysCompanyUsers user = CurrentUtil.getCurrent();
        if(user==null){
            return ResultUtil.JurisdictionError("");
        }
        if (requestJson.indexOf("companyName") <= 0 || requestJson.indexOf("licenseCode") <= 0) {
            // 设定返回信息
            return ResultUtil.validateError("参数错误");
        } else {
            DmiBusinessLicenseWithBLOBs dmiBusinessLicenseWithBLOBs = JSON.parseObject(requestJson, DmiBusinessLicenseWithBLOBs.class);

            if (dmiBusinessLicenseWithBLOBs.getId()!=null && dmiBusinessLicenseWithBLOBs.getId() > 0) {
                // 执行更新操作
                dmiBusinessLicenseWithBLOBs.setUpdatePerson(user.getId());
                dmiBusinessLicenseWithBLOBs.setUpdateTime(new Date());

                updateBusinessLicense(dmiBusinessLicenseWithBLOBs);

                return ResultUtil.successMsg("更新营业执照成功");
            } else {
                // 执行新增操作
                dmiBusinessLicenseWithBLOBs.setCreatePerson(user.getId());
                dmiBusinessLicenseWithBLOBs.setCreateTime(new Date());
                dmiBusinessLicenseWithBLOBs.setFlagAvailable(true);
                dmiBusinessLicenseWithBLOBs.setFlagDeleted(false);
                dmiBusinessLicenseWithBLOBs.setUpdatePerson(user.getId());
                dmiBusinessLicenseWithBLOBs.setUpdateTime(new Date());

                // 如果从页面Body中没有获得CompanyId参数，需要手动设定一次CompanyId
                if (dmiBusinessLicenseWithBLOBs.getCompanyId() == null || dmiBusinessLicenseWithBLOBs.getCompanyId() == 0) {
                    dmiBusinessLicenseWithBLOBs.setCompanyId(user.getCompanyId());
                }

                insertBusinessLicense(dmiBusinessLicenseWithBLOBs);
                return ResultUtil.successMsg("新增营业执照成功");
            }
        }
    }

    private boolean insertBusinessLicense(DmiBusinessLicenseWithBLOBs dmiBusinessLicenseWithBLOBs) {
        int effectRows = dmiBusinessLicenseMapper.insertSelective(dmiBusinessLicenseWithBLOBs);

        if (effectRows > 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean updateBusinessLicense(DmiBusinessLicenseWithBLOBs dmiBusinessLicenseWithBLOBs) {
        int effectRows = dmiBusinessLicenseMapper.updateByPrimaryKeySelective(dmiBusinessLicenseWithBLOBs);

        if (effectRows > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Result handleInvalid(String requestJson) {

        SysCompanyUsers user = CurrentUtil.getCurrent();
        if(user==null){
            return ResultUtil.JurisdictionError("");
        }
        DmiBusinessLicenseWithBLOBs dmiBusinessLicenseWithBLOBs = JSON.parseObject(requestJson, DmiBusinessLicenseWithBLOBs.class);

        // 设定失效
        dmiBusinessLicenseWithBLOBs.setFlagAvailable(false);
        dmiBusinessLicenseWithBLOBs.setUpdateTime(new Date());
        dmiBusinessLicenseWithBLOBs.setUpdatePerson(user.getId());

        updateBusinessLicense(dmiBusinessLicenseWithBLOBs);

        return ResultUtil.successMsg("失效营业执照成功");
    }

    public Result handleDelete(String requestJson) {

        SysCompanyUsers user = CurrentUtil.getCurrent();
        if(user==null){
            return ResultUtil.JurisdictionError("");
        }
        DmiBusinessLicenseWithBLOBs dmiBusinessLicenseWithBLOBs = JSON.parseObject(requestJson, DmiBusinessLicenseWithBLOBs.class);

        if (this.checkBusinessLicenseUsed(dmiBusinessLicenseWithBLOBs.getId())) {
            // 如果发现该营业执照还被其他公司、组织节点（分公司）、门店使用时，不可以被删除
            return ResultUtil.validateError("该营业执照被使用，不可删除");
        } else {

            // 设定失效
            dmiBusinessLicenseWithBLOBs.setFlagDeleted(true);
            dmiBusinessLicenseWithBLOBs.setUpdateTime(new Date());
            dmiBusinessLicenseWithBLOBs.setUpdatePerson(user.getId());

            updateBusinessLicense(dmiBusinessLicenseWithBLOBs);
            return ResultUtil.successMsg("营业执照删除成功");
        }
    }

    /**
     * 检查营业执照是否被使用在公司、组织节点、门店中
     *
     * @param businessLicenseId
     * @return
     */
    private boolean checkBusinessLicenseUsed(Integer businessLicenseId) {
        boolean useStatus = false;

        if (dmiCompanyInfoService.getCompanyCountByBusinessLicenseId(businessLicenseId) > 0) {
            useStatus = true;
        }
        if (dmiStoreService.getStoreCountByBusinessLicenseId(businessLicenseId) > 0) {
            useStatus = true;
        }
        if (dmiOrganizationService.getOragnizationCountByBusinessLicenseId(businessLicenseId) > 0) {
            useStatus = true;
        }

        return useStatus;
    }
}
