package com.platform.springboot.mapper.cfg;

import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.cfg.CfgDispatchDetailConfig;
import com.platform.springboot.entity.cfg.CfgDispatchDetailModel;
import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.cfg.CfgDispatchDetailConfig;
import com.platform.springboot.entity.cfg.CfgDispatchDetailModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CfgDispatchDetailConfigMapper extends BaseMapper<CfgDispatchDetailConfig> {

    int insertSelective(CfgDispatchDetailConfig record);

    CfgDispatchDetailConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CfgDispatchDetailConfig record);
    /**
     * 查询父级
     * @param model   派工要求类型

     * @return
     * @Author Niting
     * @date 2018年5月15日
     *
     */
    List<CfgDispatchDetailConfig> basicList(CfgDispatchDetailModel model);
    /**
     * 查询子级
     * @param id
     * @return
     * @Author Niting
     * @date 2018年5月15日
     *
     */
    List<CfgDispatchDetailConfig> childList(Integer id);
    /**
     * 通过modelId 查询派工要求
     * @param modelId 模板id
     * @return
     * @Author Niting
     * @date 2018年5月15日
     *
     */
    List<CfgDispatchDetailConfig> selectDispatchConfigByModelId(Integer modelId);
    /**
     * 查询详细派工要求
     *
     * @return
     * @Author Niting
     * @date 2018年5月14日
     * @param id
     */
    CfgDispatchDetailConfig selectListById(int id);
}