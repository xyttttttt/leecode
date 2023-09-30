package lesson5;

import java.util.Stack;

public class Code01_PreInPosTraversal {

    public static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
        }
    }
    public static void preOrderRecur(Node head) {
        if (head == null){
            return;
        }
        System.out.println(head.value +" ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void inOrderRecur(Node head) {
        if (head == null){
            return;
        }
        inOrderRecur(head.left);
        System.out.println(head.value+" ");
        inOrderRecur(head.right);
    }

    public static void postOrderRecur(Node head){
        if (head==null){
            return;
        }
        postOrderRecur(head.left);
        postOrderRecur(head.right);
        System.out.println(head.value+" ");
    }

    public static void preOrderUnRecur(Node head) {
        if (head!=null){
            Stack<Node> nodeStack = new Stack<>();
            nodeStack.add(head);
            while (!nodeStack.empty()){
                head = nodeStack.pop();
                System.out.print(head.value + " ");
                if (head.right!=null){
                    nodeStack.push(head.right);
                }
                if (head.left!=null){
                    nodeStack.push(head.left);
                }
            }
        }
    }

    public static void inOrderUnRecur(Node head) {
        if (head!=null){
            Stack<Node> nodeStack = new Stack<Node>();

            while (!nodeStack.isEmpty() || head!= null) {

                if (head!=null){
                    nodeStack.push(head);
                    head = head.left;
                }else{
                    head = nodeStack.pop();
                    System.out.println(head.value+" ");
                    head = head.right;
                }
            }
        }
    }

    //按照栈的先序遍历改进  s2中 按头右左的顺序压栈  最后输出按照左右头  （后序遍历）
    public static void postOrderUnRecur(Node head) {
        if (head != null) {
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head);
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()) {
                System.out.print(s2.pop().value + " ");
            }
        }
        System.out.println();
    }


    public static void postOrderUnRecur2(Node head) {
        if (head!=null){
            Stack<Node> nodeStack = new Stack<>();
            nodeStack.push(head);
            while (!nodeStack.isEmpty()){
                Node cur = nodeStack.peek();
                if (cur.left!=null && head != cur.left && head != cur.right){
                    nodeStack.push(cur.left);
                }else if (cur.right != null && head != cur.right){
                    nodeStack.push(cur.right);
                }else {
                    System.out.println(nodeStack.pop().value+" ");
                    head = cur;
                }
            }
        }
    }
}
