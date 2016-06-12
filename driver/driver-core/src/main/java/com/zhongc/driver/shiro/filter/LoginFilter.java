//package com.zhongc.driver.shiro.filter;
//
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.subject.Subject;
//import org.apache.shiro.web.filter.AccessControlFilter;
//
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * @Filename LoginFilter.java
// * @Description
// * @Version 1.0
// * @Author zhongc
// * @Email zhong_ch@foxmail.com
// * @History <li>Author: zhongc</li>
// * <li>Date: 2015-11-11</li>
// * <li>Version: 1.0</li>
// * <li>Content: create</li>
// */
//public class LoginFilter extends AccessControlFilter {
//
//    @Override
//    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
//        Subject subject = SecurityUtils.getSubject();
//        if (subject.isAuthenticated()) {
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
//        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
//        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
////        String basePath = ThreadLocalUtil.getBasePath();
//        httpResponse.sendRedirect("/");
//        return false;
//    }
//}
