package com.teekee.waterdropservice.mapper.fdp;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.waterdropservice.entity.fdp.FdpDispatchProcessLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FdpDispatchProcessLogMapper extends BaseMapper<FdpDispatchProcessLog> {
    int deleteByPrimaryKey(Integer id);

    int insert(FdpDispatchProcessLog record);

    int insertSelective(FdpDispatchProcessLog record);

    FdpDispatchProcessLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FdpDispatchProcessLog record);

    int updateByPrimaryKey(FdpDispatchProcessLog record);
    /**
     * 查看派工流程
     * @param orderId
     * @return
     * @Author:Niting
     * @Date:2018/09/20
     */
    List<FdpDispatchProcessLog> selectByOrderId(int orderId);
}