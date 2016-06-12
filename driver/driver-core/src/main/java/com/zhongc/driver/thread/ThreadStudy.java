package com.zhongc.driver.thread;

import org.apache.zookeeper.data.Id;

/**
 * 项目名称：SPS
 * 类名称：ThreadStudy
 * 类描述： 线程学习类
 * 创建人：zhongchao
 * 创建时间：2016年03月21日 下午13:39:
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
public class ThreadStudy implements Runnable {
    public static final Object OBJECT = new Object();

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadStudy());
        thread.start();
//        thread.sleep(3000);
//        thread.interrupt();

    }

    @Override
    public void run() {
        Thread t, t2, t3;
//        for (int i = 0; i < 3; i++) {
//            Children children = new Children();
        Children c1 = new Children();
        Children c2 = new Children();
        Children c3 = new Children();
        t = new Thread(c1);
        t2 = new Thread(c2);
        t3 = new Thread(c3);
        t.start();
        t2.start();
        t3.start();
//        t.interrupt();
        while (!c1.thread_wait ) {
            try {
                System.out.println("wait.....");
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized (ThreadStudy.OBJECT) {
            ThreadStudy.OBJECT.notifyAll();
        }
        synchronized (ThreadStudy.class)

        {
            try {
                ThreadStudy.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


