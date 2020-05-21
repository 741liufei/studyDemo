package test.linkedlist;

/**
 * @author liufei
 * @description:
 * @date 2020/5/21 18:01
 **/
public class NodeTest {

    public static void main(String []args){
        Node n1 = new Node(1);
        Node n2 = new Node(5);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next =n4;
        Node newNode = reverse(n1);
       newNode.toPrint(newNode);
    }

    /**
     * 单链表的反转
     * @param head
     * @return
     */
    public  static Node reverse(Node head){
        if(head ==null||head.next == null){
            return head;
        }
        Node temp = head.next;
        Node newNode = reverse(head.next);
        temp.next = head;
        head.next = null;
        return newNode;
    }
}
