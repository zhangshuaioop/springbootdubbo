package com.teekee.waterdropservice.mapper.trc;

import com.teekee.waterdropservice.entity.trc.TrcDmiBatchEmpolyeeImport;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TrcDmiBatchEmpolyeeImportMapper {

    int insertSelective(TrcDmiBatchEmpolyeeImport record);

    TrcDmiBatchEmpolyeeImport selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrcDmiBatchEmpolyeeImport record);

    TrcDmiBatchEmpolyeeImport selectByBatchInsertCode(String batchInsertCode);

}