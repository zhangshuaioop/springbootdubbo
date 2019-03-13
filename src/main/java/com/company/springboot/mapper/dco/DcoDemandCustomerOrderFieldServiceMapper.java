package com.company.springboot.mapper.dco;

import com.company.springboot.entity.dco.DcoDemandCustomerOrderFieldService;
import com.company.springboot.entity.dco.DcoDemandCustomerOrderFieldService;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DcoDemandCustomerOrderFieldServiceMapper {

    int insertSelective(DcoDemandCustomerOrderFieldService record);

    DcoDemandCustomerOrderFieldService getByOperationId(Integer operationId);
}