package com.teekee.waterdropservice.mapper.dco;

import com.teekee.waterdropservice.entity.dco.DcoDemandCustomerOrderOperation;
import com.teekee.waterdropservice.entity.dco.DcoDemandCustomerOrderOperationDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DcoDemandCustomerOrderOperationMapper {

    int insertSelective(DcoDemandCustomerOrderOperation record);

    DcoDemandCustomerOrderOperation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DcoDemandCustomerOrderOperation record);

    List<DcoDemandCustomerOrderOperationDetail> getOrderRecordByOrderId(Integer orderId);
}