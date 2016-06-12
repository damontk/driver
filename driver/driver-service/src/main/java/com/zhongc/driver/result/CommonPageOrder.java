package com.zhongc.driver.result;

import java.util.Date;

/**
 * Created by zhongChao on 2015/9/25.
 *
 * 分页查询公共类
 */
public class CommonPageOrder {

    /**
     * 开始页
     */
    private int start;

    /**
     * 显示条数
     */
    private int size;

    /**
     * 开始日期
     */
    private Date beginTime;

    /**
     * 结束日期
     */
    private Date endTime;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "CommonPageOrder{" +
                "start=" + start +
                ", size=" + size +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                '}';
    }
}
