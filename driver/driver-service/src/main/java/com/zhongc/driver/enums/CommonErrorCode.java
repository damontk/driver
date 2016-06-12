package com.zhongc.driver.enums;

import com.zhongc.driver.enums.interfaces.MessageAble;

/**
 *
 *
 *
 * @Filename CommonErrorCode.java
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
public enum CommonErrorCode implements MessageAble {
	DB_ERROR("comn_00_0000", "数据库错误"),

	IO_ERROR("comn_01_0000", "IO异常"),

	NET_ERROR("comn_02_0000", "网络异常"),

	SYSTEM_ERROR("comn_03_0000", "程序错误"),

	UNKNOWN_ERROR("comn_04_0000", "未知异常"),

	NO_INFO("comn_10_0000","未查询到信息"),

	USER_UNACTIVATED("comn_11_0001", "用户未激活"),

	USERNAME_OR_PASSWORD_ERROR("comn_11_0002", "账户名或密码错误"),

	USER_FREEZE("Ucomn_11_0003", "账户被冻结"),

	USERNAME_EXIST("comn_11_0004", "账户已存在"),

	USERNAME_NOT_EXIST("comn_11_0005", "账户不存在"),

	SUCCESS("comn_04_0001", "执行成功"),

	INVALID_ARGUMENTS("comn_04_0003", "请求参数非法"),

	REQUEST_REPEATED("comn_04_0004", "重复的请求"),

	ORDER_IS_NULL("comn_04_0005", "请求参数为空"),

	UNSUPPORTED_CURRENCY("comn_04_0006", "不支持的币种"),

	CURRENCY_NOT_MATCH("comn_04_0007", "币种不匹配");

	/** 枚举值 */
	private final String code;

	/** 枚举描述 */
	private final String message;

	/**
	 *
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private CommonErrorCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	/**
	 * @return Returns the code.
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return Returns the message.
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return Returns the code.
	 */
	public String code() {
		return code;
	}

	/**
	 * @return Returns the message.
	 */
	public String message() {
		return message;
	}

	/**
	 * 通过枚举<code>code</code>获得枚举
	 *
	 * @param code
	 * @return CommonErrorCodeEnum
	 */
	public static CommonErrorCode getByCode(String code) {
		for (CommonErrorCode _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}

	/**
	 * 获取全部枚举
	 *
	 * @return List<CommonErrorCodeEnum>
	 */
	public static java.util.List<CommonErrorCode> getAllEnum() {
		java.util.List<CommonErrorCode> list = new java.util.ArrayList<CommonErrorCode>(values().length);
		for (CommonErrorCode _enum : values()) {
			list.add(_enum);
		}
		return list;
	}

	/**
	 * 获取全部枚举值
	 *
	 * @return List<String>
	 */
	public static java.util.List<String> getAllEnumCode() {
		java.util.List<String> list = new java.util.ArrayList<String>(values().length);
		for (CommonErrorCode _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}

	/**
	 * 通过code获取msg
	 * @param code 枚举值
	 * @return
	 */
	public static String getMsgByCode(String code) {
		if (code == null) {
			return null;
		}
		CommonErrorCode _enum = getByCode(code);
		if (_enum == null) {
			return null;
		}
		return _enum.getMessage();
	}

	/**
	 * 获取枚举code
	 * @param _enum
	 * @return
	 */
	public static String getCode(CommonErrorCode _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}


