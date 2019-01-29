package com.teekee.waterdropservice.mapper.fdp;

import com.teekee.waterdropservice.entity.fdp.FdpFaultOrderProcess;
import com.teekee.waterdropservice.entity.fdp.FdpFaultOrderRelatedCommProduct;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FdpFaultOrderRelatedCommProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FdpFaultOrderRelatedCommProduct record);

    int insertSelective(FdpFaultOrderRelatedCommProduct record);

    FdpFaultOrderRelatedCommProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FdpFaultOrderRelatedCommProduct record);

    int updateByPrimaryKey(FdpFaultOrderRelatedCommProduct record);

    List<FdpFaultOrderRelatedCommProduct> selectProductList(int processId);



    void updateDelete(Integer faultOrderProcessId);

    void deleteByProcess(FdpFaultOrderProcess process);

    List<FdpFaultOrderRelatedCommProduct> selectByProcessId(Integer id);
}