package com.teekee.waterdropservice.service.pjt;

import com.teekee.commoncomponets.utils.PageInfo;
import com.teekee.waterdropservice.entity.cfg.CfgDispatchModelConfig;
import com.teekee.waterdropservice.entity.pjt.PjtProject;
import com.teekee.waterdropservice.entity.pjt.PjtProjectParam;
import com.teekee.waterdropservice.mapper.cfg.CfgDispatchModelConfigMapper;
import com.teekee.waterdropservice.mapper.pjt.PjtProjectMapper;
import com.teekee.commoncomponets.utils.Result;
import com.teekee.commoncomponets.utils.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: zhangshuai
 * @create: 2018-12-18 16:22
 */
@Service
public class PjtProjectService {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private PjtProjectMapper mapper;

    @Autowired
    private CfgDispatchModelConfigMapper cfgDispatchModelConfigMapper;

    public Result handle(PjtProject pjtProject, Integer userId) {
        Date now = new Date();

        if (pjtProject.getCompanyId() == null || pjtProject.getCompanyId() == 0) {
            return ResultUtil.validateError("参数错误 companyId");
        }
        if ( pjtProject.getProjectName() == null || pjtProject.getProjectName().equals("") ) {
            return ResultUtil.validateError("请填写项目名称！");
        }
        if (pjtProject.getProjectCode() == null || pjtProject.getProjectCode().equals("") ) {
            return ResultUtil.validateError("请填写项目编号！");
        }

        if(pjtProject.getFlagDefault()){
            logger.info("查询公司是否有默认项目 companyId:" + pjtProject.getCompanyId());
            List<PjtProject> list = mapper.findDefaultByCompanyId(pjtProject.getCompanyId());
            if (list != null || list.size() > 0) {
                return ResultUtil.errorBusinessMsg("默认项目已存在");
            }
        }
        //根据项目名和项目编号查询
        PjtProject nameAndCode = mapper.selectByNameAndCode(pjtProject);
        if (nameAndCode != null) {
            return ResultUtil.validateError("项目名称、项目编号不可重复！");
        }
        pjtProject.setFlagAvailable(true);
        pjtProject.setFlagDeleted(false);
        pjtProject.setBelongObjectType("DEMAND");
        pjtProject.setUpdatePerson(userId);
        pjtProject.setUpdateTime(now);
        if (pjtProject.getId() == null || pjtProject.getId() == 0) {//新增项目
            pjtProject.setCreatePerson(userId);
            pjtProject.setCreateTime(now);
            pjtProject.setFlagAvailable(true);
            mapper.insertSelective(pjtProject);
            return ResultUtil.successMsg("新增项目成功！");
        } else {//编辑项目
            mapper.updateByPrimaryKeySelective(pjtProject);
            return ResultUtil.successMsg("编辑项目成功！");
        }
    }

    /**
     * 查询项目列表
     *
     * @param param
     * @return
     */
    public Result list(PjtProjectParam param) {

        if (param.getPageNum() != null && param.getPageSize() != null) {
            PageHelper.startPage(param.getPageNum(), param.getPageSize());
            Page<PjtProject> persons = mapper.projectList(param);
            PageInfo<PjtProject> pageInfo = new PageInfo<>(persons);
            return ResultUtil.success(pageInfo);
        } else {
            List<PjtProject> persons = mapper.projectList(param);
            return ResultUtil.success(persons);
        }
    }


    /**
     * 新增模板查询项目列表
     *
     * @param param
     * @param userId
     * @return
     */
    public Result newModelList(PjtProjectParam param, int userId) {
        return ResultUtil.success(mapper.newModelList(param));
    }


    /**
     * 查看项目信息
     *
     * @param id
     * @return
     */
    public Result show(Integer id) {
        return ResultUtil.success(mapper.show(id));
    }


    /**
     * 删除项目
     *
     * @param id
     * @return
     */
    public Result delete(Integer id) {
        Date now = new Date();
        if (id != 0) {
            //查询该项目下是否有模板
            List<CfgDispatchModelConfig> modelConfig = cfgDispatchModelConfigMapper.selectByProjectId(id);
            if (modelConfig.size() >= 1) {
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
     *
     * @param id
     * @param flagAvailable
     * @return
     */
    public Result isStart(Integer id, int flagAvailable) {
        PjtProject project = new PjtProject();
        project.setId(id);
        if (flagAvailable == 1) {
            project.setFlagAvailable(true);
            mapper.updateByPrimaryKeySelective(project);
            return ResultUtil.successMsg("该项目已启用！");
        } else {
            project.setFlagAvailable(false);
            mapper.updateByPrimaryKeySelective(project);
            return ResultUtil.successMsg("该项目已停用！");
        }
    }

}
