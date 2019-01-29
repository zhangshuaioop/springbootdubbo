package com.teekee.blueoceanservice.mapper.fdp;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.blueoceanservice.entity.fdp.FdpFaultOrderDispatchRequest;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhanghao
 * @Title: FdpFaultOrderDispatchRequestMapper
 * @ProjectName BlueOcean
 * @Description: 采购订单
 * @date 2019/1/3下午2:47
 */
@Mapper
public interface FdpFaultOrderDispatchRequestMapper extends BaseMapper<FdpFaultOrderDispatchRequest> {

    Integer selectCreatePerson(Integer faultDispatchRequestId);

    String selectGzNumer(Integer faultDispatchRequestId);

    /**
     * 查看派工信息
     * @param requestId
     * @author zhanghao
     * @return
     */
    FdpFaultOrderDispatchRequest selectByPrimaryKeyNew(Integer requestId);
}
