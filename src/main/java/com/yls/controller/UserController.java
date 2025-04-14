package com.yls.controller;

import com.yls.pojo.Result;
import com.yls.pojo.User;
import com.yls.service.UserService;
import com.yls.utils.JwtUtil;
import com.yls.utils.Md5Util;
import com.yls.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    //注册
    @PostMapping("register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$")String password) {
        //查询用户
        User u = userService.findByUserName(username);
        if(u==null){
            //注册
            userService.register(username,password);
            return Result.success();
        }else {
            //占用
            return Result.error("用户名以被占用");
        }
    }

    //登录
    @PostMapping("/login")
    public Result<String> login(String username, String password) {
        //根据用户名查询用户
        User loginUser = userService.findByUserName(username);
        //判断该用户是否存在
        if(loginUser==null){
            return Result.error("用户不存在");
        }

        //判断密码是否正确
        if(Md5Util.getMD5String(password).equals(loginUser.getPassword())){
            //登录成功
            //获取令牌
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",loginUser.getId());
            claims.put("username",loginUser.getUsername());
            String token = JwtUtil.genToken(claims);
            return Result.success(token);
        }

        return Result.error("密码错误");
    }

    //获取用户信息
    @GetMapping("userInfo")
    public Result<User> userInfo(/*@RequestHeader(name = "Authorization") String token*/) {
        //根据用户名查询用户信息
        /*Map<String,Object> map = JwtUtil.parseToken(token);
        String username = (String) map.get("username");*/
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User user = userService.findByUserName(username);

        return Result.success(user);
    }


}
