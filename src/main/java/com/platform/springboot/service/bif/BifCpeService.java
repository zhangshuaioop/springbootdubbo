package com.platform.springboot.service.bif;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.platform.springboot.base.BaseService;
import com.platform.springboot.entity.bif.BifCpe;
import com.platform.springboot.entity.sys.SysCompanyUsers;
import com.platform.springboot.mapper.bif.BifCpeMapper;
import com.platform.springboot.utils.CurrentUtil;
import com.platform.springboot.utils.PageInfo;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 *
 * @Author Chenliwen
 * @Date 2018/12/17 14:00
 **/
@Service
public class BifCpeService{

    @Resource
    private BifCpeMapper mapper;

    public Result getBifCpeList(BifCpe bifCpe) {
        PageHelper.startPage(bifCpe.getPageNum(), bifCpe.getPageSize());
        Page<BifCpe> persons = mapper.getBifCpeList(bifCpe);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<BifCpe> pageInfo = new PageInfo<>(persons);
        return ResultUtil.success(pageInfo);
    }

    public Result getBifCpeById(Integer id) {
        if(id !=null && id !=0){
            return ResultUtil.success(mapper.getBifCpeById(id));
        }
        return ResultUtil.success(new BifCpe());
    }

    public Result handle(BifCpe bifCpe) {
        SysCompanyUsers user = CurrentUtil.getCurrent();
        if(user==null){
            return ResultUtil.JurisdictionError("");
        }
        if(bifCpe==null){
            return ResultUtil.validateError("保存异常!");
        }
        bifCpe.setUpdatePerson(user.getId()+"");
        if(bifCpe.getId()==null||bifCpe.getId()==0){
            bifCpe.setCreateTime(new Date());
            bifCpe.setBusinessType("STORE");
            mapper.insertSelective(bifCpe);
        }else{
            bifCpe.setUpdateTime(new Date());
            mapper.updateByPrimaryKeySelective(bifCpe);
        }
        return ResultUtil.successMsg("保存成功!");
    }

    public Result deleteById(Integer id) {
        if(mapper.deleteByid(id)>0){
            return ResultUtil.successMsg("删除成功!");
        }
        return ResultUtil.validateError("删除失败!");
    }
}
