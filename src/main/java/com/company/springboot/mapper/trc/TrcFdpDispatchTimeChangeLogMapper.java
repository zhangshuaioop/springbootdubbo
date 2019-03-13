package com.company.springboot.mapper.trc;

import com.company.springboot.entity.trc.TrcFdpDispatchTimeChangeLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface TrcFdpDispatchTimeChangeLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TrcFdpDispatchTimeChangeLog record);

    int insertSelective(TrcFdpDispatchTimeChangeLog record);

    TrcFdpDispatchTimeChangeLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrcFdpDispatchTimeChangeLog record);

    int updateByPrimaryKey(TrcFdpDispatchTimeChangeLog record);

    List<TrcFdpDispatchTimeChangeLog> selectByOrderId(int orderId);
}