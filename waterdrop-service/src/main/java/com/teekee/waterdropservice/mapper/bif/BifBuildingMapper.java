package com.teekee.waterdropservice.mapper.bif;

import com.teekee.waterdropservice.entity.bif.BifAddressDetail;
import com.teekee.waterdropservice.entity.bif.BifBuilding;
import com.teekee.waterdropservice.entity.bif.ret.BifBuilding.ListRet;
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