package com.kzdx.management.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.kzdx.management.entity.User;

import java.util.Date;

public class TokenUtil {
    private static final long EXPIRE_TIME= 60*60*1000; //过期时间：1 hour
    private static final String TOKEN_SECRET="HaiQing";  //密钥盐

    /**
     * 签名生成
     * @param
     * @return
     */
    public static String sign(User user){
        String token = null;
        try {
            Date expiresAt = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("username", user.getUserName())
                    .withExpiresAt(expiresAt)
                    // 使用了HMAC256加密算法。
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(user.getUserName()+"用户生成的Token为："+token);
        return token;
    }

    /**
     * 签名验证
     * @param token
     * @return
     */
    public static Integer verify(String token){
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
            DecodedJWT jwt = verifier.verify(token);
            Date time = new Date();
            System.out.println(jwt.getExpiresAt().getTime() - time.getTime());
            if(jwt.getExpiresAt().getTime() - time.getTime() < 2*60*1000){ // 距离过期时间2分钟调用接口， 则调用自动刷新token接口
                return 2;
            }else {
                return 1;
            }
//            return true;
        } catch (Exception e){
//            return false;
            return -1;
        }
    }
}
