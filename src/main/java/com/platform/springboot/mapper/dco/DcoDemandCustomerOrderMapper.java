package com.platform.springboot.mapper.dco;

import com.platform.springboot.entity.dco.DcoDemandCustomerOrder;
import com.platform.springboot.entity.dco.DcoDemandCustomerOrderDetail;
import com.platform.springboot.entity.dco.DcoDemandCustomerOrderDto;
import com.platform.springboot.entity.dco.DcoDemandCustomerOrder;
import com.platform.springboot.entity.dco.DcoDemandCustomerOrderDetail;
import com.platform.springboot.entity.dco.DcoDemandCustomerOrderDto;
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