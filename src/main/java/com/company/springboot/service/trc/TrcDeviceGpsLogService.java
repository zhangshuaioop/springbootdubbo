package com.company.springboot.service.trc;

import com.company.springboot.entity.trc.TrcDeviceGpsLog;
import com.company.springboot.mapper.trc.TrcDeviceGpsLogMapper;
import com.company.springboot.utils.Result;
import com.company.springboot.utils.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class TrcDeviceGpsLogService {

    @Resource
    private TrcDeviceGpsLogMapper mapper;

    public Result list(Integer orderId) {
      List<TrcDeviceGpsLog> list=  mapper.selectByOrderId(orderId);
      return ResultUtil.success(list);
    }
}
