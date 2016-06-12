package com.zhongc.driver.result;

/**
 * Created by zhongChao on 2015/9/25.
 */
public class CommonEntityResult extends CommonResult{

    private static final long serialVersionUID = 4662934202852163993L;
    /**
     * 传入对象
     */
    public Object obj;

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "CommonEntityResult{" +
                "obj=" + obj +
                '}';
    }
}
