package com.platform.springboot.mapper.cfg;

import com.platform.springboot.entity.cfg.CfgDeviceTypeCatalog;
import com.platform.springboot.entity.cfg.CfgDeviceTypeCatalog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CfgDeviceTypeCatalogMapper {

    int insertSelective(CfgDeviceTypeCatalog record);

    CfgDeviceTypeCatalog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CfgDeviceTypeCatalog record);

    List<CfgDeviceTypeCatalog> queryByParentId(List<Integer> parentIdList);

}