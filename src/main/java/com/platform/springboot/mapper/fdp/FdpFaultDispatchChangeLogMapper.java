package com.platform.springboot.mapper.fdp;

import com.platform.springboot.entity.fdp.FdpFaultDispatchChangeLog;
import com.platform.springboot.entity.fdp.FdpFaultDispatchHrRelation;
import com.platform.springboot.entity.fdp.FdpFaultDispatchChangeLog;
import com.platform.springboot.entity.fdp.FdpFaultDispatchHrRelation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FdpFaultDispatchChangeLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FdpFaultDispatchChangeLog record);

    int insertSelective(FdpFaultDispatchChangeLog record);

    FdpFaultDispatchChangeLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FdpFaultDispatchChangeLog record);

    int updateByPrimaryKey(FdpFaultDispatchChangeLog record);

    void updateHrById(FdpFaultDispatchHrRelation hrRelation);

    void selectIdByOrderId(Integer id);
    /**
     * 查询更换信息日志
     *
     * @param orderId
     * @create 2018年5月2日
     * @author Niting
     * @return
     */
    List<FdpFaultDispatchChangeLog> getDispatchChangeLog(int orderId);
}