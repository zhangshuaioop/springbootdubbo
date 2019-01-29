package com.teekee.waterdropservice.mapper.cfg;

import com.teekee.waterdropservice.entity.cfg.CfgDispatchRequestModelImportConfig;

public interface CfgDispatchRequestModelImportConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CfgDispatchRequestModelImportConfig record);

    int insertSelective(CfgDispatchRequestModelImportConfig record);

    CfgDispatchRequestModelImportConfig selectByPrimaryKey(Integer id);
    /**
     * 查看requestModel
     *
     * @param importType
     * @author liukan
     * @create 2018年04月25日 10:39
     * @return requestModel
     */
    CfgDispatchRequestModelImportConfig selectRequestModel(String importType);

    int updateByPrimaryKeySelective(CfgDispatchRequestModelImportConfig record);

    int updateByPrimaryKey(CfgDispatchRequestModelImportConfig record);
}