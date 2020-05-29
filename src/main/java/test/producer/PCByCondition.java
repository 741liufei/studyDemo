package test.producer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liufei
 * @description: 通过Condition+ReenTrantLock实现生产者消费者
 * @date 2020/5/22 12:59
 **/
public class PCByCondition {

    volatile List<Integer> queue ;
    int size ;
    public  static ReentrantLock lock = new ReentrantLock();
    //队列为空时阻塞的消费者
    public static Condition empty =lock.newCondition();
    //队列满时阻塞的生产者
    public static Condition full = lock.newCondition();

    PCByCondition(int size){
        queue = new ArrayList<>();
        this.size = size;
    }



    class Producer implements Runnable{
        @Override
        public void run() {
                    while (true){
                        lock.lock();
                        Random random = new Random();
                        int temp = random.nextInt(10);
                        try {

                            if (queue.size()>=size){
                                System.out.println("生产者线程："+Thread.currentThread().getName()+"被挂起，当前队列数量:"+queue.size());
                                //挂起生产者
                                full.await();
                            }

                        queue.add(temp);
                        System.out.println("生产者线程："+Thread.currentThread().getName()+"写入数据:"+temp+",当前队列数量:"+queue.size());
                            //通知消费者消费
                            empty.signal();
                        Thread.sleep(100);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                            lock.unlock();
                        }
                    }

        }
    }

    class  Consumer implements Runnable{

        @Override
        public void run() {
            while (true){
                lock.lock();
                try {
                    if(queue.size()==0){
                        //队列为空等待挂起
                        System.out.println("消费者线程："+Thread.currentThread().getName()+"被挂起，当前队列数量:"+queue.size());
                        empty.await();
                    }else {
                        //消费数据
                        Integer value = queue.get(0);
                        queue.remove(0);
                        System.out.println("消费者线程："+Thread.currentThread().getName()+",消费了数据:"+value+",当前队列数量:"+queue.size());
                        //通知生产者继续生产
                        full.signal();
                        Thread.sleep(1000);

                    }


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }

           }
    }

    public static void main(String[]args){
        PCByCondition pcByCondition = new PCByCondition(4);
        Producer p1 = pcByCondition.new Producer();
        Producer p2 = pcByCondition.new Producer();
        Consumer c1 = pcByCondition.new Consumer();
        Consumer c2 = pcByCondition.new Consumer();
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4,4,10, TimeUnit.SECONDS, new ArrayBlockingQueue(10));
//        threadPoolExecutor.execute(p1);
//        threadPoolExecutor.execute(p2);
//        threadPoolExecutor.execute(c2);
//
//        threadPoolExecutor.execute(c1);

        Thread thread1 = new Thread(p1);
        Thread thread2 = new Thread(c1);
        thread1.start();
        thread2.start();


    }
}
