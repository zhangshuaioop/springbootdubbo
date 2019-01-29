package com.teekee.waterdropservice.mapper.dmi;

import com.teekee.waterdropservice.entity.dmi.DmiContactStoreRelation;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface DmiContactStoreRelationMapper {
    /**
     * 绑定联系人门店
     *
     * @param record
     * @author liukan
     * @create 2018年04月25日 10:43
     * @return Map
     */
    int insertSelective(DmiContactStoreRelation record);

    Map<String,Object> selectByPrimaryKey(Integer id);

    List<Map<String,Object>> selectListByStoreId(Integer id);

    List<Map<String,Object>> selectMajorListByStoreId(Integer id);

    int updateByPrimaryKeySelective(DmiContactStoreRelation record);

    int resetIsMajorByStoreId(Integer storeId);

    int getCountByContactId(Integer contactId);

    int getRelationByConStore(HashMap<String, Object> map);

    int hasMajorByStoreId(Integer storeId);

    List<DmiContactStoreRelation> selectMajorList(Integer id);

    List<DmiContactStoreRelation> selectAllStore(Integer storeId);

}