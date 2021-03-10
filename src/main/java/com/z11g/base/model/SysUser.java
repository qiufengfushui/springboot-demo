package com.z11g.base.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * 用户表
 * @author Mr.Tong
 */
@Data
@TableName(value = "SYS_USER")
public class SysUser {
    /**
     * 用户ID
     */
    @TableId(value = "ID", type = IdType.INPUT)
    private String id;

    /**
     * 用户编码
     */
    @TableField(value = "CODE")
    private String code;

    /**
     * 用户名称
     */
    @TableField(value = "\"NAME\"")
    private String name;

    /**
     * 登录用户名
     */
    @TableField(value = "LOGIN_NAME")
    private String loginName;

    /**
     * 登录密码
     */
    @TableField(value = "LOGIN_PASSWORD")
    private String loginPassword;

    /**
     * 用户类型：管理员用户（0），普通用户（1）
     */
    @TableField(value = "\"TYPE\"")
    private Integer type;

    /**
     * 用户手机号
     */
    @TableField(value = "PHONE")
    private String phone;

    /**
     * 用户邮箱
     */
    @TableField(value = "EMAIL")
    private String email;

    /**
     * 添加用戶
     */
    @TableField(value = "CREATE_USER",fill = FieldFill.INSERT)
    private String createUser;

    /**
     * 添加时间
     */
    @TableField(value = "CREATE_TIME",fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改用戶
     */
    @TableField(value = "UPDATE_USER",fill = FieldFill.INSERT_UPDATE)
    private String updateUser;

    /**
     * 修改日期
     */
    @TableField(value = "UPDATE_TIME",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 删除flag：有效(0)，逻辑删除(1)
     */
    @TableField(value = "IS_DELETE",fill = FieldFill.INSERT)
    private Integer isDelete;

    /**
     * 备注
     */
    @TableField(value = "COMMENTS")
    private String comments;

    public static final String COL_ID = "ID";

    public static final String COL_CODE = "CODE";

    public static final String COL_NAME = "NAME";

    public static final String COL_LOGIN_NAME = "LOGIN_NAME";

    public static final String COL_LOGIN_PASSWORD = "LOGIN_PASSWORD";

    public static final String COL_TYPE = "TYPE";

    public static final String COL_PHONE = "PHONE";

    public static final String COL_EMAIL = "EMAIL";

    public static final String COL_CREATE_USER = "CREATE_USER";

    public static final String COL_CREATE_TIME = "CREATE_TIME";

    public static final String COL_UPDATE_USER = "UPDATE_USER";

    public static final String COL_UPDATE_TIME = "UPDATE_TIME";

    public static final String COL_IS_DELETE = "IS_DELETE";

    public static final String COL_COMMENTS = "COMMENTS";
}