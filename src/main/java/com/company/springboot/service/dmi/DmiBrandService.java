package com.company.springboot.service.dmi;

import com.company.springboot.entity.dmi.DmiBrand;
import com.company.springboot.entity.sys.SysCompanyUsers;
import com.company.springboot.mapper.dmi.DmiBrandMapper;
import com.company.springboot.utils.CurrentUtil;
import com.company.springboot.utils.PageInfo;
import com.company.springboot.utils.Result;
import com.company.springboot.utils.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Chenliwen
 * @Date 2018/12/15
 */

@Service
public class DmiBrandService {

    @Resource
    private DmiStoreService dmiStoreService;
    @Resource
    private DmiBrandMapper mapper;

    public Result getAllBrandByCompanyId(DmiBrand dmiBrand) {
        if(dmiBrand.getPageNum()!=null && dmiBrand.getPageSize()!=null){
            PageHelper.startPage(dmiBrand.getPageNum(), dmiBrand.getPageSize());
            Page<DmiBrand> persons = mapper.selectBrandByCompanyId(dmiBrand.getCompanyId());
            // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
            PageInfo<DmiBrand> pageInfo = new PageInfo<>(persons);
            if(pageInfo.getList()==null||pageInfo.getList().size()==0){
                pageInfo.setPageNum(1);
                pageInfo.setPageSize(10);
            }
            return ResultUtil.success(pageInfo);
        }else{
            List<DmiBrand> persons = mapper.selectBrandByCompanyId(dmiBrand.getCompanyId());
            // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
            return ResultUtil.success(persons);
        }


    }

    public Result getBrand(int id) {
        DmiBrand sqlResult = mapper.selectByPrimaryKey(id);
        return ResultUtil.success(sqlResult == null ? new DmiBrand() : sqlResult);
    }

    public Result handle(DmiBrand dmiBrand) {

        SysCompanyUsers user = CurrentUtil.getCurrent();
        if(user==null){
            return ResultUtil.JurisdictionError("");
        }
        if (dmiBrand.getBrandName()== null|| dmiBrand.getBrandCode() == null) {
            return ResultUtil.validateError("参数错误");
        } else {

            if (dmiBrand.getId() > 0) {
                // 执行更新操作
                dmiBrand.setUpdatePerson(user.getId());
                dmiBrand.setUpdateTime(new Date());

                updateBrand(dmiBrand);

                return ResultUtil.successMsg("更新成功");
            } else {
                // 执行新增操作
                dmiBrand.setCreatePerson(user.getId());
                dmiBrand.setCreateTime(new Date());
                dmiBrand.setFlagAvailable(true);
                dmiBrand.setFlagDeleted(false);
                dmiBrand.setUpdatePerson(user.getId());
                dmiBrand.setUpdateTime(new Date());

                // 如果从页面Body中没有获得CompanyId参数，需要手动设定一次CompanyId
                if (dmiBrand.getCompanyId() == null || dmiBrand.getCompanyId() == 0) dmiBrand.setCompanyId(user.getCompanyId());

                insertBrand(dmiBrand);
                return ResultUtil.successMsg("新增成功");
            }
        }
    }

    private boolean updateBrand(DmiBrand dmiBrand) {
        int effectRows = mapper.updateByPrimaryKeySelective(dmiBrand);

        if (effectRows > 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean insertBrand(DmiBrand dmiBrand) {
        int effectRows = mapper.insertSelective(dmiBrand);

        if (effectRows > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Result handleInvalid(DmiBrand dmiBrand) {

        SysCompanyUsers user = CurrentUtil.getCurrent();
        if(user==null){
            return ResultUtil.JurisdictionError("");
        }
        // 设定失效
        dmiBrand.setFlagAvailable(false);
        dmiBrand.setUpdateTime(new Date());
        dmiBrand.setUpdatePerson(user.getId());

        updateBrand(dmiBrand);

        return ResultUtil.successMsg("品牌失效成功");
    }

    public Result handleDelete(DmiBrand dmiBrand) {
        SysCompanyUsers user = CurrentUtil.getCurrent();
        if(user==null){
            return ResultUtil.JurisdictionError("");
        }
        if (this.checkBrandUsed(dmiBrand.getId())) {
            // 如果发现该品牌门店使用时，不可以被删除
            return ResultUtil.validateError("该品牌被门店使用，不可删除");
        } else {

            // 设定失效
            dmiBrand.setFlagDeleted(true);
            dmiBrand.setUpdateTime(new Date());
            dmiBrand.setUpdatePerson(user.getId());

            updateBrand(dmiBrand);

            return ResultUtil.successMsg("品牌删除成功");
        }
    }

    /**
     * 检查品牌是否被使用在门店中
     *
     * @param branId
     * @return
     */
    private boolean checkBrandUsed(Integer branId) {
        boolean useStatus = false;

        if (dmiStoreService.getCountByBrandId(branId) > 0) {
            useStatus = true;
        }
        return useStatus;
    }
}
