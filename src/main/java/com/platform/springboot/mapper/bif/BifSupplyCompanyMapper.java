package com.platform.springboot.mapper.bif;

import com.platform.springboot.entity.bif.BifSupplyCompany;
import com.platform.springboot.entity.bif.BifSupplyCompany;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BifSupplyCompanyMapper {

    int insertSelective(BifSupplyCompany record);

    BifSupplyCompany selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BifSupplyCompany record);

    List<BifSupplyCompany> selectAll();

}