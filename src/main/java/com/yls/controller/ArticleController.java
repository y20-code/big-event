package com.yls.controller;

import com.yls.pojo.Result;
import com.yls.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @GetMapping("/list")
    public Result<String> list(/*@RequestHeader(name = "Authorization") String token, HttpServletResponse response*/){
        //验证token
        //由于每个接口都有写这段代码非常麻烦，所有写了一个拦截器->intercoptors.LoginInterceptor
//        try {
//            Map<String,Object> map = JwtUtil.parseToken(token);
//            return Result.success("所有的文章数据");
//        } catch (Exception e) {
//            //httxiang响应状态码为401
//            response.setStatus(401);
//            return Result.error("为登录");
//        }
        return Result.success("所有的文章数据");
    }
}
