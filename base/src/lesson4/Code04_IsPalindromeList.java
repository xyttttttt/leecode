package lesson4;

import java.util.Stack;

/**
 * 判断一个链表是否为回文结构
 *
 * 1->2->1，返回true； 1->2->2->1，返回true；15->6->15，返回true；
 * 1->2->3，返回false。
 * */
public class Code04_IsPalindromeList {

    public static class Node{
        public int value;
        public Node next;
        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isPalindrome1(Node head){
        Stack<Node> nodes = new Stack<>();
        Node cur = head;
        while (cur!=null){
            nodes.push(cur);
            cur =head.next;
        }
        while (head!=null){
            if (head.value != nodes.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome2(Node head) {
        if (head ==null || head.next ==null){
            return true;
        }
        Node right = head.next;
        Node cur = head;
        while (cur.next != null && cur.next.next !=null){
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Node> nodes = new Stack<>();
        while (right!=null){
            nodes.push(right);
            right = right.next;
        }
        while (!nodes.empty()){
            if (head.value != nodes.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
