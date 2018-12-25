package com.platform.springboot.mapper.dco;

import com.platform.springboot.entity.dco.DcoDemandCustomerOrderFieldService;
import com.platform.springboot.entity.dco.DcoDemandCustomerOrderFieldService;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DcoDemandCustomerOrderFieldServiceMapper {

    int insertSelective(DcoDemandCustomerOrderFieldService record);

    DcoDemandCustomerOrderFieldService getByOperationId(Integer operationId);
}