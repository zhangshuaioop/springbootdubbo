package com.platform.springboot.mapper.fdp;

import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.fdp.FdpDispatchJobContent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhanghao
 * @Title: FdpDispatchJobContentMapper
 * @ProjectName BlueOcean
 * @date 2019/1/9下午1:37
 */
@Mapper
public interface FdpDispatchJobContentMapper extends BaseMapper<FdpDispatchJobContent> {

    int insertSelective(FdpDispatchJobContent record);

    FdpDispatchJobContent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FdpDispatchJobContent record);
    /**
     * 查询历史工作内容
     * @param id
     * @return
     * @Author:Niting
     * @Date:2018/10/16
     */
    List<FdpDispatchJobContent> selectByHistoryId(Integer id);

    /**
     * 将工单之前的工作内容改为无效
     * @param orderId
     * @return
     * @Author:zhanghao
     * @Date:2018/12/6
     */
    int updateFlagIsLastByFaultOrderId(@Param("dispatchOrderId") int orderId);

    List<FdpDispatchJobContent> seleteByDispatchRequestId(@Param("faultDispatchRequestId")Integer faultDispatchRequestId);

}
