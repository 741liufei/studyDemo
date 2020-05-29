package test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author liufei
 * @description:
 * @date 2020/5/25 16:47
 **/
public class FutureTest {


    public static void main(String []args){
        FutureTest futureTest = new FutureTest();
        FutureCallable futureCallable = futureTest.new FutureCallable(1);
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> future = executorService.submit(futureCallable);
        try {
            System.out.println("通过Future取值："+future.get().toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        FutureTask<Integer> futureTask = new FutureTask<>(futureCallable);
        executorService.submit(futureTask);
        try {
            System.out.println("futureTask取到的结果："+futureTask.get().toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

   class FutureCallable  implements Callable<Integer>{
       private Integer data;

       FutureCallable(Integer data){
           this.data = data;
       }

       @Override
       public Integer call(){
          return data;
       }
   }
}
