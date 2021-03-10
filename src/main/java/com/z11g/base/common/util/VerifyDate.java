package com.z11g.base.common.util;

import cn.hutool.core.convert.Convert;

/**
 * @program：demo
 * @description：校验日期
 * @author：z11g
 * @create：2021-01-18
 **/
public class VerifyDate {

    /**
     * is year
     * @param year
     * @return true：yes，false：no
     */
    public static boolean isYear(String year) {
        return VerifyType.isNumber(year);
    }
    /**
     * is month
     * @param month
     * @return
     */
    public static boolean isMonth(String month) {
        Integer m = Integer.valueOf(month);
        if (m > 0 && m < 13)
            return true;
        return false;
    }

    /**
     * is day
     * @param year
     * @param month
     * @param day
     * @return true：yes，false：no
     */
    public static boolean isDay(String year,String month,String day) {
        Integer y = Convert.toInt(year);
        Integer flag = 0;
        if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0){
            flag = 1;
        }
        Integer m = Convert.toInt(month);
        Integer d = Convert.toInt(day);
        switch (m){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (d > 0 && d < 32)
                    return true;
                break;
            case 2:
                if (flag == 0 && d > 0 && d < 29 || flag == 0 && d > 0 && d < 30)
                    return true;
            default:
                if (d > 0 && d < 31)
                    return true;
                break;
        }
        return false;
    }

    /**
     * is hour
     * @param hour
     * @return true：yes，false：no
     */
    public static boolean isHour(String hour){
        Integer h = Convert.toInt(hour);
        if(h > -1 && h < 24){
            return true;
        }
        return false;
    }

    /**
     * is minute or second
     * @param minute
     * @return true：yes，false：no
     */
    public static boolean isMinuteAndSecond(String minute){
        Integer m = Convert.toInt(minute);
        if(m > -1 && m < 60){
            return true;
        }
        return false;
    }

    /**
     * is date
     * @param str
     * @return true：yes，false：no
     */
    public static boolean isDate(String str){
        if (str.length() != 10){
            return false;
        }
        String s = str.trim();
        String year = s.substring(0, 4);
        String month = s.substring(5, 7);
        String day = s.substring(8, 10);
        if (isYear(year) && isMonth(month) && isDay(year,month,day)){
            return true;
        }
        return false;
    }

    /**
     * is time
     * @param str
     * @return true：yes，false：no
     */
    public static boolean isTime(String str){
        if (str.length() != 19){
            return false;
        }
        String s = str.trim();
        String hour = s.substring(11,13);
        String minute = s.substring(14,16);
        String second =  s.substring(17,19);
        if (isHour(hour) && isMinuteAndSecond(minute) && isMinuteAndSecond(second)){
            return true;
        }
        return false;
    }

    /**
     * is datetime
     * @param str
     * @return true：yes，false：no
     */
    public static boolean isDateTime(String str){
        if (isDate(str) && isTime(str)){
            return true;
        }
        return false;
    }

    /**
     * is date type
     * @param str
     * @return true：yes，false：no
     */
    public static boolean isDateType(String str){
        if (isDate(str) || isTime(str)){
            return true;
        }
        return false;
    }
}
