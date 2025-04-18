package com.yls;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class JwtTest {
    @Test
    public void testGen() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "张三");

        String token = JWT.create()
                .withClaim("user", claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12))
                .sign(Algorithm.HMAC256("yls"));

        System.out.println(token);
    }

    @Test
    public void testParse() {
        // 动态生成令牌（复用 testGen 逻辑）
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "张三");
        String token = JWT.create()
                .withClaim("user", claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12)) // 12 小时后过期
                .sign(Algorithm.HMAC256("yls"));

        // 验证令牌
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("yls")).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);

        // 获取并验证声明
        Map<String, Claim> claim = decodedJWT.getClaims();
        Claim userClaim = claim.get("user");
        assertNotNull(userClaim, "User claim should not be null");
        System.out.println(userClaim.asMap()); // 打印 {id=1, username=张三}

        // 验证具体字段
        Map<String, Object> userMap = userClaim.asMap();
        assertEquals(1, userMap.get("id"), "User ID should be 1");
        assertEquals("张三", userMap.get("username"), "Username should be 张三");
    }
}