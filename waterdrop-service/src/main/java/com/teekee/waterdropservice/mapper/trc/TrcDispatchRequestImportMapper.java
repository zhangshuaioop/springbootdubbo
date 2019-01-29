package com.teekee.waterdropservice.mapper.trc;

import com.teekee.waterdropservice.entity.trc.TrcDispatchRequestImport;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TrcDispatchRequestImportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TrcDispatchRequestImport record);

    /**
     * 插入批次表
     *
     * @param record
     * @return
     * @author liukan
     * @create 2018年04月25日 10:39
     */
    int insertSelective(TrcDispatchRequestImport record);

    TrcDispatchRequestImport selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrcDispatchRequestImport record);

    int updateByPrimaryKey(TrcDispatchRequestImport record);

    /**
     * 导入员工回调
     *
     * @param batchInsertCode
     * @return
     * @author liukan
     * @create 2018年04月25日 10:39
     */
    TrcDispatchRequestImport selectByBatchInsertCode(String batchInsertCode);
}