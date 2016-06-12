package com.zhongc.driver.thread;

/**
 * 项目名称：SPS
 * 类名称：Children
 * 类描述： 保险业务
 * 创建人：zhongchao
 * 创建时间：2016年03月21日 下午14:14:
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
public class Children implements Runnable {

    public volatile boolean thread_wait;

    @Override
    public void run() {

        Thread t = Thread.currentThread();
        System.out.println("线程 id:" + t.getId() + "启动成功...  准备进入等待.");
        synchronized (ThreadStudy.OBJECT) {
            try {
//                System.out.println("线程 id:" + t.getId() + "等待被唤醒");
                thread_wait = true;
                System.out.println("thread_wait:"+thread_wait);
                ThreadStudy.OBJECT.wait();
            } catch (InterruptedException  e) {
                System.out.println("唤醒 唤醒");
            }
        }
        System.out.println("线程 id:" + t.getId() + " 唤醒成功！");
    }

}
