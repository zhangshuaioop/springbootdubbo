package com.company.springboot.mapper.dco;

import com.company.springboot.entity.dco.DcoDemandCustomerOrderOperation;
import com.company.springboot.entity.dco.DcoDemandCustomerOrderOperationDetail;
import com.company.springboot.entity.dco.DcoDemandCustomerOrderOperation;
import com.company.springboot.entity.dco.DcoDemandCustomerOrderOperationDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DcoDemandCustomerOrderOperationMapper {

    int insertSelective(DcoDemandCustomerOrderOperation record);

    DcoDemandCustomerOrderOperation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DcoDemandCustomerOrderOperation record);

    List<DcoDemandCustomerOrderOperationDetail> getOrderRecordByOrderId(Integer orderId);
}