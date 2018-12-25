package com.platform.springboot.mapper.dmi;

import com.platform.springboot.entity.dmi.DmiContactCompanyRelation;
import com.platform.springboot.entity.dmi.DmiContactCompanyRelation;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface DmiContactCompanyRelationMapper {

    int insertSelective(DmiContactCompanyRelation record);

    Map<String,Object> selectByPrimaryKey(Integer id);

    List<Map<String,Object>> selectContactCompanyRelationByCompanyId(Integer companyId);

    int updateByPrimaryKeySelective(DmiContactCompanyRelation record);

    int getCountByContactId(Integer id);

    int resetIsMajorByCompanyId(Integer id);

    int hasMajorByCompanyId(Integer id);

    int getRelationByConCom(HashMap<String, Object> map);

    List<DmiContactCompanyRelation> selectByCompanyId(Integer companyId);
}