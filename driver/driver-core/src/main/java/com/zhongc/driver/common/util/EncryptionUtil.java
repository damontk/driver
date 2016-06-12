package com.zhongc.driver.common.util;
/**
 * @Filename EncryptionUtil.java
 * @Description
 * @Version 1.0
 * @Author zhongc
 * @Email zhong_ch@foxmail.com
 * @History <li>Author: zhongc</li>
 * <li>Date: 2015-11-13</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class EncryptionUtil {
    private static final String SHA="driver";

    /**
     * 加密
     * @param passWord
     * @param userName
     * @return
     */
    public static String encrypt(String passWord,String userName){
        String p1 = MD5.toMD5(passWord+userName);
        return MD5.toMD5(p1+SHA);
    }
}
