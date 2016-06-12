package com.zhongc.driver.thread.demo;

import java.util.concurrent.Callable;

/**
 * 项目名称：SPS
 * 类名称：Player
 * 类描述： 保险业务
 * 创建人：zhongchao
 * 创建时间：2016年03月24日 下午14:50:
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
public class Player implements Callable<Result>,Comparable<Player> {


    @Override
    public Result call() throws Exception {
        return null;
    }

    @Override
    public int compareTo(Player o) {
        return 0;
    }
}
class Result{

}
