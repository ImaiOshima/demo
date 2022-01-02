package com.wyh.demo.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.wyh.demo.domain.User;
import com.wyh.demo.service.UserService;
import com.wyh.demo.token.annotate.PassToken;
import com.wyh.demo.token.annotate.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author imai
 * @since 2021/3/22 10:04 下午
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String token = request.getHeader("token");
        if(!(handler instanceof HandlerMethod)){
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if(passToken.required()){
                return true;
            }
        }
        // 检查有没有需要用户权限的注解
        if(method.isAnnotationPresent(UserLoginToken.class)){
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if(userLoginToken.required()){
                // 如果需要认证就看下token 是否为空
                if(token == null){
                    throw new RuntimeException("无Token,请重新登录");
                }
                String userId = null;
                Long userId1 = null;
                try{
                    userId = JWT.decode(token).getAudience().get(0);
                }catch (JWTDecodeException e){
                    e.printStackTrace();
                }
                User user = userService.findOneUserById(userId1);
                if(user == null){
                    throw new RuntimeException("用户不存在，请重新登录");
                }
                //验证password
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
                try{
                    jwtVerifier.verify(token);
                }catch (JWTVerificationException e){
                    e.printStackTrace();
                }
                return true;
            }
        }
        return true;
    }
}
