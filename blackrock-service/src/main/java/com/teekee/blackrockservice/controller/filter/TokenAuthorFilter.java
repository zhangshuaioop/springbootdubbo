package com.teekee.blackrockservice.controller.filter;

import com.teekee.blackrockservice.entity.sys.SysAppToken;
import com.teekee.blackrockservice.mapper.sys.SysAppTokenMapper;
import com.teekee.blackrockservice.utils.ResponseMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Niting
 * @date 2018/11/3
 **/
@Component
@WebFilter(urlPatterns = { "/serv/*" }, filterName = "tokenAuthorFilter")
public class TokenAuthorFilter implements Filter {
    private static Logger logger = LoggerFactory.getLogger(TokenAuthorFilter.class);
    @Resource
    private SysAppTokenMapper mapper;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
        HttpServletRequest req = (HttpServletRequest) request;

        String token = req.getHeader("Token");
        if (volidateToken(token) == false)
        {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.setCharacterEncoding("UTF-8");
            httpResponse.setContentType("application/json; charset=utf-8");
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

            ObjectMapper mapper = new ObjectMapper();
            ResponseMessage message = new ResponseMessage();
            message.setMessage("token验证失败！");
            message.setCode("403");
            httpResponse.getWriter().write(mapper.writeValueAsString(message));
            return;
        }
        else
        {
            chain.doFilter(request, response);
        }
    }




    public boolean volidateToken(String token) {
        ResponseMessage message = new ResponseMessage();
        //对token有效期进行校验
        SysAppToken appToken = mapper.getTokenValidity(token);
        if(appToken != null) {
            return true;
        }else {
            return false;
        }
    }


    @Override
    public void destroy() {}

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}
}
