package com.teekee.blackrockservice.mapper.trc;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.blackrockservice.entity.trc.TrcQrLoginCodeLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Niting
 * @date 2018/11/21
 **/
@Mapper
public interface TrcQrLoginCodeLogMapper extends BaseMapper<TrcQrLoginCodeLog>{
    /**
     * 服务商二维码登录验证
     * @param code
     * @return
     * @Author:Niting
     * @Date:2018/08/22
     */
    TrcQrLoginCodeLog selectByCode(String code);
}
