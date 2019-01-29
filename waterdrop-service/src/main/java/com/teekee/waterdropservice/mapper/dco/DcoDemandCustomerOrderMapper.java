package com.teekee.waterdropservice.mapper.dco;

import com.teekee.waterdropservice.entity.dco.DcoDemandCustomerOrder;
import com.teekee.waterdropservice.entity.dco.DcoDemandCustomerOrderDetail;
import com.teekee.waterdropservice.entity.dco.DcoDemandCustomerOrderDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DcoDemandCustomerOrderMapper {
    int insertSelective(DcoDemandCustomerOrder record);

    DcoDemandCustomerOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DcoDemandCustomerOrder record);

    List<DcoDemandCustomerOrderDto> getActiveOrderByObject(DcoDemandCustomerOrderDto record);

    List<DcoDemandCustomerOrderDto> getInactiveOrderByObject(DcoDemandCustomerOrderDto record);

    DcoDemandCustomerOrderDetail getOrderByOrderId(Integer orderId);

}