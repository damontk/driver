package com.zhongc.driver.common.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @Filename DataUtil.java
 * @Description
 * @Version 1.0
 * @Author zhongc
 * @Email zhong_ch@foxmail.com
 * @History <li>Author: zhongc</li>
 * <li>Date: 2015-11-11</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class DataUtil {
    /**
     * 判断是否为ajax请求
     * @param request
     * @return
     */
    public static boolean isAjax(HttpServletRequest request) {
        boolean ajax = "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
        String ajaxFlag = null == request.getParameter("ajax") ? "false" : request.getParameter("ajax");
        boolean isAjax = ajax || ajaxFlag.equalsIgnoreCase("true");
        return isAjax;
    }
}
