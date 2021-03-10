package com.z11g.base.controller;

import com.z11g.base.common.annotation.LoginAnnotation;
import com.z11g.base.common.result.ResultUtil;
import com.z11g.base.common.util.TokenUtil;
import com.z11g.base.impl.SysUserService;
import com.z11g.base.model.SysUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @program：demo
 * @description：用户登录-控制器
 * @author：z11g
 * @create：2021-01-20
 **/
@RestController
@RequestMapping("user")
public class LoginController {
    @Resource
    private SysUserService sysUserService;

    @GetMapping("login")
    public String login(HttpServletRequest request,
                        @RequestParam(value = "userName") String userName,
                        @RequestParam(value = "password") String password){
        SysUser sysUser = sysUserService.login(userName,password);
        String token = TokenUtil.getToken(sysUser);
        request.setAttribute("token",token);
        return ResultUtil.successData(token);
    }

    @LoginAnnotation
    @GetMapping("index")
    public String index(){
        return ResultUtil.success();
    }
}
