package com.teekee.blueoceanservice.mapper.fdp;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.blueoceanservice.entity.fdp.FdpFaultDispatchTransferLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhanghao
 * @Title: FdpFaultDispatchTransferLogMapper
 * @ProjectName BlueOcean
 * @Description: TODO
 * @date 2019/1/3下午5:36
 */
@Mapper
public interface FdpFaultDispatchTransferLogMapper extends BaseMapper<FdpFaultDispatchTransferLog> {

    int insertSelective(FdpFaultDispatchTransferLog record);

    FdpFaultDispatchTransferLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FdpFaultDispatchTransferLog record);

    List<FdpFaultDispatchTransferLog> show(Integer dispatchOrderId);

    void insertTransferLog(HashMap mapStransfer);

    void insertDispatchTransferLog(Map mapStransfer);
}
