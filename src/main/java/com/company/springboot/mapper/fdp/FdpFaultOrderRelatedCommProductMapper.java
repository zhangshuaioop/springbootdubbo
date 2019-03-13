package com.company.springboot.mapper.fdp;

import com.company.springboot.entity.fdp.FdpFaultOrderProcess;
import com.company.springboot.entity.fdp.FdpFaultOrderRelatedCommProduct;
import com.company.springboot.entity.fdp.FdpFaultOrderProcess;
import com.company.springboot.entity.fdp.FdpFaultOrderRelatedCommProduct;
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