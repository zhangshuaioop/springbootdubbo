package com.teekee.blueoceanservice.mapper.bif;


import com.github.pagehelper.Page;
import com.teekee.blueoceanservice.entity.bif.BifAddressDetail;
import com.teekee.blueoceanservice.entity.bif.BifBuilding;
import com.teekee.blueoceanservice.entity.bif.ret.BifBuilding.ListRet;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BifBuildingMapper {

    int insertSelective(BifBuilding record);

    BifBuilding selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BifBuilding record);

    List<BifBuilding> selectLimitList(BifAddressDetail bifAddressDetail);

    Page<ListRet> list(BifBuilding bifBuilding);

    List<ListRet> listAllAddress(BifBuilding bifBuilding);

}