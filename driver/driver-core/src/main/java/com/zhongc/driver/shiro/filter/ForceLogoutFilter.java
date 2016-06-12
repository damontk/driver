//package com.zhongc.driver.shiro.filter;
//
//import org.apache.shiro.session.Session;
//import org.apache.shiro.web.filter.AccessControlFilter;
//import org.apache.shiro.web.util.WebUtils;
//
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//
///**
// * @Filename ForceLogoutFilter.java
// * @Description
// * @Version 1.0
// * @Author zhongc
// * @Email zhong_ch@foxmail.com
// * @History <li>Author: zhongc</li>
// * <li>Date: 2015-11-04</li>
// * <li>Version: 1.0</li>
// * <li>Content: create</li>
// */
//public class ForceLogoutFilter extends AccessControlFilter {
//    @Override
//    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
//        Session session = getSubject(request, response).getSession(false);
//        if (session == null) {
//            return true;
//        }
//        return session.getAttribute("session.force.logout") == null;
//    }
//
//    @Override
//    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
//        try {
//            getSubject(request, response).logout();// 强制退出
//        } catch (Exception e) {/* ignore exception */
//        }
//
//        String loginUrl = getLoginUrl() + (getLoginUrl().contains("?") ? "&" : "?") + "forceLogout=1";
//        WebUtils.issueRedirect(request, response, loginUrl);
//        return false;
//    }
//}
