package com.z11g.base.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.z11g.base.model.SysUser;

/**
 * @program：demo
 * @description：
 * @author：z11g
 * @create：2021-01-25
 **/
public class TokenUtil {

    public static String getToken(SysUser user) {
        String token="";
        token= JWT.create().withAudience(user.getLoginName())
                .sign(Algorithm.HMAC256(user.getLoginPassword()));
        return token;
    }

    public static void main(String[] args) {
        SysUser sysUser = new SysUser();
        sysUser.setLoginName("admin");
        sysUser.setLoginPassword("admin");
        System.out.println(TokenUtil.getToken(sysUser));
    }
}
