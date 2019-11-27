package test.thread;

import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.nio.channels.ClosedSelectorException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by liufei on 2018/4/25.
 */
public class ThreadPoolTest {

    public static  void main(String[] args){


        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        //核心线程数
        threadPoolTaskExecutor.setCorePoolSize(1);
        //最大线程数
        threadPoolTaskExecutor.setMaxPoolSize(1);
        //线程存活时间
        threadPoolTaskExecutor.setKeepAliveSeconds(1000);
        //队列最大长度
        threadPoolTaskExecutor.setQueueCapacity(1);
        //直接丢弃的拒接策略
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
        threadPoolTaskExecutor.initialize();
        List<Future> futureList = new ArrayList<Future>();
        for(int i=0;i<10;i++){
            threadPoolTaskExecutor.execute(new TestThread(i));
//            futureList.add(threadPoolTaskExecutor.submit(new ThreadCall(i)));
        }
//        try {
//            for(Future future:futureList){
//                System.out.println(future.get().toString());
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

    }

    static class TestThread implements Runnable{
        int name;
        TestThread(int name){
            this.name = name;
        }
        @Override
        public void run(){
//            try {
//                Thread.sleep(2000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println("线程："+Thread.currentThread().getName()+":start");
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
            System.out.println("有返回值的线程："+Thread.currentThread().getName()+":start");

            return id;
        }
    }
}
