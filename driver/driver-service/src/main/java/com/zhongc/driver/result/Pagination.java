package com.zhongc.driver.result;

import java.util.List;

/**
 * @Filename Pagination.java
 * @Description
 * @Version 1.0
 * @Author zhongc
 * @Email zhong_ch@foxmail.com
 * @History <li>Author: zhongc</li>
 * <li>Date: 2015-09-26</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 *
 * 分页查询结果公用类
 */
public class Pagination<T> {
    private static final long serialVersionUID = 1L;
    public static final int DEFAULT_PAGE_SIZE = 12;
    public static final int DEFAULT_PAGE = 1;
    private int page = 1;
    private int size = 12;
    private long totalClause;
    private int totalPage;
    private long start;
    private long end;
    private List<T> result;

    public Pagination() {
    }

    public Pagination(int page, int size, long totalClause, List<T> result) {
        this.page = page;
        this.size = size;
        this.totalClause = totalClause;
        this.result = result;
        this.start = (long)((page - 1) * size);
        this.end = (long)(page * size);
        if(this.end > totalClause) {
            this.end = totalClause;
        }

        this.totalPage = (int)(totalClause % (long)size == 0L?totalClause / (long)size:totalClause / (long)size + 1L);
    }

    public boolean hasNext() {
        return this.totalClause > this.end;
    }

    public boolean hasPrevious() {
        return this.page > 1;
    }

    public int getNext() {
        return this.totalClause > this.end?this.page + 1:this.page;
    }

    public int getPrevious() {
        return this.page > 1?this.page - 1:this.page;
    }

    public int getPage() {
        return this.page;
    }

    public int getSize() {
        return this.size;
    }

    public long getTotalClause() {
        return this.totalClause;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public long getStart() {
        return this.start;
    }

    public long getEnd() {
        return this.end;
    }

    public List<T> getResult() {
        return this.result;
    }

    public String toString() {
        return "Pagination [page=" + this.page + ", size=" + this.size + ", totalClause=" + this.totalClause + ", totalPage=" + this.totalPage + ", start=" + this.start + ", end=" + this.end + ", result=" + this.result + "]";
    }
}
