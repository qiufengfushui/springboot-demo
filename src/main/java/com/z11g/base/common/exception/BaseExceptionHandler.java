package com.z11g.base.common.exception;

import com.z11g.base.common.result.ResultEnum;
import com.z11g.base.common.result.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @program：demo
 * @description：定义异常
 * @author：z11g
 * @create：2021-01-15
 **/
@ControllerAdvice
public class BaseExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(BaseException.class);

    /**
     * 处理自定义的业务异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = BaseException.class)
    @ResponseBody
    public String exceptionHandler(HttpServletRequest req, BaseException e){
        logger.error("发生业务异常！原因是：{}",e.getErrorMsg());
        return ResultUtil.error(e.getErrorCode(),e.getErrorMsg());
    }

    /**
     * 处理其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String exceptionHandler(HttpServletRequest req, Exception e){
        logger.error("未知异常！原因是:",e);
        return ResultUtil.error(ResultEnum.INTERNAL_SERVER_ERROR);
    }

    /**
     * 处理空指针的异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public String exceptionHandler(HttpServletRequest req, NullPointerException e){
        logger.error("发生空指针异常！原因是:",e);
        return ResultUtil.error(ResultEnum.INTERNAL_SERVER_ERROR);
    }

    /**
     * 处理空指针的异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseBody
    public String exceptionHandler(HttpServletRequest req, MissingServletRequestParameterException e){
        logger.error("发生入参异常！原因是:",e);
        return ResultUtil.error(ResultEnum.BODY_NOT_MATCH);
    }

}
