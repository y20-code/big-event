package com.yls.interceptors;

import com.yls.pojo.Result;
import com.yls.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component

public class LoginInterceptor implements HandlerInterceptor {

    //拦截器
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //令牌验证
        String token = request.getHeader("Authorization");
        try {
            Map<String,Object> map = JwtUtil.parseToken(token);
            //放行
            return true;
        } catch (Exception e) {
            //httxiang响应状态码为401
            response.setStatus(401);
            //不放行
            return false;
        }
    }
    //还要注册->config->WebConfig
}
