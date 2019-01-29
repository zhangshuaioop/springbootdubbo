package com.teekee.waterdropservice.mapper.bif;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.waterdropservice.entity.bif.BifCommunicationService;
import com.github.pagehelper.Page;
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