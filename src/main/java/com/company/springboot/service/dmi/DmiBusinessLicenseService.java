package com.company.springboot.service.dmi;

import com.company.springboot.entity.dmi.DmiBusinessLicense;
import com.company.springboot.entity.dmi.DmiBusinessLicenseWithBLOBs;
import com.company.springboot.entity.sys.SysCompanyUsers;
import com.company.springboot.mapper.dmi.DmiBusinessLicenseMapper;
import com.company.springboot.utils.CurrentUtil;
import com.company.springboot.utils.PageInfo;
import com.company.springboot.utils.Result;
import com.company.springboot.utils.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DmiBusinessLicenseService {
    @Resource
    private DmiBusinessLicenseMapper dmiBusinessLicenseMapper;

    @Resource
    private DmiStoreService dmiStoreService;

    @Resource
    private DmiCompanyInfoService dmiCompanyInfoService;

    @Resource
    private DmiOrganizationService dmiOrganizationService;

    private Logger log = Logger.getLogger(Logger.class);

    public Result pageBusinessLicense(DmiBusinessLicense dmiBusinessLicense) {
        if (dmiBusinessLicense.getPageNum() != null && dmiBusinessLicense.getPageSize() != null) {
            PageHelper.startPage(dmiBusinessLicense.getPageNum(), dmiBusinessLicense.getPageSize());
            Page<DmiBusinessLicense> persons = dmiBusinessLicenseMapper.selectByCompanyId(dmiBusinessLicense.getCompanyId());
            // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
            PageInfo<DmiBusinessLicense> pageInfo = new PageInfo<>(persons);
            if(pageInfo.getList()==null||pageInfo.getList().size()==0){
                pageInfo.setPageNum(1);
                pageInfo.setPageSize(10);
            }
            return ResultUtil.success(pageInfo);
        } else {
            return ResultUtil.success(dmiBusinessLicenseMapper.selectByCompanyId(dmiBusinessLicense.getCompanyId()));
        }
    }

    public Result pageBusinessLicenseDown(int companyId) {
        List<DmiBusinessLicense> list = new ArrayList<>();
        List<DmiBusinessLicense> businessLicenses = dmiBusinessLicenseMapper.selectByCompanyId(companyId);
        if (businessLicenses != null) {
            return ResultUtil.success(businessLicenses);
        }
        return ResultUtil.success(list);
    }

    public Result getBusinessLicense(Integer id) {
        DmiBusinessLicenseWithBLOBs sqlResilt = dmiBusinessLicenseMapper.selectByPrimaryKey(id);
        return ResultUtil.success(sqlResilt == null ? new DmiBusinessLicenseWithBLOBs() : sqlResilt);
    }

    public Result handle(DmiBusinessLicenseWithBLOBs dmiBusinessLicenseWithBLOBs) {

        SysCompanyUsers user = CurrentUtil.getCurrent();
        if (user == null) {
            return ResultUtil.JurisdictionError("");
        }
        if (dmiBusinessLicenseWithBLOBs.getCompanyName() ==null || dmiBusinessLicenseWithBLOBs.getLicenseCode() == null) {
            // 设定返回信息
            return ResultUtil.validateError("参数错误");
        } else {

            if (dmiBusinessLicenseWithBLOBs.getId() != null && dmiBusinessLicenseWithBLOBs.getId() > 0) {
                // 执行更新操作
                dmiBusinessLicenseWithBLOBs.setUpdatePerson(user.getId());
                dmiBusinessLicenseWithBLOBs.setUpdateTime(new Date());

                updateBusinessLicense(dmiBusinessLicenseWithBLOBs);
            } else {
                if (dmiBusinessLicenseWithBLOBs.getCompanyId() == null || dmiBusinessLicenseWithBLOBs.getCompanyId() == 0) {
                    log.info("companyId为空");
                    return ResultUtil.validateError("参数错误");
                }
                // 执行新增操作
                dmiBusinessLicenseWithBLOBs.setCreatePerson(user.getId());
                dmiBusinessLicenseWithBLOBs.setCreateTime(new Date());
                dmiBusinessLicenseWithBLOBs.setFlagAvailable(true);
                dmiBusinessLicenseWithBLOBs.setFlagDeleted(false);
                dmiBusinessLicenseWithBLOBs.setUpdatePerson(user.getId());
                dmiBusinessLicenseWithBLOBs.setUpdateTime(new Date());

                insertBusinessLicense(dmiBusinessLicenseWithBLOBs);

            }
            return ResultUtil.success();
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

    public Result handleInvalid(DmiBusinessLicenseWithBLOBs dmiBusinessLicenseWithBLOBs) {

        // 设定失效
        dmiBusinessLicenseWithBLOBs.setFlagAvailable(false);
        dmiBusinessLicenseWithBLOBs.setUpdateTime(new Date());
        dmiBusinessLicenseWithBLOBs.setUpdatePerson(CurrentUtil.getCurrent().getId());

        updateBusinessLicense(dmiBusinessLicenseWithBLOBs);

        return ResultUtil.successMsg("失效营业执照成功");
    }

    public Result handleDelete(DmiBusinessLicenseWithBLOBs dmiBusinessLicenseWithBLOBs) {


        if (this.checkBusinessLicenseUsed(dmiBusinessLicenseWithBLOBs.getId())) {
            // 如果发现该营业执照还被其他公司、组织节点（分公司）、门店使用时，不可以被删除
            return ResultUtil.validateError("该营业执照被使用，不可删除");
        } else {

            // 设定失效
            dmiBusinessLicenseWithBLOBs.setFlagDeleted(true);
            dmiBusinessLicenseWithBLOBs.setUpdateTime(new Date());
            dmiBusinessLicenseWithBLOBs.setUpdatePerson(CurrentUtil.getCurrent().getId());

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
