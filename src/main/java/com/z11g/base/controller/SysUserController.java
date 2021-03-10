package com.z11g.base.controller;

import com.z11g.base.common.result.ResultUtil;
import com.z11g.base.impl.SysUserService;
import com.z11g.base.model.SysUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program：demo
 * @description：用户中心-控制器
 * @author：z11g
 * @create：2021-01-08
 **/
@RestController
@RequestMapping("user")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    @GetMapping(value = {"findList"})
    public String findList(){
        return ResultUtil.successData(sysUserService.list());
    }

    @GetMapping("getById")
    public String getById(@RequestParam(value = "id",required = false) String id){
        SysUser sysUser = sysUserService.getById(id);
        return ResultUtil.successData(sysUser);
    }

    @GetMapping("save")
    public String save(@RequestParam(value = "sysUser") SysUser sysUser){
        sysUserService.save(sysUser);
        return ResultUtil.successData(sysUser);
    }

    @GetMapping("updateById")
    public String updateById(@RequestParam(value = "sysUser",required = false) SysUser sysUser){
        sysUserService.updateById(sysUser);
        return ResultUtil.successData(sysUser);
    }

    @GetMapping("removeById")
    public String removeById(@RequestParam(value = "id",required = false) String id){
        sysUserService.removeById(id);
        return ResultUtil.successData(id);
    }
}
