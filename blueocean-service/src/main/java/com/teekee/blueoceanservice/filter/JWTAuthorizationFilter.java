package com.teekee.blueoceanservice.filter;

import com.teekee.blueoceanservice.entity.sysconsole.SysConsoleUsers;
import com.teekee.blueoceanservice.utils.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by echisan on 2018/6/23
 */
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    @Autowired
    private RedisTemplate redisTemplate;

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
            PrintWriter out = response.getWriter();
            out.write("{\"status\":\"403\",\"msg\":\"授权失败!\"}");
            out.flush();
            out.close();

            return;
        }
        // 如果请求头中有token，则进行解析，并且设置认证信息
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = getAuthentication(tokenHeader,response);
        if(usernamePasswordAuthenticationToken == null){
            return;
        }
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

        try {
            //获取当前请求地址
//            String url = request.getRequestURI();
//            String companyUsersStr = RedisUtil.get("sys_company_users,"+CurrentUtil.getCurrent().getId());
//            List<SysCompanyPermissionRes> list = JsonUtils.getStringToList(companyUsersStr,SysCompanyPermissionRes.class);
//
//            if(list != null){
//                for (SysCompanyPermissionRes sysCompanyPermissionRes: list) {
//                    if(url.equals(sysCompanyPermissionRes.getApiUrl())){
//                        // 继续调用 Filter 链
//                        super.doFilterInternal(request, response, chain);
//                        return;
//                    }
//                }
//                response.setContentType("application/json;charset=UTF-8");
//                PrintWriter out = response.getWriter();
//                out.write("{\"status\":\"403\",\"msg\":\"无此权限!\"}");
//                out.flush();
//                out.close();
//                return;
//            }else {
//                response.setContentType("application/json;charset=UTF-8");
//                PrintWriter out = response.getWriter();
//                out.write("{\"status\":\"403\",\"msg\":\"无此权限!\"}");
//                out.flush();
//                out.close();
//                return;
//            }

            super.doFilterInternal(request, response, chain);
            return;

        } catch (Exception e) {
            e.printStackTrace();
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.write("{\"status\":\"500\",\"msg\":\"程序异常!\"}");
            out.flush();
            out.close();
            return;
        }


    }



    // 这里从token中获取用户信息并新建一个token
    private UsernamePasswordAuthenticationToken getAuthentication(String tokenHeader,HttpServletResponse response) throws IOException {
        String token = tokenHeader.replace(JwtTokenUtils.TOKEN_PREFIX, "");
        String username = JwtTokenUtils.getUsername(token);
        String role = JwtTokenUtils.getUserRole(token);
        SysConsoleUsers user = JwtTokenUtils.getUser(token);
        if(username.equals("")){
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.write("{\"status\":\"403\",\"msg\":\"授权失败!\"}");
            out.flush();
            out.close();
            return null;
        }

        if(role.equals("")){
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.write("{\"status\":\"405\",\"msg\":\"无权限!\"}");
            out.flush();
            out.close();
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
