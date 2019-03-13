package com.company.springboot.mapper.bif;

import com.company.springboot.entity.bif.BifBuildingApply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BifBuildingApplyMapper {

    int insertSelective(BifBuildingApply record);

    BifBuildingApply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BifBuildingApply record);

    List<BifBuildingApply> applyBuildingList(BifBuildingApply record);

}