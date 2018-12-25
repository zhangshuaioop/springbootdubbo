package com.platform.springboot.mapper.cfg;

import com.github.pagehelper.Page;
import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.cfg.*;
import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.cfg.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CfgDispatchModelConfigMapper extends BaseMapper<CfgDispatchModelConfig> {

    int insertSelective(CfgDispatchModelConfig record);

    CfgDispatchModelConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CfgDispatchModelConfig record);
    /**
     * 根据模板名称查询
     * @param cfgDispatchModelConfig
     * @return
     * @Author:Niting
     * @Date:2018/09/29
     */
    CfgDispatchModelConfig selectByModelName(CfgDispatchModelConfig cfgDispatchModelConfig);
    /**
     * 查询模板列表
     * @param cfgDispatchModelConfigParam
     * @return
     * @Author:Niting
     * @Date:2018/09/29
     */
    Page<GetCfgDispatchModelConfigList> list(CfgDispatchModelConfigParam cfgDispatchModelConfigParam);
    /**
     * 查看模板信息
     * @param id
     * @return
     * @Author:Niting
     * @Date:2018/09/29
     */
    CfgDispatchModelConfigShow show(int id);
    /**
     * 查看模板创建人列表
     * @param userId
     * @return
     * @Author:Niting
     * @Date:2018/09/29
     */
    Page<GetCfgDispatchModelConfigPersonList> selectByCreatePerson(int userId);
    /**
     * 查询已启用模板列表
     * @param projectId
     * @return
     * @Author:Niting
     * @Date:2018/09/30
     */
    List<CfgDispatchModelConfig> selectByUseModelList(int projectId);
    /**
     * 查询模板列表
     * @param
     * @return
     * @Author:Niting
     * @Date:2018/10/11
     */
    List<CfgDispatchModelConfig> selectByProjectId(Integer projectId);
    /**
     * 派工时查询项目-模板列表
     * @param companyId
     * @param createPerson
     * @return
     * @Author:Niting
     * @Date:2018/09/29
     */
    List<CfgDispatchModelConfig> pList(@Param("companyId") int companyId, @Param("createPerson") int createPerson);
}