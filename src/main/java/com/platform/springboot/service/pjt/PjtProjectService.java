package com.platform.springboot.service.pjt;

import com.platform.springboot.entity.cfg.CfgDispatchModelConfig;
import com.platform.springboot.entity.pjt.GetPjtProjectList;
import com.platform.springboot.entity.pjt.PjtProject;
import com.platform.springboot.entity.pjt.PjtProjectParam;
import com.platform.springboot.entity.sys.SysCompanyUsers;
import com.platform.springboot.mapper.cfg.CfgDispatchModelConfigMapper;
import com.platform.springboot.mapper.pjt.PjtProjectMapper;
import com.platform.springboot.mapper.sys.SysCompanyUsersMapper;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import com.platform.springboot.mapper.pjt.PjtProjectMapper;
import com.platform.springboot.mapper.sys.SysCompanyUsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: zhangshuai
 * @create: 2018-12-18 16:22
 */
@Service
public class PjtProjectService {

    @Autowired
    private PjtProjectMapper mapper;

    @Autowired
    private SysCompanyUsersMapper sysCompanyUsersMapper;

    @Autowired
    private CfgDispatchModelConfigMapper cfgDispatchModelConfigMapper;

    public Result handle(PjtProject pjtProject, Integer userId) {
        Date now = new Date();

        if(pjtProject.getFlagDefault() != false){
            GetPjtProjectList defalut =  mapper.selectDefaultByType(userId);
            if(defalut != null){
                return ResultUtil.validateError("已有默认项目不可重复创建！");
            }
        }else{
            if(pjtProject.getCompanyId() == 0 || pjtProject.getCompanyId() == null){
                return ResultUtil.validateError("请选择雇主！");
            }
            if(pjtProject.getProjectName().equals("") || pjtProject.getProjectName() == null){
                return ResultUtil.validateError("请填写项目名称！");
            }
            if(pjtProject.getProjectCode().equals("") || pjtProject.getProjectCode() == null){
                return ResultUtil.validateError("请填写项目编号！");
            }
            //根据项目名和项目编号查询
            PjtProject nameAndCode =  mapper.selectByNameAndCode(pjtProject);
            if(nameAndCode != null){
                return ResultUtil.validateError("项目名称、项目编号不可重复！");
            }
        }
        SysCompanyUsers sysUsers = sysCompanyUsersMapper.selectByPrimaryKey(userId);
        pjtProject.setFlagAvailable(true);
        pjtProject.setFlagDeleted(false);
        if(sysUsers != null){
            pjtProject.setBelongObjectId(sysUsers.getActObjectId());
            pjtProject.setBelongObjectType(sysUsers.getActType());
        }
        if(pjtProject.getId() == 0){//新增项目
            pjtProject.setCreatePerson(userId);
            pjtProject.setCreateTime(now);
            pjtProject.setFlagAvailable(true);
            mapper.insertSelective(pjtProject);
            return ResultUtil.successMsg("新增项目成功！");
        }else {//编辑项目
            pjtProject.setUpdatePerson(userId);
            pjtProject.setUpdateTime(now);
            mapper.updateByPrimaryKeySelective(pjtProject);
            return ResultUtil.successMsg("编辑项目成功！");
        }
    }


    /**
     * 查询项目列表
     * @param param
     * @param userId
     * @return
     */
    public Result list(PjtProjectParam param, int userId) {
        param.setCreatePerson(userId);
        return ResultUtil.success(mapper.projectList(param));
    }


    /**
     * 新增模板查询项目列表
     * @param param
     * @param userId
     * @return
     */
    public Result newModelList(PjtProjectParam param, int userId) {
        param.setCreatePerson(userId);
        return ResultUtil.success(mapper.newModelList(param));
    }


    /**
     * 查看项目信息
     * @param id
     * @return
     */
    public Result show(Integer id) {
        return ResultUtil.success(mapper.show(id));
    }


    /**
     * 删除项目
     * @param id
     * @return
     */
    public Result delete(Integer id) {
        Date now = new Date();
        if(id != 0 ){
            //查询该项目下是否有模板
            List<CfgDispatchModelConfig> modelConfig = cfgDispatchModelConfigMapper.selectByProjectId(id);
            if(modelConfig.size() >= 1){
                return ResultUtil.errorBusinessMsg("项目已有模板，不能删除！");
            }
            PjtProject param = new PjtProject();
            param.setFlagDeleted(true);
            param.setId(id);
            param.setUpdateTime(now);
            mapper.updateByPrimaryKeySelective(param);
            return ResultUtil.successMsg("删除成功！");
        }
        return ResultUtil.errorBusinessMsg("删除失败！");
    }


    /**
     * 启用/停用项目
     * @param id
     * @param flagAvailable
     * @return
     */
    public Result isStart(Integer id, int flagAvailable) {
        PjtProject project = new PjtProject();
        project.setId(id);
        if(flagAvailable == 1){
            project.setFlagAvailable(true);
            mapper.updateByPrimaryKeySelective(project);
            return ResultUtil.successMsg("该项目已启用！");
        }else{
            project.setFlagAvailable(false);
            mapper.updateByPrimaryKeySelective(project);
            return ResultUtil.successMsg("该项目已停用！");
        }
    }

}
