package com.company.springboot.mapper.bif;

import com.github.pagehelper.Page;
import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.bif.BifCommunicationService;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BifCommunicationServiceMapper extends BaseMapper<BifCommunicationService> {
    int insertSelective(BifCommunicationService record);

    BifCommunicationService selectByPrimaryKey(Integer id);

    List<BifCommunicationService> selectList();

    Page<BifCommunicationService> selectListCustomize(BifCommunicationService bifCommunicationService);

    int updateByPrimaryKeySelective(BifCommunicationService record);
}