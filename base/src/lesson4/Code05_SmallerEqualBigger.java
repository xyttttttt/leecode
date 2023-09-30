package lesson4;

import javax.print.attribute.standard.NumberUp;
/**
 * 给定一个单链表的头节点head，节点的值类型是整型，再给定一个整
 * 数pivot。实现一个调整链表的函数，将链表调整为左部分都是值小于pivot的
 * 节点，中间部分都是值等于pivot的节点，右部分都是值大于pivot的节点。
 * */
public class Code05_SmallerEqualBigger {

    public static class Node{
        int value ;
        Node next;
        public Node(int value) {
            this.value = value;
        }
    }

    public static Node listPartition1(Node head, int pivot) {
        if (head == null){
            return head;
        }
        int i = 0;
        Node cur = head;
        while (cur!=null){
            i++;
            cur= cur.next;
        }
        Node[] nodeArr = new Node[i];
        cur = head;
        for (i = 0; i < nodeArr.length; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodeArr,pivot);
        for (i = 1; i< nodeArr.length;i++){
            nodeArr[i-1].next = nodeArr[i];
        }
        nodeArr[i].next=null;
        return nodeArr[0];
    }

    public static void arrPartition(Node[] nodeArr, int pivot) {
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index!=big){
            if (nodeArr[index].value<pivot){
                swap(nodeArr,++small,index++);
            }else if (nodeArr[index].value > pivot){
                swap(nodeArr,--big,index);
            }else {
                index++;
            }
        }
    }
    public static void swap(Node[] nodeArr, int a, int b) {
        Node temp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = temp;
    }


    public static Node listPartition2(Node head, int pivot) {
        Node sH=null;
        Node sT=null;
        Node eT=null;
        Node eH=null;
        Node bH=null;
        Node bT=null;
        Node next = null;
        while (head!=null){
            next = head.next;
            head.next=null;
            if (head.value<pivot){
                if (sH == null){
                    sH=head;
                    sT=head;
                }else {
                    sT.next=head;
                    sT=head;
                }
            }
            else if (head.value==pivot){
                if (eH==null){
                    eH=head;
                    eT=head;
                }else {
                    eT.next=head;
                    eT=head;
                }
            }else {
                if (bH==null){
                    bH=head;
                    bT=head;
                }else {
                    bT.next=head;
                    bT = head;
                }
            }
            head = next;
        }
        if (sT !=null){
            sT.next =eH;
            eT = eT == null ? sT : eT;
        }
        if (eT !=null){
            eT.next = bH;
        }
        return sH != null ? sH : eH != null ? eH : bH;
    }
}
