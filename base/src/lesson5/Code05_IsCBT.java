package lesson5;

import java.util.LinkedList;
/**
 * 完全二叉树
 * */
public class Code05_IsCBT {
    public static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isCBT(Node head) {
        if (head == null){
            return true;
        }
        LinkedList<Node> nodeLinkedList  = new LinkedList<>();
        nodeLinkedList.add(head);
        Node left = null;
        Node right = null;
        boolean leaf = false;
        while (!nodeLinkedList.isEmpty()){
            head = nodeLinkedList.poll();
            left = head.left;
            right = head.right;
            if (left==null && right !=null || (leaf && (left != null || right !=null))){
                return false;
            }
            if (left != null){
                nodeLinkedList.add(left);
            }
            if (right != null){
                nodeLinkedList.add(right);
            }else {
                leaf = true;
            }
        }
        return true;
    }
}
