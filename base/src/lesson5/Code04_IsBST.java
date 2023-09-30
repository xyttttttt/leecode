package lesson5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * 是否是线索二叉树
 * */
public class Code04_IsBST {
    public static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    public boolean isBST(Node head){
        if (head == null){
            return true;
        }
        LinkedList<Node> inOrderList = new LinkedList<>();
        inOrderProcess(head,inOrderList);
        int pre = Integer.MIN_VALUE;
        for (Node cur:inOrderList){
            if (pre > cur.value){
                return false;
            }
            pre = cur.value;
        }
        return true;
    }

    private void inOrderProcess(Node head, List<Node> inOrderList) {
        if (head == null){
            return;
        }
        inOrderProcess(head.left,inOrderList);
        inOrderList.add(head);
        inOrderProcess(head.right,inOrderList);
    }

    public static class ReturnData{
        public boolean isBst;
        public int min;
        public int max;
        public ReturnData(boolean isBst, int min, int max) {
            this.isBst = isBst;
            this.min = min;
            this.max = max;
        }
    }


    //递归方式 是否是线索二叉树
    public static ReturnData process(Node head){
        if (head == null){
            return null;
        }
        ReturnData leftData = process(head.left);
        ReturnData rightData = process(head.right);

        boolean isBST = true;
        int min = head.value;
        int max = head.value;
        if (head.left !=null){
            min = Math.min(min,leftData.min);
            max = Math.max(max,rightData.max);
        }
        if (head.right !=null){
            min = Math.min(min,leftData.min);
            max = Math.max(max,rightData.max);
        }

        if (leftData!=null &&(!leftData.isBst  ||   leftData.max >= head.value)){
            isBST = false;
        }
        if (rightData!=null && (!rightData.isBst ||  rightData.min <= head.value)){
            isBST = false;
        }
        if (    (leftData!=null ? (leftData.isBst && leftData.max < head.value) : true)
                &&
                (rightData !=null ? (rightData.isBst) && rightData.min > head.value : true)
            ){
            isBST = true;
        }
        return new ReturnData(isBST,min,max);
    }

    /**
     * 是否是满二叉树
     * */
    public static boolean isF(Node head){
        if (head == null){
            return true;
        }
        Info data = process1(head);
        return data.nodes == (1<<data.height -1);
    }

    public static class Info{
        public int height;
        public int nodes;
        public Info(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }

    public static Info process1(Node x){
        if (x == null){
            return new Info(0,0);
        }
        Info leftData = process1(x.left);
        Info rightData= process1(x.right);
        int height = Math.max(leftData.height,rightData.height)+1;
        int nodes = leftData.nodes+rightData.nodes + 1;
        return new Info(height,nodes);
    }
}
