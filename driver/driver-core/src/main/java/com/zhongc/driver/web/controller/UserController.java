package com.zhongc.driver.web.controller;

import com.zhongc.driver.common.Constant;
import com.zhongc.driver.common.util.ip.IPUtil;
import com.zhongc.driver.domain.User;
import com.zhongc.driver.domain.order.user.LoginOrder;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhongChao on 2015/10/14.
 */
@Controller
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public String login(LoginOrder order, HttpServletRequest request, Model model) {
        UsernamePasswordToken token = new UsernamePasswordToken(order.getPhone(),order.getPassword(), IPUtil.getIpAddr(request));
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            Session session = SecurityUtils.getSubject().getSession();
            User user = (User)session.getAttribute(Constant.Session.SESSION_USER_NAME);
            if (user.getUserType()==true){
                return "redirect:/admin/index.vm";
            }
        }catch (UnknownAccountException e){
            model.addAttribute("message",e.getMessage());
            return "/login.vm";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("message",e.getMessage());
            return "/login.vm";
        }catch (RuntimeException e ){
            model.addAttribute("message","系统繁忙 请稍后再试");
            return "/login.vm";
        }
        return "redirect:/usercenter/";
    }
}
