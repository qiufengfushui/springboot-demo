package com.z11g.base.config;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ObjectUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.z11g.base.common.annotation.LoginAnnotation;
import com.z11g.base.common.annotation.PassLoginAnnotation;
import com.z11g.base.common.exception.BaseException;
import com.z11g.base.impl.SysUserService;
import com.z11g.base.model.SysUser;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @program：demo
 * @description：拦截器
 * @author：z11g
 * @create：2021-01-22
 **/
public class MyInterceptor implements HandlerInterceptor {

    @Resource
    private SysUserService sysUserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        Object token = request.getSession().getAttribute("token");

        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Method method = handlerMethod.getMethod();
        return checkAnnotations(method,token);
    }

    /**
     * 检验是否有注解配置
     * @param method
     * @param token
     * @return
     */
    public boolean checkAnnotations(Method method,Object token){
        if (method.isAnnotationPresent(PassLoginAnnotation.class)) {
            PassLoginAnnotation passLoginAnnotation = method.getAnnotation(PassLoginAnnotation.class);
            if (passLoginAnnotation.required()) {
                //跳过验证
                return true;
            }
        }

        if (method.isAnnotationPresent(LoginAnnotation.class)) {
            LoginAnnotation loginAnnotation = method.getAnnotation(LoginAnnotation.class);
            if (loginAnnotation.required()) {
                //进行验证
                return checkToken(token);
            }
        }
        return true;
    }

    /**
     * 检验token是否合法
     * @param token
     * @return true：合法，false：不合法
     */
    public boolean checkToken(Object token){
        if (ObjectUtil.isEmpty(token)) {
            throw new BaseException(-1,"登录失效，请重新登录");
        }
        String userName;
        try {
            userName = JWT.decode(Convert.toStr(token)).getAudience().get(0);
        } catch (JWTDecodeException j) {
            throw new BaseException(-1,"token违法，请重新登录！");
        }
        SysUser user = sysUserService.checkLoginName(userName);
        if (user == null) {
            throw new BaseException(-1,"用户名不存在，请重新登录");
        }
        // 验证 token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getLoginPassword())).build();
        try {
            jwtVerifier.verify(Convert.toStr(token));
        } catch (JWTVerificationException e) {
            throw new BaseException(-1,"用户名与密码不匹配，请重新登录");
        }
        return true;
    }
}
