package com.platform.springboot.mapper.bif;

import com.platform.springboot.entity.bif.BifAddressDetail;
import com.platform.springboot.entity.bif.BifBuilding;
import com.platform.springboot.entity.bif.ret.BifBuilding.ListRet;
import com.platform.springboot.entity.bif.BifAddressDetail;
import com.platform.springboot.entity.bif.BifBuilding;
import com.platform.springboot.entity.bif.ret.BifBuilding.ListRet;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BifBuildingMapper {

    int insertSelective(BifBuilding record);

    BifBuilding selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BifBuilding record);

    List<BifBuilding> selectLimitList(BifAddressDetail bifAddressDetail);

    List<ListRet> list(BifBuilding bifBuilding);

    List<ListRet> listAllAddress(BifBuilding bifBuilding);

}