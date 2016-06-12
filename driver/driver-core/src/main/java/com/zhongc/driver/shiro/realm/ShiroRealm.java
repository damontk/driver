//package com.zhongc.driver.shiro.realm;
//
//import com.zhongc.driver.common.Constant;
//import com.zhongc.driver.common.util.EncryptionUtil;
//import com.zhongc.driver.domain.order.user.LoginOrder;
//import com.zhongc.driver.enums.Status;
//import com.zhongc.driver.result.CommonEntityResult;
//import com.zhongc.driver.service.UserService;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.session.Session;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * @Filename ShiroRealm.java
// * @Description
// * @Version 1.0
// * @Author zhongc
// * @Email zhong_ch@foxmail.com
// * @History <li>Author: zhongc</li>
// * <li>Date: 2015-11-04</li>
// * <li>Version: 1.0</li>
// * <li>Content: create</li>
// */
//public class ShiroRealm extends AuthorizingRealm {
//
//    @Autowired
//    private UserService userService;
//
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        System.out.print("进入");
//        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        Set<String> set = new HashSet<>();
//        set.add("user");
//        Set<String> set1 = new HashSet<>();
//        set1.add("user:vie");
//        authorizationInfo.setRoles(set);
//        authorizationInfo.setStringPermissions(set1);
//        return authorizationInfo;
//    }
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//
//        Session shiroSession = SecurityUtils.getSubject().getSession();
//        UsernamePasswordToken usernamePasswordCodeToken = (UsernamePasswordToken) authenticationToken;
//
//        String userName = (String) usernamePasswordCodeToken.getPrincipal();
//        String password = new String((char[]) usernamePasswordCodeToken.getCredentials());
//        if (userName == null) {
//            throw new UnknownAccountException("未知用户");
//        }
//        LoginOrder order = new LoginOrder();
//        order.setPhone(userName);
//        order.setPassword(password);
//        logger.info("调用会员登录接口,入参:{}", order);
//        CommonEntityResult result = userService.login(order);
//        logger.info("调用会员登录接口,出参:{}", result);
//        if (result.getStatus() == Status.SUCCESS) {
//            SimpleAuthenticationInfo s = new SimpleAuthenticationInfo(userName, EncryptionUtil.encrypt(password,userName), getName());
//
//            shiroSession.setAttribute(Constant.Session.SESSION_USER_NAME, result.getObj());
//            return s;
//        }
//        throw new IncorrectCredentialsException("用户名或密码错误");
//    }
//}
