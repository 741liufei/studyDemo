package test.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import test.bean.Person;

/**
 * Created by liufei on 2018/4/25.
 */
public class ThreadPoolTest {
    public static int total =0;
//    public static Person person = new Person();

    public static ThreadLocal<Person> threadLocal = new ThreadLocal<>();
    public static  void main(String[] args) throws InterruptedException {


        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        //核心线程数
        threadPoolTaskExecutor.setCorePoolSize(1000);
        //最大线程数
        threadPoolTaskExecutor.setMaxPoolSize(1000);
        //线程存活时间
        threadPoolTaskExecutor.setKeepAliveSeconds(1000);
        //队列最大长度
        threadPoolTaskExecutor.setQueueCapacity(1000);
        //直接丢弃的拒接策略
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
        threadPoolTaskExecutor.initialize();
        List<Future> futureList = new ArrayList<Future>();
        int threadCount =10;
        //线程计数器
        final CountDownLatch latch = new CountDownLatch(threadCount);
        ThreadLocal<Person> threadLocal = new ThreadLocal<Person>();
//        for(int i=0;i<threadCount;i++){
//            ThreadLocal<Integer> stringThreadLocal = new ThreadLocal<>();
//            stringThreadLocal.set(i);
//            threadPoolTaskExecutor.execute(new TestThread(i,latch));
//            int ret = stringThreadLocal.get();
//            futureList.add(threadPoolTaskExecutor.submit(new ThreadCall(i)));
//        }
        ThreadCall threadCall = new ThreadCall(1);
        Future future = threadPoolTaskExecutor.submit(threadCall);
        try {
            String result = future.get().toString();
            System.out.println("线程返回结果为："+result);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
//        //等待线程执行完毕
//        try {
//            latch.await();
//            System.out.println("累加结果："+total);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        try {
            for(Future future1:futureList){
                System.out.println(future.get().toString());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    static class TestThread implements Runnable{
        int name;
        CountDownLatch latch;
        TestThread(int name,final CountDownLatch latch){
            this.name = name;
            this.latch = latch;
        }
        @Override
        public void run(){
//            try {
//                Thread.sleep(2000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            try {
                Person person = threadLocal.get();
                if (person == null){
                    person  = new Person();
                    person.setNumber(name);
                }
                threadLocal.set(person);
                total = total+1;
                if(name != person.getNumber()){
                    System.out.println("出现数据冲突，线程："+name+",取到的值是："+person.getNumber());
                }else {
                    System.out.println("线程"+person.getNumber()+":start");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                latch.countDown();
                threadLocal.remove();
            }

        }
    }

    /**
     * 有返回值的线程
     */
    static class ThreadCall implements Callable{
        private Integer id ;

        ThreadCall(Integer id){
            this.id = id;
        }
        @Override
        public Object call(){
            try {
//                Thread.sleep(1000L);
            } catch (Exception e) {
                e.printStackTrace();
            }
//            System.out.println("有返回值的线程："+Thread.currentThread().getName()+":start");

            return id;
        }
    }
}
