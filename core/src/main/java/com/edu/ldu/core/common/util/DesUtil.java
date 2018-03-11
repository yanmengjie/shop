package com.edu.ldu.core.common.util;

import java.nio.charset.Charset;


/**
 * des加密解密工具
 *
 * @author yanmengjie
 * 2018/3/6
 */

public class DesUtil {
    private static final String SKEY = "abcdefgh";
    public static final Charset CHARSET = Charset.forName("utf-8");

    /**
     * 加密
     *
     * @param srcStr
     * @param charset
     * @param sKey
     * @return
     */
    public static String encrypt(String srcStr, Charset charset, String sKey) {
        byte[] src = srcStr.getBytes(charset);
        byte[] buf = Des.encrypt(src, sKey);
        return Des.parseByte2HexStr(buf);
    }

    /**
     * 解密
     *
     * @param hexStr
     * @param sKey
     * @return
     * @throws Exception
     */
    public static String decrypt(String hexStr, Charset charset, String sKey) throws Exception {
        byte[] src = Des.parseHexStr2Byte(hexStr);
        byte[] buf = Des.decrypt(src, sKey);
        return new String(buf, charset);
    }

    public static void main(String[] args) {
        // 待加密内容
        String str = "123456";
        String key = SecurityUtil.getRandomStr(8);
        System.out.println(key);
        String encryptResult = DesUtil.encrypt(str, CHARSET, key);
        System.out.println(encryptResult);
        // 直接将如上内容解密
        String decryResult = "";
        try {
            decryResult = DesUtil.decrypt(encryptResult, CHARSET, key);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        System.out.println(decryResult);
    }
}