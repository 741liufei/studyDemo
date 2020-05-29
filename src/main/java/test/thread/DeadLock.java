package test.thread;

/**
 * @author liufei
 * @description: sychronized实现死锁
 * @date 2020/5/22 16:14
 **/
public class DeadLock {
    private Object object1 = new Object();
    private Object object2 = new Object();

    public void method1(){
        synchronized (object1){
            try {
                System.out.println("method1+object1锁");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object2){
                System.out.println("method1+object2锁");
            }
        }
    }
    public void method2(){
        synchronized (object2){
            System.out.println("method2+object2锁");
            synchronized (object1){
                System.out.println("method2+object1锁");
            }
        }
    }

    public static void main(String[]args){
        DeadLock deadLock = new DeadLock();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.method1();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.method2();
            }
        });

        thread1.start();
        thread2.start();

    }
}
