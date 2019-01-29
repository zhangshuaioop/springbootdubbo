package com.teekee.blueoceanservice.mapper.cfg;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.blueoceanservice.entity.cfg.CfgDispatchWarningStatus;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zhanghao
 * @Title: CfgDispatchWarningStatusMapper
 * @ProjectName BlueOcean
 * @Description: 预警等级
 * @date 2019/1/3下午2:15
 */
@Mapper
public interface CfgDispatchWarningStatusMapper extends BaseMapper<CfgDispatchWarningStatus> {

    /**
     * 根据进度百分百查询 预警配置信息
     * @return
     * @Author zhanghao
     * @date 2018-11-7
     *
     */
    List<CfgDispatchWarningStatus> getCfgDispatchWarningStatus(Integer workSchedule);
}
