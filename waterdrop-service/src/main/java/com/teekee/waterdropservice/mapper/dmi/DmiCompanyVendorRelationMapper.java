package com.teekee.waterdropservice.mapper.dmi;

import com.teekee.waterdropservice.entity.dmi.DmiCompanyVendorRelation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DmiCompanyVendorRelationMapper {

    int insertSelective(DmiCompanyVendorRelation record);

    DmiCompanyVendorRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmiCompanyVendorRelation record);

    List<DmiCompanyVendorRelation> list(DmiCompanyVendorRelation record);

}