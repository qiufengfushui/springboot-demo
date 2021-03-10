package com.z11g.base.common.result;

import java.io.Serializable;

/**
 * @program：demo
 * @description：定义响应消息
 * @author：z11g
 * @create：2021-01-15
 **/
public class ResultBean implements Serializable {

    private static final long serialVersionUID = -8276264968757808344L;

    private static final Integer SUCCESS = 0;

    public static final int FAIL = -1;

    private String msg = "操作成功";

    private static Integer code = SUCCESS;

    private Object data;

    public ResultBean() {
        super();
    }

    private ResultBean(String msg, Object data, int code) {
        this.msg = msg;
        this.data = data;
        this.code = code;
    }

    public static ResultBean success() {
        return success("操作成功");
    }

    public static ResultBean success(String msg) {
        return success(msg, null);
    }

    public static ResultBean success(String msg, Object data) {
        return new ResultBean(msg, data, SUCCESS);
    }

    public static ResultBean successData(Object data) {
        return success("操作成功", data);
    }

    public static ResultBean error(String msg) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(FAIL);
        resultBean.setMsg(msg);
        return resultBean;
    }

    public static ResultBean error(Integer code,String msg) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(code);
        resultBean.setMsg(msg);
        return resultBean;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}