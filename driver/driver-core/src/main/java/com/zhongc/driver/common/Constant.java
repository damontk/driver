package com.zhongc.driver.common;

/**
 * @Filename Constant.java
 * @Description
 * @Version 1.0
 * @Author zhongc
 * @Email zhong_ch@foxmail.com
 * @History <li>Author: zhongc</li>
 * <li>Date: 2015-11-04</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class Constant {

    public static class Base {

        /**
         * 本地编码
         */
        public final static String LOCAL_CODE = "utf-8";
    }

    /*
     * 和session有关
     */
    public static class Session {
        /**
         * session 中user对象的名称
         */
        public final static String SESSION_USER_NAME = "user";
        
        /**
         * session id
         */
        public final static String SESSION_ID = "session.id";

        /**
         * session 中权限列表对象的名称
         */
        public final static String SESSION_PERMISSIONS_NAME = "boss_permissions";

        /**
         * session 中验证码对象的名称
         */
        public final static String SESSION_CHECKCODE_NAME = "checkcode";

    }

    public enum ReceptionConstant {

        GOOD("商品", "goods"), SHOP("商户", "shops");

        private final String description;
        private final String code;

        // 构造器默认也只能是private, 从而保证构造函数只能在内部使用
        ReceptionConstant(String description, String code) {
            this.description = description;
            this.code = code;
        }

        public String getDescription() {
            return description;
        }

        public String getCode() {
            return code;
        }
    }

    public enum InOutStock {

        INDETAIL("入库", "indetail"), OUTDETAIL("出库", "outdetail");

        private final String description;
        private final String code;

        //构造器默认也只能是private, 从而保证构造函数只能在内部使用
        InOutStock(String description, String code) {
            this.description = description;
            this.code = code;
        }

        public String getDescription() {
            return description;
        }

        public String getCode() {
            return code;
        }
    }
}