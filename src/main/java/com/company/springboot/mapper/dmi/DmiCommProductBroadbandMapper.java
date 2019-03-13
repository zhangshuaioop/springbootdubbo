package com.company.springboot.mapper.dmi;

import com.company.springboot.entity.dmi.DmiCommProductBroadbandWithBLOBs;
import com.company.springboot.entity.dmi.DmiCommProductBroadbandWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DmiCommProductBroadbandMapper {

    int insertSelective(DmiCommProductBroadbandWithBLOBs record);

    DmiCommProductBroadbandWithBLOBs selectByPrimaryKey(Integer id);

    DmiCommProductBroadbandWithBLOBs selectByProductId(Integer productId);

    int updateByPrimaryKeySelective(DmiCommProductBroadbandWithBLOBs record);

    int updateByProductIdSelective(DmiCommProductBroadbandWithBLOBs record);

    List<DmiCommProductBroadbandWithBLOBs> selectAllByProductId(Integer storeCommProductId);
}