package com.company.springboot.mapper.bif;

import com.company.springboot.entity.bif.BifAddressDetail;
import com.company.springboot.entity.bif.BifBuilding;
import com.company.springboot.entity.bif.ret.BifBuilding.ListRet;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BifBuildingMapper {

    int insertSelective(BifBuilding record);

    BifBuilding selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BifBuilding record);

    List<BifBuilding> selectLimitList(BifAddressDetail bifAddressDetail);

    Page<ListRet> list(BifBuilding bifBuilding);

    Page<ListRet> listAllAddress(BifBuilding bifBuilding);

}