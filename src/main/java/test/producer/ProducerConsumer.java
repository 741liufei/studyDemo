package test.producer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liufei
 * @description:
 * @date 2020/5/21 19:58
 **/
public class ProducerConsumer {

    public static class  Producer implements Runnable{
        private List<PCData> queue ;
        private int length;

        public Producer(List<PCData> queue,int length){
            this.queue = queue;
            this.length = length;
        }

        @Override
        public void run() {
            while (true){
                if (Thread.currentThread().isInterrupted()){
                    break;
                }
                Random random = new Random();
                int temp = random.nextInt(100);
                PCData pcData = new PCData(temp);
                System.out.println(Thread.currentThread().getId()+"生产了：data="+temp);
                try {
                    synchronized (queue){
                        if(queue.size()>length){
                            queue.notifyAll();
                            queue.wait();
                        }else {
                            queue.add(pcData);
                        }
                        Thread.sleep(100);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Consumer implements Runnable{
        private List<PCData> queue;

        public  Consumer(List<PCData> queue){
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true){
                if(Thread.currentThread().isInterrupted()){
                    break;
                }
                try {
                    PCData data = null;
                    synchronized (queue){
                        if(queue.size()==0){
                            queue.notifyAll();
                            queue.wait();
                        }else {
                            data = queue.remove(0);
                        }
                    }
                    if(data !=null){
                        System.out.println(Thread.currentThread().getId()+"消费了：data="+data.getPCData());
                    }
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String args[]){
        List<PCData> queue= new ArrayList<>();
        int length = 10;
        Producer p1 = new Producer(queue,length);
        Producer p2 = new Producer(queue,length);
        Producer p3 = new Producer(queue,length);
        Consumer c1 = new Consumer(queue);
        Consumer c2 = new Consumer(queue);
        Consumer c3 = new Consumer(queue);

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10,10,1, TimeUnit.SECONDS,new LinkedBlockingQueue(1));
        poolExecutor.execute(p1);
        poolExecutor.execute(p2);
        poolExecutor.execute(p3);
        poolExecutor.execute(c1);
        poolExecutor.execute(c2);
        poolExecutor.execute(c3);



    }

public static class PCData{
        private int PCData;

        public PCData(int PCData){
            this.PCData = PCData;
        }

    public int getPCData() {
        return PCData;
    }

    public void setPCData(int PCData) {
        this.PCData = PCData;
    }
}
}
