package com.company.springboot.mapper.cfg;

import com.company.springboot.entity.cfg.CfgDeviceTypeCatalog;
import com.company.springboot.entity.cfg.CfgDeviceTypeCatalog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CfgDeviceTypeCatalogMapper {

    int insertSelective(CfgDeviceTypeCatalog record);

    CfgDeviceTypeCatalog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CfgDeviceTypeCatalog record);

    List<CfgDeviceTypeCatalog> queryByParentId(List<Integer> parentIdList);

}