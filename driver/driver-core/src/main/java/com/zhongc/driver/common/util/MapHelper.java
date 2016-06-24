package com.zhongc.driver.common.util;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MapHelper {
    private static final Logger logger = LoggerFactory.getLogger(MapHelper.class);

    /**
     * 将 Bean 转化为Map
     *
     * @param obj Bean
     * @return Map
     * @throws IntrospectionException
     */
    public static Map<String, Object> putBeansToMap(Object obj) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BeanInfo bean = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] pro = bean.getPropertyDescriptors();
            for (PropertyDescriptor proBean : pro) {

                String key = proBean.getName();
                if (!key.equals("class")) {
                    Method getMet = proBean.getReadMethod();
                    Object value;
                    try {
                        value = getMet.invoke(obj);
                        if (value == null) {
                            continue;
                        }
                        map.put(key, value);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();

                    } catch (IllegalArgumentException e) {

                        e.printStackTrace();

                    } catch (InvocationTargetException e) {

                        e.printStackTrace();
                    }
                }

            }
        } catch (IntrospectionException exception) {
            exception.printStackTrace();
        }

        return map;
    }

    /**
     * 将Map转换为Bean
     *
     * @param map 有参数的Map
     * @param obj Bean
     */
    public static void putMapToBeans(Map<String, Object> map, Object obj) {
        if (map == null || map.size() <= 0) {

            throw new RuntimeException("Map 不能为空");

        }
        try {

            BeanUtils.copyProperties(obj, map);

        } catch (IllegalAccessException e) {

            e.printStackTrace();
        } catch (InvocationTargetException e) {

            e.printStackTrace();
        }
    }

}
