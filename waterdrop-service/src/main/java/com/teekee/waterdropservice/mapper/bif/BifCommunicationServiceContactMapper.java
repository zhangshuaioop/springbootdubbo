package com.teekee.waterdropservice.mapper.bif;

import com.teekee.waterdropservice.entity.bif.BifCommunicationServiceContact;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BifCommunicationServiceContactMapper {

    int insertSelective(BifCommunicationServiceContact record);

    BifCommunicationServiceContact selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BifCommunicationServiceContact record);

    Page<BifCommunicationServiceContact> listByServiceId(Integer serviceId);

    Page<BifCommunicationServiceContact> list(BifCommunicationServiceContact record);

    BifCommunicationServiceContact showByService(BifCommunicationServiceContact record);

}