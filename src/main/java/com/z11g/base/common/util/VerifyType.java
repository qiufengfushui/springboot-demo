package com.z11g.base.common.util;

import cn.hutool.core.convert.Convert;
import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

/**
 * @program：demo
 * @description：校验类型
 * @author：z11g
 * @create：2021-01-18
 **/
public class VerifyType {

    /**
     * is char type
     * @param str
     * @return true：yes，false：no
     */
    public static boolean isChar(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        return str.length() == 1 && Character.isLetter(str.charAt(0)) || isNumber(str) && Convert.toInt(str) >= 0 && Convert.toInt(str) <= 65535;
    }

    /**
     * is number type
     * @param str
     * @return true：yes，false：no
     */
    public static boolean isNumber(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("^-?\\d+(\\.\\d+)?$").matcher(str).matches();
    }
}
