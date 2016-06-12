//package com.zhongc.driver.shiro.credentials;
//
//import com.zhongc.driver.common.util.EncryptionUtil;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.ExcessiveAttemptsException;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
//import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
//import org.apache.shiro.cache.Cache;
//import org.apache.shiro.cache.CacheManager;
//
//import java.util.concurrent.atomic.AtomicInteger;
//
///**
// * @Filename RetryLimitHashedCredentialsMatcher.java
// * @Description
// * @Version 1.0
// * @Author zhongc
// * @Email zhong_ch@foxmail.com
// * @History <li>Author: zhongc</li>
// * <li>Date: 2015-11-04</li>
// * <li>Version: 1.0</li>
// * <li>Content: create</li>
// * 重试次数限定匹配验证器
// * 超过最大次数将抛出 ExcessiveAttemptsException 过度尝试异常
// */
//public class RetryLimitHashedCredentialsMatcher extends SimpleCredentialsMatcher {
//
//    private Cache<String, AtomicInteger> passwordRetryCache;
//    private int maxCount = 5; // 最多尝试次数
//
//    public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
//        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
//    }
//
//    @Override
//    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
//        String username = (String) token.getPrincipal();
//        // 使用线程安全的 AtomicInteger 类型
//        AtomicInteger retryCount = passwordRetryCache.get(username);
//        if (retryCount == null) {
//            retryCount = new AtomicInteger(0);
//            passwordRetryCache.put(username, retryCount);
//        }
//        // 过度尝试抛出异常
//        if (retryCount.incrementAndGet() > maxCount)
//            throw new ExcessiveAttemptsException();
//
//        boolean matches = super.doCredentialsMatch(token, info);
//        // 验证通过则移除缓存
//        if (matches)
//            passwordRetryCache.remove(username);
//        return matches;
//    }
//
//    public void setMaxCount(int maxCount) {
//        this.maxCount = maxCount;
//    }
//
//    @Override
//    protected Object getCredentials(AuthenticationToken token) {
////        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)token;
//        String userName =(String) token.getPrincipal();
//        String passWord = new String((char[])token.getCredentials());
//        return EncryptionUtil.encrypt(passWord,userName);
//    }
//
//}
