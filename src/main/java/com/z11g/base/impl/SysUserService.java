package com.z11g.base.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.z11g.base.mapper.SysUserMapper;
import com.z11g.base.model.SysUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr.Tong
 */
@Service
public class SysUserService extends ServiceImpl<SysUserMapper, SysUser> {

    public SysUser login(String userName, String password)  {
        SysUser sysUser = new SysUser();
        sysUser.setLoginName(userName);
        sysUser.setLoginPassword(SecureUtil.md5(password));
        return baseMapper.findOneByAll(sysUser);
    }

    public SysUser checkLoginName(String userName) {
        SysUser sysUser = new SysUser();
        sysUser.setLoginName(userName);
        return baseMapper.findOneByAll(sysUser);
    }

    public SysUser findById(int id) {
        SysUser sysUser = baseMapper.selectById(id);
        System.out.println(sysUser);
        return sysUser;
    }

    public List<SysUser> findList1(SysUser sysUser) {
        return baseMapper.findByAll(sysUser);
    }
}
