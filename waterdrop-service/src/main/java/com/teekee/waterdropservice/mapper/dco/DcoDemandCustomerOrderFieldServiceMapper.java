package com.teekee.waterdropservice.mapper.dco;

import com.teekee.waterdropservice.entity.dco.DcoDemandCustomerOrderFieldService;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DcoDemandCustomerOrderFieldServiceMapper {

    int insertSelective(DcoDemandCustomerOrderFieldService record);

    DcoDemandCustomerOrderFieldService getByOperationId(Integer operationId);
}