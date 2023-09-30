package lesson5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 给定两个二叉树的节点node1和node2，找到他们的最低公共祖先节点
 * */
public class Code07_LowestCommonAncestor {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int data) {
            this.value = data;
        }
    }

        public static Node lowestAncestor(Node head, Node o1, Node o2) {
            //baseCase  当前节点等于null 或 o1是o2的父节点（o2是o1的父节点） 返回当前节点
            if (head == null || head == o1 || head == o2){
                return head;
            }
            Node  left = lowestAncestor(head.left,o1,o2);
            Node right = lowestAncestor(head.right,o1,o2);
            //左树右树返回值都不为空  返回父节点
            if (left !=null && right!=null){
                return head;
            }
            //左右两边哪边不为空返回哪边
            return  left !=null ? left : right;
        }







    /**
     * 使用HashMap实现  最低公共祖先节点
     * */
    public static class Record1 {
        private HashMap<Node, Node> map;

        public Record1(Node head) {
            map = new HashMap<Node, Node>();
            if (head != null) {
                map.put(head, null);
            }
            setMap(head);
        }

        private void setMap(Node head) {
            if (head == null){
                return;
            }
            if (head.left!=null){
                map.put(head.left,head);
            }
            if (head.right!=null){
                map.put(head.right,head);
            }
            setMap(head.left);
            setMap(head.right);

        }
        public Node query(Node o1, Node o2) {
            HashSet<Node> path = new HashSet<Node>();
            while (map.containsKey(o1)){
                path.add(o1);
                o1 = map.get(o1);
            }
            while (!path.contains(o2)){
                o2 = map.get(o2);
            }
            return o2;
        }
    }
}
