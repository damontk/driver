package com.zhongc.driver.common.bean;

/**
 * @Filename ReturnMsg.java
 * @Description
 * @Version 1.0
 * @Author zhongc
 * @Email zhong_ch@foxmail.com
 * @History
 * <li>Author: zhongc</li>
 * <li>Date: 2015-11-13</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 *
 * 通用返回信息
 *
 */
public class ReturnMsg {

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 描述信息
     */
    private String message;

    /**
     * 内容
     */
    private Object content;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ReturnMsg{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", content=" + content +
                '}';
    }
}
