package com.teekee.blackrockservice.mapper.sys;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.blackrockservice.entity.sys.SysAppToken;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysAppTokenMapper extends BaseMapper<SysAppToken> {
    /**
     * 根据服务商APPid查询
     * @return
     * @Author:Niting
     * @Date:2018/11/03
     * @param sysAppToken
     */
    SysAppToken getTokenByUerId(SysAppToken sysAppToken);
    /**
     * 根据服务商id查询
     * @return
     * @Author:Niting
     * @Date:2018/11/03
     */
    void updateByUserId(SysAppToken appToken);
    /**
     * 查询token有效期
     * @return
     * @Author:Niting
     * @Date:2018/11/03
     */
    SysAppToken getTokenValidity(String token);
    /**
     * 查询token
     * @return
     * @Author:Niting
     * @Date:2018/11/11
     */
    SysAppToken queryToken(String token);
}