package com.platform.springboot.mapper.dco;

import com.platform.springboot.entity.dco.DcoDemandCustomerOrderUploadFile;
import com.platform.springboot.entity.dco.DcoDemandCustomerOrderUploadFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DcoDemandCustomerOrderUploadFileMapper {
    int insertSelective(DcoDemandCustomerOrderUploadFile record);

    DcoDemandCustomerOrderUploadFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DcoDemandCustomerOrderUploadFile record);

    List<DcoDemandCustomerOrderUploadFile> getListByOperationId(Integer operationId);

}