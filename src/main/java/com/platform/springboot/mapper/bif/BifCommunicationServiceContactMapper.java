package com.platform.springboot.mapper.bif;

import com.platform.springboot.entity.bif.BifCommunicationServiceContact;
import com.platform.springboot.entity.bif.BifCommunicationServiceContact;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BifCommunicationServiceContactMapper {

    int insertSelective(BifCommunicationServiceContact record);

    BifCommunicationServiceContact selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BifCommunicationServiceContact record);

    List<BifCommunicationServiceContact> listByServiceId(Integer serviceId);

    List<BifCommunicationServiceContact> list(BifCommunicationServiceContact record);

    BifCommunicationServiceContact showByService(BifCommunicationServiceContact record);

}