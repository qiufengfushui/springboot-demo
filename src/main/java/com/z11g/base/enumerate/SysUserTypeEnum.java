package com.z11g.base.enumerate;

/**
 * @program：demo
 * @description：用户类型
 * @author：z11g
 * @create：2021-03-04
 **/
public enum SysUserTypeEnum {

    //管理员用户
    ADMIN_USER_ENUM(0,"管理员用户"),
    //普通用户
    COMMON_USER_ENUM(1,"普通用户");

    SysUserTypeEnum(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
