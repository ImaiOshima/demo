package com.wyh.demo.token;

import com.wyh.demo.domain.User;
import org.springframework.stereotype.Component;

/**
 * @author imai
 * @since 2021/3/22 9:52 下午
 */
@Component
public class TokenService {
    public String getToken(User user){
//        String token = "";
//        token = JWT.create().withAudience(user.getId())
//                .sign(Algorithm.HMAC256(user.getPassword()));
//        return token;
        return null;
    }
}
