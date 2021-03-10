package com.z11g.base.common.result;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.z11g.base.common.exception.BaseExceptionInfoInterface;

/**
 * @program：demo
 * @description：
 * @author：z11g
 * @create：2021-01-15
 **/
public class ResultUtil {
    /**
     * FastJSON 转换 json 的一些配置.
     */
    private static SerializerFeature[] serializerFeatures =
            {
                    SerializerFeature.WriteMapNullValue,         // 即使字段的 value 为 null, key 也会输出.
                    SerializerFeature.WriteNullListAsEmpty,      // 当数组或list 为 null 时, 输出 [], 而不是 null.
                    SerializerFeature.WriteNullStringAsEmpty,    // 当字符串为 null 时, 输出 "", 而不是 null.
                    SerializerFeature.WriteNullBooleanAsFalse,   // 当 boolean 为 null 时, 输出 false, 而不是 null (争议待确认)
                    SerializerFeature.WriteDateUseDateFormat     //时间戳转日期
            };

    public static String success() {
        return JSON.toJSONString(ResultBean.success(),serializerFeatures);
    }

    public static String successData(Object obj) {
        return JSON.toJSONString(ResultBean.successData(obj),serializerFeatures);
    }

    public static String successPageData(Object obj) {
        return JSON.toJSONString(ResultBean.successData(obj),serializerFeatures);
    }

    public static String error() {
        return error(-1,"系统错误，请联系管理员！");
    }

    public static String error(String msg) {
        return error(-1,msg);
    }

    public static String error(Integer code,String msg) {
        return JSON.toJSONString(ResultBean.error(code,msg),serializerFeatures);
    }

    public static String error(BaseExceptionInfoInterface errorInfo) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(errorInfo.getResultCode());
        resultBean.setMsg(errorInfo.getResultMsg());
        return JSON.toJSONString(resultBean,serializerFeatures);
    }
}
