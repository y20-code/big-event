package com.yls;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootTest //如果在测试类上添加类这个注解，那么将来单元测试方法之前，会先初始化Spring容器
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testSet(){
        //往redis中存储一个键值对 StringRedisTemplate

        stringRedisTemplate.opsForValue().set("username","张三");
        stringRedisTemplate.opsForValue().set("id","1",15, TimeUnit.SECONDS);
    }

    @Test
    public void testGet(){

        String username = stringRedisTemplate.opsForValue().get("username");
        System.out.println("username:"+username);

    }
}
