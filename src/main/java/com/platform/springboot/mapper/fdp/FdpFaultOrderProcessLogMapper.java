package com.platform.springboot.mapper.fdp;

import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.fdp.FdpFaultOrderProcessLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zhanghao
 * @Title: FdpFaultOrderProcessLogMapper
 * @ProjectName BlueOcean
 * @Description: 订单日志
 * @date 2019/1/3下午4:35
 */
@Mapper
public interface FdpFaultOrderProcessLogMapper extends BaseMapper<FdpFaultOrderProcessLog> {


    /**
     * 新增故障工单流程日志
     *
     * @param record

     * @author liukan
     * @create 2018年04月25日 10:39
     * @return
     */
    int insertSelective(FdpFaultOrderProcessLog record);

    FdpFaultOrderProcessLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FdpFaultOrderProcessLog record);

    List<FdpFaultOrderProcessLog> getFaultOrderProcess(Integer faultOrderProcessId);

    int insertFaultConfirmbyTheOtherParty(FdpFaultOrderProcessLog record);
}
