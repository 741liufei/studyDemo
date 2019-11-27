package test.binarytree;


import com.alibaba.dubbo.rpc.service.EchoService;

/**
 * 二叉树创建
 * Created by liufei on 2018/5/8.
 */
public  class BinaryTree {
    public  Node root;

    public BinaryTree(){
        root=null;
    }

    /**
     * 建立二叉树
     * @param node
     * @param data
     */
    public  void buildTree(Node node,int data){
        if(root==null){
            root = new Node(data);
        }else {
            if(data<node.data){
                if(node.left==null){
                    node.left = new Node(data);
                }else {
                    buildTree(node.left,data);
                }
            }else {
                if (node.right==null){
                    node.right = new Node(data);
                }else {
                    buildTree(node.right,data);
                }
            }
        }
    }

    /**
     * 前序遍历 先遍历根节点然后左子树右子树
     */
    public void preSort(Node node){
        if(node!=null){
            System.out.println(node.data);
            preSort(node.left);
            preSort(node.right);
        }
    }

    /**
     * 中序遍历
     * @param node
     */
    public void midSort(Node node){
        if(node!=null){
            midSort(node.left);
            System.out.println(node.data);
            midSort(node.right);
        }
    }

    /**
     * 后序遍历
     * @param node
     */
    public void postSort(Node node){
        if(node!=null){
            postSort(node.left);
            postSort(node.right);
            System.out.println(node.data);
        }
    }

    /**
     *
     * @param node
     */
    public Node insertNode(int data,Node node){
        if(node==null){//如果目标树是一个空树则返回一个初始化新树
            return new Node(data);
        }
        if(data<node.data){//如果插入的数据比结点数据小则放入左子树
            node.left = insertNode(data,node.left);
        }else if(data>node.data){
            node.right = insertNode(data,node.right);
        }
        return node;
    }

    /**
     * 删除结点
     * @param data
     * @param node
     * @return
     */
    public static Node  remove(int data,Node node){
        if(node==null){
            return node;
        }
        //首先找到该数字所在的结点位置
        if(data>node.data){
            node.right = remove(data,node.right);
        }else if(data<node.data){
            node.left = remove(data,node.left);
        }else if(node.left!=null &&node.right!=null){
            node.data = findMin(node.right).data;
            node.right = remove(node.data,node.right);
        }else {
            node = (node.left!=null)?node.left:node.right;
        }
        return node;
    }

    /**
     * 查找最小的结点
     * @param node
     * @return
     */
    public static Node findMin(Node node){
        if(node.left!=null){
           node =findMin(node.left);
        }
        return node;
    }

    /**
     * 根据数据查找结点
     * @param data
     * @param node
     * @return
     */
    public static Node findNode(int data,Node node){
        //判断值和结点值的关系，如果等于直接返回，如果小于则找左子树，如果大于则找右子树
        if(node!=null){
            if(data==node.data){
                return node;
            }else if(data<node.data){
                node = findNode(data,node.left);
            }else {
                node =findNode(data,node.right);
            }
        }
        return node;
    }
    static int length(Node root){
        int depth1;
        int depth2;
        if(root == null) return 0;
        //左子树的深度
        depth1 = length(root.right);
        //右子树的深度
        depth2 = length(root.left);
        if(depth1>depth2)
            return depth1+1;
        else
            return depth2+1;
    }
    /**
     *
     * @param args
     */
    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        int[] nums = {7,2,1,4,3,5,8};
        for(int num:nums){
            tree.buildTree(tree.root,num );
        }
//        int find = findNode(4,tree.root).data;
        int length =length(tree.root);
        System.out.println(length);
//        tree.insertNode(5,tree.root);
//        tree.insertNode(8,tree.root);
//        System.out.println("前序遍历");
//        tree.preSort(tree.root);
//        System.out.println("中序遍历");
//        tree.midSort(tree.root);
//        System.out.println("后序遍历");
//        tree.postSort(tree.root);


    }
}
