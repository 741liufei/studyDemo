package test.linkedlist;

/**
 * @author liufei
 * @description: 两个有序链表的合并
 * @date 2020/5/20 20:10
 **/
public class MergeNode {

    public static void main(String[]args){
        Node n1 = new Node(1);
        Node n2 = new Node(5);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n3.next = n4;
        Node newNode = mergeNode(n1,n3);

        Node newNode2 = mergeByRecursion(n1,n3);
        System.out.println(newNode);

    }

    public static Node mergeByRecursion(Node list1,Node list2){
        if(list1 == null){
            return  list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.data <= list2.data){
            list1.next = mergeByRecursion(list1.next,list2);
            return list1;
        }else {
            list2.next = mergeByRecursion(list2.next,list1);
            return list2;
        }
    }

    /**
     * 非递归方法
     * @param list1
     * @param list2
     * @return
     */
    public static Node mergeNode(Node list1, Node list2){
        if(list1 == null){
            return  list2;
        }
        if(list2 == null){
            return list1;
        }
        //记录第一个节点代表整个结果
        Node result = null;
        //记录链表的最后一个节点
        Node last = null;
        while (list1 != null && list2 !=null){
            if(list1.data <= list2.data){
                if(result == null){//第一个值取小的nA
                    result = list1;
                }else {
                    last.next = list1;
                }
                //result和last用了nA的同一个引用地址，nA的变化会引起last变化会引起result的变化
                last = list1;
                //last发生变化
                //指向nA 的下一个元素
                list1 = list1.next;
            }else {
                if(result == null){
                    result = list2;
                }else {//这里last和result还是同一个数据last.next会导致result.next同样变化
                    last.next = list2;
                }
                last = list2;
                list2 = list2.next;
            }
        }
        //nA或者NB已经循环完
        if(list1 != null){
            last.next = list1;
        }else {
            last.next = list2;
        }
        return  result;
    }
}
