//package com.zhongc.driver.shiro.encryption;
//
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.credential.CredentialsMatcher;
//import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
//
//import javax.security.auth.login.CredentialException;
//
///**
// * @Filename MyCredentialsMatcher.java
// * @Description
// * @Version 1.0
// * @Author zhongc
// * @Email zhong_ch@foxmail.com
// * @History <li>Author: zhongc</li>
// * <li>Date: 2015-11-13</li>
// * <li>Version: 1.0</li>
// * <li>Content: create</li>
// * 扩展解密方法
// */
//public class MyCredentialsMatcher extends SimpleCredentialsMatcher{
//    @Override
//    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
//        String tokenPassWord = (String)authenticationToken.getPrincipal();
//        String infoPassWord = (String)authenticationInfo.getCredentials();
//
//        return false;
//    }
//}
