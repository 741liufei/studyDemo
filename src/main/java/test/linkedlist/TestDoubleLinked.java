package test.linkedlist;

/**
 * Created by liufei on 2018/5/2.
 */
public class TestDoubleLinked {
    static DoubleNode head = new DoubleNode(1);


    public static void addNode(DoubleNode node){
        DoubleNode temp = head;
        while (temp.next!=null){
            temp = temp.next;
        }
        node.pre = temp;
        temp.next = node;

    }

    /**
     * 在链表中的index位置插入新结点
     * @param node
     * @param index
     */
    public static void insertNodeByIndex(DoubleNode node,Integer index){
        DoubleNode temp = head;
        int length =1;
        while (temp.next!=null){
            if(index == length++){
                temp.next.pre = node;
                node.next = temp.next;
                node.pre = temp;
                temp.next = node;
            }
            temp = temp.next;
        }
    }


    public static  void main(String[] args){
        DoubleNode node = new DoubleNode(2);
        addNode(node);
        node = new DoubleNode(3);
        addNode(node);
        node = new DoubleNode(4);
        insertNodeByIndex(node,1);
        System.out.println();
    }
}
