package lesson4;

import java.util.HashMap;
import java.util.Map;

/**
 * rand指针是单链表节点结构中新增的指针，rand可能指向链表中的任意一个节
 * 点，也可能指向null。给定一个由Node节点类型组成的无环单链表的头节点
 * head，请实现一个函数完成这个链表的复制，并返回复制的新链表的头节点。
 * */
public class Code06_CopyListWithRandom {

    public static class Node{
        int value;
        Node next;
        Node random;
        public Node(int value) {
            this.value = value;
        }
    }

    public static Node copyListWithRand1(Node head) {
        if (head==null){
            return head;
        }
        //Key放就节点，Value放新节点
        Map<Node,Node> map = new HashMap<>();
        Node cur = head;
        while (cur!=null){
            //复制新节点放入map
            map.put(cur,new Node(cur.value));
            cur = cur.next;
        }
        cur=head;
        while (cur!=null){
            //复制节点的next指针指向  等于  旧节点的下一个map对应的Value
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    //将复制的新节点就放在 旧节点的next
    public static Node copyListWithRand2(Node head) {
        if (head==null){
            return head;
        }
        Node cur = head;
        Node next = null;
        //将复制的新节点就放在 旧节点的next
        while (cur!=null){
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next =next;
            cur = next;
        }
        cur = head;
        //从头节点开始遍历 先不管next指针
        //复制新节点的random指针 等于 旧节点的random.next
        while (cur!=null){
            cur.next.random = cur.random != null ? cur.random.next : null;
            cur = cur.next.next;
        }
        Node res = head.next;
        cur = head;
        Node copyNode =null;
        //遍历将旧节点还原 ， 并且新节点的next指针 等于 旧节点的next.next.next
        while (cur!=null){
            copyNode = cur.next;
            next = cur.next.next;
            copyNode.next = next !=null ? next.next : null;
            cur.next = next;
            cur = next;
        }
        return res;
    }




    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.random == null ? "- " : cur.random.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        Node res1 = null;
        Node res2 = null;
        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.random = head.next.next.next.next.next; // 1 -> 6
        head.next.random = head.next.next.next.next.next; // 2 -> 6
        head.next.next.random = head.next.next.next.next; // 3 -> 5
        head.next.next.next.random = head.next.next; // 4 -> 3
        head.next.next.next.next.random = null; // 5 -> null
        head.next.next.next.next.next.random = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

    }

}
