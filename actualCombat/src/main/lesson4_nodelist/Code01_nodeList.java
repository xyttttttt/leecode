package main.lesson4_nodelist;


/**
 * 奇偶链表
 *
 * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
 * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
 * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
 * 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
 *
 * 示例 1:
 * 输入: head = [1,2,3,4,5]
 * 输出: [1,3,5,2,4]
 *
 * 示例 2:
 * 输入: head = [2,1,3,5,6,4,7]
 * 输出: [2,3,6,7,1,5,4]
 * */
public class Code01_nodeList {

      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public ListNode oddEvenList(ListNode head) {
        ListNode evenNode = head.next;
        if(evenNode == null){
            return head;
        }
        ListNode aCur = head;
        ListNode eCur = evenNode;
        int i = 1;
        ListNode cur = evenNode.next;
        while(cur != null){
            if(i % 2 != 0){
                aCur.next = cur;
                aCur = aCur.next;
            }else {
                eCur.next = cur;
                eCur = eCur.next;
            }
            i++;
            cur = cur.next;
        }
        while(evenNode != null){
            aCur.next = evenNode;
            evenNode = evenNode.next;
        }
        return head;
    }




    public ListNode oddEvenList2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode e = evenNode;  //偶尾结点
        while(oddNode.next != null && e.next!=null){
            oddNode.next = e.next;
            oddNode = oddNode.next;
            e.next = oddNode.next;
            e = e.next;
        }
        oddNode.next = evenNode;
        return head;
    }
}
