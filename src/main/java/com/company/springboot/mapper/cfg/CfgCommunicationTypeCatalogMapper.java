package com.company.springboot.mapper.cfg;

import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.cfg.CfgCommunicationTypeCatalog;
import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.cfg.CfgCommunicationTypeCatalog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CfgCommunicationTypeCatalogMapper extends BaseMapper<CfgCommunicationTypeCatalog> {

    int insertSelective(CfgCommunicationTypeCatalog record);

    CfgCommunicationTypeCatalog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CfgCommunicationTypeCatalog record);

    List<CfgCommunicationTypeCatalog> queryByParentId(List<Integer> parentIdList);

    List<CfgCommunicationTypeCatalog> queryByLevelOne();
}