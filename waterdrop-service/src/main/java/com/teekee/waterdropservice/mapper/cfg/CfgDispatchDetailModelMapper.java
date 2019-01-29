package com.teekee.waterdropservice.mapper.cfg;

import com.teekee.waterdropservice.entity.cfg.CfgDispatchDetailModel;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

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