package com.platform.springboot.mapper.cfg;

import com.platform.springboot.entity.cfg.CfgDispatchWarningStatus;
import com.platform.springboot.entity.cfg.CfgDispatchWarningStatus;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CfgDispatchWarningStatusMapper {


    /**
     * 根据进度百分百查询 预警配置信息
     * @return
     * @Author zhanghao
     * @date 2018-11-7
     *
     */
    List<CfgDispatchWarningStatus> getCfgDispatchWarningStatus(Integer workSchedule);
}