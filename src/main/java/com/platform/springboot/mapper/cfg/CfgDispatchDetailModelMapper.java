package com.platform.springboot.mapper.cfg;

import com.github.pagehelper.Page;
import com.platform.springboot.entity.cfg.CfgDispatchDetailModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhanghao
 * @Title: CfgDispatchDetailModelMapper
 * @ProjectName BlueOcean
 * @Description: 派工模板
 * @date 2019/1/9下午3:30
 */
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


    Page<CfgDispatchDetailModel> selectByModelUserType(CfgDispatchDetailModel cfgDispatchDetailModel);
}
