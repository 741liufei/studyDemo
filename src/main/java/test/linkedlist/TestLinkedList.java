package test.linkedlist;

/**
 * Created by liufei on 2018/4/24.
 */
public class TestLinkedList {
    public static Node head = new Node(1);

    /**
     * 增加结点，直接向链表的最后一个结点插入新的结点
     * @param linkedList
     */
    public static void addLink(Node linkedList){
        Node temp = head;
        //遍历链表所有的结点，找到最后一个结点
        while (temp.next!=null){
            temp = temp.next;
        }
        //新增的数据增加到链表的最后一个结点
        temp.next = linkedList;
    }

    /**
     * 插入链表指定
     * @param index
     * @param linkedList
     */
    public static void insertByIndex(int index,Node linkedList){
        if(index<1||index>length()+1){//指定位置超出链表结点数量
            return ;
        }
        Node temp = head;
        //记录结点位置
        int length = 1;
        while(head.next!=null){
            if(index == length++){
                //temp是当前位置的前一个结点
                //temp.next 是当前结点，把当前结点放入待插入链表中
                //temp.next = linkedList ,linkedList.next =原来的temp.next
                //这样linkedList 就会插入到原来的temp和temp.next之间
                linkedList.next = temp.next;
                temp.next = linkedList;
                return;
            }
            temp = temp.next;
        }
    }
    /**
     * insertNodeByIndex:在链表的指定位置插入结点。
     *         插入操作需要知道1个结点即可，当前位置的前一个结点
     * index:插入链表的位置，从1开始
     * node:插入的结点
     */
    public void insertNodeByIndex(int index,Node node){
        //首先需要判断指定位置是否合法，
        if(index<1||index>length()){
            System.out.println("插入位置不合法。");
            return;
        }
        int length = 1;            //记录我们遍历到第几个结点了，也就是记录位置。
        Node temp = head;        //可移动的指针
        while(head.next != null){//遍历单链表
            if(index == length++){        //判断是否到达指定位置。
                //注意，我们的temp代表的是当前位置的前一个结点。
                //前一个结点        当前位置        后一个结点
                //temp            temp.next     temp.next.next
                //插入操作。
                node.next = temp.next;
                temp.next = node;
                return;
            }
            temp = temp.next;
        }
    }

    /**
     * 删除链表指定结点
     * @param index
     */
    public static void deleteNode(int index){
        if(index<1||index>length()){
            System.out.println("链表删除位置有误");
        }
        int length = 1;
        Node temp = head;
        while (temp.next!=null){
            if(index == length++){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
    }


    /**
     * 计算单链表的长度
     * @return
     */
    public static int length(){
        int length=1;
        Node temp = head;
        while (temp.next!=null){
            length++;
            temp = temp.next;
        }
        return length;
    }



    public static void main(String[] args){
        Node node = new Node(2);
        addLink(node);
        node = new Node(3);
        addLink(node);
        node = new Node(4);
        insertByIndex(1,node);
//        deleteNode(1);
//        Node newNode = null;
//        Node next = node.next;
//        node.next = newNode;
//        newNode = node;
//        node = next;

        System.out.println();
    }

}
