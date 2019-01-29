package com.teekee.blackrockservice.service.sys;

import com.teekee.commoncomponets.base.BaseService;
import com.teekee.blackrockservice.entity.sys.SysAppToken;
import com.teekee.blackrockservice.mapper.sys.SysAppTokenMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Niting
 * @date 2018/11/3
 **/
@Service
public class SysAppTokenService extends BaseService<SysAppTokenMapper,SysAppToken> {
    @Resource
    SysAppTokenMapper tokenMapper;

    public SysAppToken getAppToken(String token){
        return tokenMapper.getTokenValidity(token);
    }
}
