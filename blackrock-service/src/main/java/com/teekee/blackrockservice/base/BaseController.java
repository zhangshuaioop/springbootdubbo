package com.teekee.blackrockservice.base;

import com.teekee.blackrockservice.entity.sys.SysAppToken;
import com.teekee.blackrockservice.service.sys.SysAppTokenService;
import com.teekee.blackrockservice.utils.DataFormatTransform;
import com.teekee.blackrockservice.utils.ResponseMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Wujun on 2017/3/7.
 */
@Service
public abstract class BaseController {
    @Resource
    SysAppTokenService tokenService;


    /**
     * 组装返回Json对象
     *
     * @param message
     * @return
     */
    protected final String build(ResponseMessage message) {
        String json =  DataFormatTransform.changeModel2Json(message) ;
        return json;
    }


    /**
     * 根据名字获取Head中的数据
     *
     * @param request
     * @return
     */
    protected final Integer getTokenFromHead(HttpServletRequest request) {
        String token = request.getHeader("Token");
        SysAppToken appToken = tokenService.getAppToken(token);
        if(appToken == null){
            appToken = null;
        }
        return appToken == null ? 0 : appToken.getUserId();
    }


}
