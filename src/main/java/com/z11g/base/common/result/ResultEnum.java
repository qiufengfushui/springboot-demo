package com.z11g.base.common.result;


import com.z11g.base.common.exception.BaseExceptionInfoInterface;

/**
 * @program：demo
 * @description：定义响应数据
 * @author：z11g
 * @create：2021-01-15
 **/
public enum ResultEnum implements BaseExceptionInfoInterface {

    // 数据操作错误定义
    SUCCESS(200, "成功!"),
    BODY_NOT_MATCH(400,"请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH(401,"请求的数字签名不匹配!"),
    NOT_FOUND(404, "未找到该资源!"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误!"),
    SERVER_BUSY(503,"服务器正忙，请稍后再试!");

    /** 错误码 */
    private Integer resultCode;

    /** 错误描述 */
    private String resultMsg;

    ResultEnum(Integer resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    @Override
    public Integer getResultCode() {
        return this.resultCode;
    }

    @Override
    public String getResultMsg() {
        return this.resultMsg;
    }
}
