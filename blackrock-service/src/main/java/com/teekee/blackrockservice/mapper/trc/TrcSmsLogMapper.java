package com.teekee.blackrockservice.mapper.trc;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.blackrockservice.entity.bif.HumanResourceLoginParam;
import com.teekee.blackrockservice.entity.trc.TrcSmsLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TrcSmsLogMapper extends BaseMapper<TrcSmsLog> {

    /**
     * 根据手机号和验证码查询
     * @param param
     * @return
     * @Author:Niting
     * @Date:2018/07/17
     */
    TrcSmsLog selectByMobileAndKey(HumanResourceLoginParam param);
}