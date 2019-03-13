package com.company.springboot.filter;

import com.company.springboot.entity.sys.SysCompanyUsers;
import com.company.springboot.utils.CurrentUtil;
import com.company.springboot.utils.JwtTokenUtils;
import com.company.springboot.utils.RedisUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by echisan on 2018/6/23
 */
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {


    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }



    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {

        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            chain.doFilter(request, response);
            return;
        }

        String tokenHeader = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
        // 如果请求头中没有Authorization信息则直接返回
        if (tokenHeader == null || !tokenHeader.startsWith(JwtTokenUtils.TOKEN_PREFIX)) {
//            chain.doFilter(request, response);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write("{\"code\":666,\"msg\":\"授权失败!\"}");

            return;
        }
        // 如果请求头中有token，则进行解析，并且设置认证信息
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = getAuthentication(tokenHeader,response);
        if(usernamePasswordAuthenticationToken == null){
            return;
        }
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

        try {
            String redisStr = RedisUtil.get("sys_company_api_all");
//            List<RedisCompanyPermissionApiRes> list = JsonUtils.getStringToList(redisStr,RedisCompanyPermissionApiRes.class);
            if(redisStr != null && redisStr.length()>0){
                SysCompanyUsers sysCompanyUsers = CurrentUtil.getCurrent();

                if(redisStr.contains("{\"apiUrl\":\""+request.getRequestURI()+"\",\"companyId\":"+sysCompanyUsers.getCompanyId()+",\"userId\":"+sysCompanyUsers.getId()+"}")){
                    // 继续调用 Filter 链
                    super.doFilterInternal(request, response, chain);
                    return;
                }
                response.setContentType("application/json;charset=UTF-8");
                response.getWriter().write("{\"code\":666,\"msg\":\"无此权限!\"}");
                return;
            }else {
                response.setContentType("application/json;charset=UTF-8");
                response.getWriter().write("{\"code\":666,\"msg\":\"无此权限!\"}");
                return;
            }

//            super.doFilterInternal(request, response, chain);
//            return;

        } catch (Exception e) {
            e.printStackTrace();
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write("{\"code\":500,\"msg\":\"程序异常!\"}");

            return;
        }


    }



    // 这里从token中获取用户信息并新建一个token
    private UsernamePasswordAuthenticationToken getAuthentication(String tokenHeader,HttpServletResponse response) throws IOException {
        String token = tokenHeader.replace(JwtTokenUtils.TOKEN_PREFIX, "");
        String username = JwtTokenUtils.getUsername(token);
        String role = JwtTokenUtils.getUserRole(token);
        SysCompanyUsers user = JwtTokenUtils.getUser(token);
        if(username.equals("")){
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write("{\"code\":666,\"msg\":\"授权失败!\"}");
            return null;
        }

        if(role.equals("")){
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write("{\"code\":666,\"msg\":\"无权限!\"}");
            return null;
        }

        String[] roles = role.split(",");
        Collection<SimpleGrantedAuthority> collection = new HashSet<SimpleGrantedAuthority>();
        for (String r: roles) {
            collection.add(new SimpleGrantedAuthority(r));
        }
        return new UsernamePasswordAuthenticationToken(username, user, collection);

    }
}
