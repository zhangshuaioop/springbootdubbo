package com.teekee.waterdropservice.service.cfg;

import com.teekee.commoncomponets.utils.PageInfo;
import com.teekee.commoncomponets.utils.Result;
import com.teekee.commoncomponets.utils.ResultUtil;
import com.teekee.waterdropservice.entity.cfg.*;
import com.teekee.waterdropservice.entity.sys.SysCompanyUsers;
import com.teekee.waterdropservice.mapper.cfg.CfgDispatchModelConfigMapper;
import com.teekee.waterdropservice.utils.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Chenliwen
 * @Date 2018/12/18 13:34
 **/
@Service
public class CfgDispatchModelConfigService{
    @Resource
    private CfgDispatchModelConfigMapper mapper;


    public Result handle(CfgDispatchModelConfig cfgDispatchModelConfig) {

        SysCompanyUsers user = CurrentUtil.getCurrent();
        if(user==null){
            return ResultUtil.JurisdictionError("");
        }
        Date now = new Date();
        if(cfgDispatchModelConfig.getCompanyId() == 0 || cfgDispatchModelConfig.getCompanyId() == null){
            return ResultUtil.validateError("请选择雇主！");
        }
        if(cfgDispatchModelConfig.getProjectId() == 0 || cfgDispatchModelConfig.getProjectId() == null){
            return ResultUtil.validateError("请选择项目！");
        }
        if(cfgDispatchModelConfig.getModelName().equals("") || cfgDispatchModelConfig.getModelName() == null){
            return ResultUtil.validateError("请填写模板名称！");
        }
        if(ValiDateUtil.isNumeric(cfgDispatchModelConfig.getSuggestPrice().toString()) == false){
            return ResultUtil.validateError("请填写正确价格！");
        }


        cfgDispatchModelConfig.setFlagDeleted(false);

        if(user != null){
            cfgDispatchModelConfig.setBelongObjectId(user.getActObjectId());
            cfgDispatchModelConfig.setBelongObjectType(user.getActType());
        }
        if(cfgDispatchModelConfig.getId() == 0){
            //根据模板名查询
            CfgDispatchModelConfig modelName =  mapper.selectByModelName(cfgDispatchModelConfig);
            if(modelName != null){
                return ResultUtil.validateError("模板名不可重复！");
            }
            cfgDispatchModelConfig.setCreatePerson(user.getId());
            cfgDispatchModelConfig.setCreateTime(now);
            //模板新增默认不启用
            cfgDispatchModelConfig.setFlagAvaliable(false);
            //新增模板
            mapper.insertSelective(cfgDispatchModelConfig);
            return ResultUtil.successMsg("新增模板成功");
        }else {
            cfgDispatchModelConfig.setUpdatePerson(user.getId());
            cfgDispatchModelConfig.setUpdateTime(now);
            //编辑模板
            mapper.updateByPrimaryKeySelective(cfgDispatchModelConfig);
            return ResultUtil.successMsg("编辑模板成功");

        }
    }

    public Result list(CfgDispatchModelConfigParam cfgDispatchModelConfigParam) {
        PageHelper.startPage(cfgDispatchModelConfigParam.getPageNum(), cfgDispatchModelConfigParam.getPageSize());
        Page<GetCfgDispatchModelConfigList> persons = mapper.list(cfgDispatchModelConfigParam);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<GetCfgDispatchModelConfigList> pageInfo = new PageInfo<>(persons);
        return ResultUtil.success(pageInfo);
    }

    public Result show(int id) {
        return ResultUtil.success(mapper.show(id));
    }

    public Result delete(int id) {
        CfgDispatchModelConfig model = new CfgDispatchModelConfig();
        if(id != 0){
            model.setId(id);
            model.setFlagDeleted(true);
            mapper.updateByPrimaryKeySelective(model);
            return ResultUtil.successMsg("删除成功!");
        }
        return ResultUtil.validateError("删除失败！");
    }

    public Result createPersonList(CfgDispatchModelConfig cfgDispatchModelConfig) {

        SysCompanyUsers user = CurrentUtil.getCurrent();
        if(user==null){
            return ResultUtil.JurisdictionError("");
        }

        PageHelper.startPage(cfgDispatchModelConfig.getPageNum(), cfgDispatchModelConfig.getPageSize());
        Page<GetCfgDispatchModelConfigPersonList> persons = mapper.selectByCreatePerson(user.getId());
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<GetCfgDispatchModelConfigPersonList> pageInfo = new PageInfo<>(persons);
        return ResultUtil.success(pageInfo);
    }

    public Result isStart(int id, int flagUsed) {
        CfgDispatchModelConfig model = new CfgDispatchModelConfig();
        model.setId(id);
        //flagUsed=1时为启用模板  0为禁用模板
        if(flagUsed == 1){
            model.setFlagAvaliable(true);
            mapper.updateByPrimaryKeySelective(model);
            return ResultUtil.successMsg("已启用该模板!");
        }else {
            model.setFlagAvaliable(false);
            mapper.updateByPrimaryKeySelective(model);
            return ResultUtil.successMsg("已禁用该模板!");
        }
    }

    public Result useModelList(int projectId) {
        List<CfgDispatchModelConfig> list = new ArrayList<CfgDispatchModelConfig>();
        List<CfgDispatchModelConfig> result =  mapper.selectByUseModelList(projectId);
        if(result != null){
            return ResultUtil.success(result);
        }
        return ResultUtil.success(list);
    }

    public Result pList(int companyId) {
        SysCompanyUsers user = CurrentUtil.getCurrent();
        if(user==null){
            return ResultUtil.JurisdictionError("");
        }
        List<CfgDispatchModelConfig> list = new ArrayList<CfgDispatchModelConfig>();
        List<CfgDispatchModelConfig> result =  mapper.pList(companyId,user.getId());
        if(companyId != 0){
            return ResultUtil.success(result);
        }
        return ResultUtil.success(list);
    }
}
