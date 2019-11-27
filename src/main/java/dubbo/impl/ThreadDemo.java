package dubbo.impl;

import java.util.Arrays;

/**
 * Created by liufei on 2018/3/29.
 */
public class ThreadDemo implements Runnable {
    public synchronized  static void main(String[] args){
        Thread t1 = new Thread(new ThreadDemo());
        Thread t2 = new Thread(new ThreadDemo());
        t1.start();
        t2.run();
        System.out.println(Thread.currentThread().getName()+":end");
    }
    //static sychronized 对于多个实例都会进行同步控制
    //sychronized 只会对当前实例进行同步控制
     static synchronized  void print(){
        System.out.println(Thread.currentThread().getName()+":start");
    }
    @Override
    public  void run() {
        print();
    }
}
