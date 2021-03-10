package com.z11g.base.common.exception;

/**
 * @author Mr.Tong
 */
public interface BaseExceptionInfoInterface {
    /**
     * 错误码
     * @return
     */
    Integer getResultCode();

    /**
     * 错误消息
     * @return
     */
    String getResultMsg();
}