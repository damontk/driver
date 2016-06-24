package com.zhongc.driver.web.exception;

import com.alibaba.fastjson.JSON;
import com.zhongc.driver.common.Constant;
import com.zhongc.driver.common.bean.ReturnMsg;
import com.zhongc.driver.common.util.DataUtil;

import java.util.HashMap;
import java.util.Map;

import com.zhongc.driver.common.util.MapHelper;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class CommonExceptionResolver implements HandlerExceptionResolver {
    private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
    private static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();
    private static final String BASE_PATH_KEY = "basepath";

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        String url = httpServletRequest.getRequestURI();
        logger.error("请求 " + url + "出现错误:{}" , e);
        e.printStackTrace();
        if (DataUtil.isAjax(httpServletRequest)) {
            MappingJackson2JsonView view = new MappingJackson2JsonView();
            ReturnMsg returnModel = new ReturnMsg();
            returnModel.setMessage("抱歉，系统异常 请稍后再试");
            returnModel.setSuccess(false);
            Map<String, Object> map = MapHelper.putBeansToMap(returnModel);
            view.setAttributesMap(map);
            modelAndView.setView(view);
            return modelAndView;
        }
        modelAndView.setViewName("/anon/error.vm");
        return modelAndView;
    }

    /**
     * @return
     */
    public static String getBasePath() {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            return null;
        }
        Object o = map.get(BASE_PATH_KEY);
        return o == null ? null : o.toString();
    }
}
