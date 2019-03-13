package com.company.springboot.mapper.wp;

import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.wp.WpFrameProcess;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WpFrameProcessMapper extends BaseMapper<WpFrameProcess> {


    /**
     * 根据orderId查询
     * @param orderId
     * @return
     */
    WpFrameProcess selectByOrderId(Integer orderId);
}