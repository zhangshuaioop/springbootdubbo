package com.company.springboot.mapper.pjt;

import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.cfg.CfgDispatchRoute;
import com.company.springboot.entity.pjt.GetPjtProjectList;
import com.company.springboot.entity.pjt.PjtProject;
import com.company.springboot.entity.pjt.PjtProjectParam;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PjtProjectMapper extends BaseMapper<PjtProject> {

    int insertSelective(PjtProject record);

    PjtProject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PjtProject record);
    /**
     * 查看项目列表
     * @param param
     * @return
     * @Author:Niting
     * @Date:2018/09/28
     */
    Page<PjtProject> list(PjtProjectParam param);
    /**
     * 查看项目信息
     * @param projectId
     * @return
     * @Author:Niting
     * @Date:2018/09/29
     */
    PjtProject show(Integer projectId);
    /**
     * 根据项目名以及项目编号查询
     * @param pjtProject
     * @return
     * @Author:Niting
     * @Date:2018/09/29
     */
    PjtProject selectByNameAndCode(PjtProject pjtProject);

    /**
     * 查询项目规则配置过滤列表
     * @return
     */
    List<PjtProject> selectByRoute(CfgDispatchRoute cfgDispatchRoute);

    /**
     * 查询是否有默认项目
     * @param createPerson
     * @return
     * @Author:Chenliwen
     * @Date:2018/11/27
     */
    GetPjtProjectList selectDefaultByType(int createPerson);

    /**
     * 查询默认项目
     * @param param
     * @return
     * @Author:Chenliwen
     * @Date:2018/11/28
     */
    List<PjtProject> selectDefaultByType(PjtProjectParam param);

    /**
     * 查询默认项目
     * @param param
     * @return
     * @Author:Chenliwen
     * @Date:2018/11/28
     */
    Page<PjtProject> projectList(PjtProjectParam param);


    /**
     * 新增模板查询项目列表
     * @param param
     * @return
     * @Author:Chenliwen
     * @Date:2018/11/28
     */
    List<PjtProject> newModelList(PjtProjectParam param);

    List<PjtProject> findDefaultByCompanyId(Integer companyId);
}