package com.zhongc.driver.enums.interfaces;

import java.io.Serializable;

/**
 *
 *
 *
 * @Filename MessageAble.java
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
 *<li>Date: 2015年7月13日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public interface MessageAble extends Serializable {

	/**
	 * 编码
	 */
	String code();

	/**
	 * 信息
	 */
	String message();

}