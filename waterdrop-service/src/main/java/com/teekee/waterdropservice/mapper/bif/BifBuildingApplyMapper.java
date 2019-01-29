package com.teekee.waterdropservice.mapper.bif;

import com.teekee.waterdropservice.entity.bif.BifBuildingApply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BifBuildingApplyMapper {

    int insertSelective(BifBuildingApply record);

    BifBuildingApply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BifBuildingApply record);

    List<BifBuildingApply> applyBuildingList(BifBuildingApply record);

}