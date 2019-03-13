package com.company.springboot.mapper.bif;

import com.company.springboot.base.BaseMapper;
import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.bif.BifMd5CodePool;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BifMd5CodePoolMapper extends BaseMapper<BifMd5CodePool> {
    int deleteByPrimaryKey(Integer id);

    int insert(BifMd5CodePool record);

    int insertSelective(BifMd5CodePool record);

    BifMd5CodePool selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BifMd5CodePool record);

    int updateByPrimaryKey(BifMd5CodePool record);

    Integer selectMd5(String storeToken);
}