package com.zhongc.driver.result;

/**
 * @Filename CommonPageResult.java
 * @Description
 * @Version 1.0
 * @Author zhongc
 * @Email zhong_ch@foxmail.com
 * @History <li>Author: zhongc</li>
 * <li>Date: 2015-09-26</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class CommonPageResult extends CommonResult {

    private static final long serialVersionUID = -7490972840564752207L;

    private Pagination<?> pagination;

    public Pagination<?> getPagination() {
        return pagination;
    }

    public void setPagination(Pagination<?> pagination) {
        this.pagination = pagination;
    }
}
