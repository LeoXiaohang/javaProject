package com.tw.core.util;
import java.security.MessageDigest;

/**
 * Created by xiaohang on 7/14/15.
 */


public class Md5 {

//    public static String getMd5(String message) {
//        try {
//            MessageDigest md = MessageDigest.getInstance("md5");
//            byte b[] = md.digest(message.getBytes());
//            return new BASE64Encoder().encode(b);
//
//        }catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static void main(String[] args){
//        MD5 m = new MD5();
//        String str = m.getMd5("admin");
//        System.out.println(str);
//
//    }

    public final static String getMd5(String s) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            byte[] strTemp = s.getBytes();
            MessageDigest mdTemp = MessageDigest.getInstance("Md5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte b = md[i];
                str[k++] = hexDigits[b >>> 4 & 0xf];
                str[k++] = hexDigits[b & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }
}

