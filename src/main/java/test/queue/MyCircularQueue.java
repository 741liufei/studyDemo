package test.queue;

/**
 * @author feis.liu
 * @description: 循环队列
 * @date 2019/11/22 14:59
 **/
public class MyCircularQueue {

    public static void main(String[] args){
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3

        circularQueue.enQueue(1);  // 返回 true

        circularQueue.enQueue(2);  // 返回 true

        circularQueue.enQueue(3);  // 返回 true

        circularQueue.enQueue(4);  // 返回 false，队列已满

        circularQueue.Rear();  // 返回 3

        circularQueue.isFull();  // 返回 true

        circularQueue.deQueue();  // 返回 true

        circularQueue.enQueue(4);  // 返回 true

        circularQueue.Rear();  // 返回 4

    }



    public int[] queryList;
    public int head;
    public int tail;
    public int size;

    public MyCircularQueue(int k) {
        queryList = new int[k];
        head = -1;
        tail = -1;
        size = k;
    }

    /**
     * 获取队首的元素
     * @return
     */
    public int Front(){
        if(isEmpty()){
            return -1;
        }
        return queryList[head];
    }

    /**
     * 获取队尾的元素
     * @return
     */
    public int Rear(){
        if(isEmpty()){
            return -1;
        }
        return queryList[tail];
    }

    /**
     * 插入一个元素
     * @return
     */
    public boolean enQueue(int value){
        if (isFull()){
            return  false;
        }
        if (isEmpty()){
           head = 0;
        }
        tail = (tail + 1) % size;
        queryList[tail] = value;
        return true;
    }

    public boolean deQueue(){
        if (isEmpty()){
            return false;
        }
        if (head == tail){
            head=-1;
            tail=-1;
            return true;
        }
        head = (head + 1) % size;
        return true;
    }

    public boolean isFull(){

        return (tail+1)%size == head;

    }

    /**
     * 当head为初始值的时候为空
     * @return
     */
    public boolean isEmpty(){
        return head == -1;
    }
}
