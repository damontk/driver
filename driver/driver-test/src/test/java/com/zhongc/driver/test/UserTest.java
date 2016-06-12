//package com.zhongc.driver.test;
//
//
//import com.zhongc.driver.domain.Order;
//import com.zhongc.driver.domain.order.coach.CoachAddOrder;
//import com.zhongc.driver.domain.order.user.UserAddOrder;
//import com.zhongc.driver.porxy.CoachProxy;
//import com.zhongc.driver.service.UserService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.Date;
//
///**
// * @Filename UserTest.java
// * @Description
// * @Version 1.0
// * @Author zhongc
// * @Email zhong_ch@foxmail.com
// * @History <li>Author: zhongc</li>
// * <li>Date: 2015-09-26</li>
// * <li>Version: 1.0</li>
// * <li>Content: create</li>
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:/spring/driver-springmvc.xml")
//public class UserTest {
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private CoachProxy coachProxy;
//    @Test
//    public void addUser(){
//        UserAddOrder order = new UserAddOrder();
//        order.setUserId("0001");
//        order.setUserSex(true);
//        order.setRealName("超哥");
//        order.setPhone("admin");
//        order.setPassword("qq1313");
//        order.setCoachId(1);
//        order.setCreateTime(new Date());
//        userService.addUser(order);
//    }
//
//    @Test
//    public void test(){
//        CoachAddOrder order = new CoachAddOrder();
//        order.setCoachName("ss");
//        coachProxy.addCoach(order);
//
//    }
//}
