package com.z11g.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.z11g.base.model.SysUser;

import java.util.List;

/**
 * @author Mr.Tong
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 查询一个用户
     * @param sysUser
     * @return
     */
    SysUser findOneByAll(SysUser sysUser);

    /**
     * 查询一群用户
     * @param sysUser
     * @return
     */
    List<SysUser> findByAll(SysUser sysUser);


}