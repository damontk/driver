package com.zhongc.driver.common.util;

import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.HibernateValidatorConfiguration;

import javax.validation.Configuration;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 *
 *
 *
 * @Filename Validator.java
 *
 * @Description
 *
 * @Version 1.0
 *
 * @Author zhongc
 *
 * @Email zhong_ch@foxmail.com
 *
 * @History
 *<li>Author: zhongc</li>
 *<li>Date: 2015年7月14日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class Validator {

	private static javax.validation.Validator validator = null;

	static {
		Configuration<HibernateValidatorConfiguration> config =

		Validation.byProvider(HibernateValidator.class).configure();

		ValidatorFactory vf = config.buildValidatorFactory();

		validator = vf.getValidator();
	}

	public static <T> void validate(T t){
		if(t == null){
			throw new IllegalArgumentException("参数不能为空");
		}
		Set<ConstraintViolation<T>> set = validator.validate(t);
		if(set == null || set.size() < 1){
			return ;
		}
		StringBuilder builder = new StringBuilder();
		for (ConstraintViolation<T> constraintViolation : set) {
			builder.append("\"message\":"+"\""+constraintViolation.getMessage()+"\""+",");
		}
		String s =null;
		if (builder.length()>0) {
			s=builder.substring(0, builder.length()-1);
		}
		throw new IllegalArgumentException(s);
	}

}
