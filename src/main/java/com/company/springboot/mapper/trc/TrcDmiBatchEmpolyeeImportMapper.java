package com.company.springboot.mapper.trc;

import com.company.springboot.entity.trc.TrcDmiBatchEmpolyeeImport;
import com.company.springboot.entity.trc.TrcDmiBatchEmpolyeeImport;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TrcDmiBatchEmpolyeeImportMapper {

    int insertSelective(TrcDmiBatchEmpolyeeImport record);

    TrcDmiBatchEmpolyeeImport selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrcDmiBatchEmpolyeeImport record);

    TrcDmiBatchEmpolyeeImport selectByBatchInsertCode(String batchInsertCode);

}