package com.z11g.base.enumerate;

/**
 * @program：demo
 * @description：公用是否删除枚举
 * @author：z11g
 * @create：2021-03-04
 **/
public enum CommonIsDeleteEnum {
    //有效
    VALID_ENUM(0,"有效"),
    //删除
    DELETE_ENUM(1,"删除");

    CommonIsDeleteEnum(Integer id, String name){
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
