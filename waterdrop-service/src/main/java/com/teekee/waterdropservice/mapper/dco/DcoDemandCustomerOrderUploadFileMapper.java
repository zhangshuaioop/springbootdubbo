package com.teekee.waterdropservice.mapper.dco;

import com.teekee.waterdropservice.entity.dco.DcoDemandCustomerOrderUploadFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DcoDemandCustomerOrderUploadFileMapper {
    int insertSelective(DcoDemandCustomerOrderUploadFile record);

    DcoDemandCustomerOrderUploadFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DcoDemandCustomerOrderUploadFile record);

    List<DcoDemandCustomerOrderUploadFile> getListByOperationId(Integer operationId);

}