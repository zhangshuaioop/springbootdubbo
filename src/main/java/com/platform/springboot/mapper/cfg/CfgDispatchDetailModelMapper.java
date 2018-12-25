package com.platform.springboot.mapper.cfg;

import com.github.pagehelper.Page;
import com.platform.springboot.entity.cfg.CfgDispatchDetailModel;
import com.platform.springboot.entity.cfg.CfgDispatchDetailModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CfgDispatchDetailModelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CfgDispatchDetailModel record);

    int insertSelective(CfgDispatchDetailModel record);

    CfgDispatchDetailModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CfgDispatchDetailModel record);

    int updateByPrimaryKey(CfgDispatchDetailModel record);

    /**
     * 查询派工类型模板列表
     *
     * @return
     * @Author Niting
     * @date 2018年5月14日
     * @param
     * @param cfgDispatchDetailModel
     */
    Page<CfgDispatchDetailModel> selectModelList(CfgDispatchDetailModel cfgDispatchDetailModel);
    /**
     * 查询所有版本历史列表
     *
     * @return
     * @Author Niting
     * @date 2018年5月14日
     * @param
     */
    Page<CfgDispatchDetailModel> selectAllVersionList(CfgDispatchDetailModel cfgDispatchDetailModel);
}