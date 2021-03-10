package com.z11g.base.common.util;

import java.io.UnsupportedEncodingException;

/**
 * @program：demo
 * @description：
 * @author：z11g
 * @create：2021-02-25
 **/
public class TypeCast {
    public static String byteToStr(byte[] bytes){
        String s = "";
        try {
            s = new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return s;
    }

    public static byte[] strToByte(String str){
        byte[] bytes = new byte[0];
        try {
            bytes = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return bytes;
    }
}
