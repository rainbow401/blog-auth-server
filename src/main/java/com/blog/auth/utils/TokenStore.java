package com.blog.auth.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.blog.auth.config.AuthProperties;
import com.blog.common.entity.User;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.UUID;

@RequiredArgsConstructor
public class TokenStore {

    private final AuthProperties authProperties;

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(authProperties.getSecret());
            Date date = new Date(new Date().getTime() + authProperties.getExp());
            return JWT.create()
                    .withIssuer(authProperties.getIssuer())
                    .withClaim("user", "nihao")
                    .withExpiresAt(date)
                    .withJWTId(UUID.randomUUID().toString())
                    .sign(algorithm);
        } catch (JWTCreationException e){
            e.printStackTrace();
            return "生成token失败";
        }
    }
}
