package com.zhongc.driver.web.exception;

import com.alibaba.fastjson.JSON;
import com.zhongc.driver.common.bean.ReturnMsg;
import com.zhongc.driver.common.util.DataUtil;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Filename ExceptionHandler.java
 * @Description
 * @Version 1.0
 * @Author zhongc
 * @Email zhong_ch@foxmail.com
 * @History <li>Author: zhongc</li>
 * <li>Date: 2015-11-10</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 *
 * 异常捕获 向前台返回值
 */
@ControllerAdvice
public class CommonExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler({ UnauthorizedException.class })
    public String processUnauthenticatedException(HttpServletRequest request,HttpServletResponse response,UnauthorizedException e){
        logger.error("shiro授权失败 ->{}", e.getMessage());
        ReturnMsg returnModel = new ReturnMsg();
        if (DataUtil.isAjax(request)){
            response.setHeader("Content-Type", "application/json;charset=UTF-8");
            returnModel.setSuccess(false);
            returnModel.setMessage("抱歉 没有权限！请联系管理员 " + e.getMessage());
            returnModel.setContent(e.getClass().getName());
            try {
                response.getWriter().print(JSON.toJSON(returnModel));
            } catch (IOException e1) {
                logger.error("错误：->{}",e1.getMessage());
            }
        }
        return "/noanno.vm";

    }

    @ExceptionHandler({ HttpRequestMethodNotSupportedException.class })
    @ResponseBody
    public Object processAuthorizationException(NativeWebRequest request,UnauthorizedException e){
        return null;
    }
}
