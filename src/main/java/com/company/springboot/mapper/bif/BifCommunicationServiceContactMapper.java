package com.company.springboot.mapper.bif;

import com.company.springboot.entity.bif.BifCommunicationServiceContact;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BifCommunicationServiceContactMapper {

    int insertSelective(BifCommunicationServiceContact record);

    BifCommunicationServiceContact selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BifCommunicationServiceContact record);

    Page<BifCommunicationServiceContact> listByServiceId(BifCommunicationServiceContact contact);

    Page<BifCommunicationServiceContact> list(BifCommunicationServiceContact record);

    BifCommunicationServiceContact showByService(BifCommunicationServiceContact record);

}