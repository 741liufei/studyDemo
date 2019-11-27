package test.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 测试队列使用
 * @author feis.liu
 * @description:
 * @date 2019/11/20 19:13
 **/
public class TestQuery {

    public static void main(String[] args){
        Queue<Integer> queue =new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.toString());
        queue.remove();
        queue.offer(4);
        System.out.println(queue.toString());

    }
}

