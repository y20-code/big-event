package com.yls.interceptors;

import com.yls.pojo.Result;
import com.yls.utils.JwtUtil;
import com.yls.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component

public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    //拦截器
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //令牌验证
        String token = request.getHeader("Authorization");
        try {
            //从redis中获取相同的token
            String redisToken = stringRedisTemplate.opsForValue().get(token);
            if (redisToken == null) {
                throw new RuntimeException();
            }
            Map<String,Object> map = JwtUtil.parseToken(token);

            //把业务数据存储到ThreadLocal中
            ThreadLocalUtil.set(map);
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


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //清空ThreadLocal中的数据
        ThreadLocalUtil.remove();
    }
}
