package lesson4;

public class Code07_FindFirstIntersectNode {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 ==null || head2 ==null){
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        //两个链表都无环
        if (loop1 == null && loop2 ==null){
            noLoop(head1,head2);
        }
        //两个链表都有环
        else if (loop1 !=null && loop2 != null){
            bothLoop(head1,loop1,head2,loop2);
        }
        //一个链表有环 ，一个无环 一定无相交节点
        return null;
    }

    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        //使用快慢指针
        Node fast = head.next.next;
        Node slow = head.next;
        //快指针一次走两步，慢指针一次走一步 ，如果链表有环 快慢指针一定会相遇
        while (slow!=fast){
            //两个链表无环 返回null
            if (fast.next == null || fast.next.next==null){
                return null;
            }
            slow =slow.next;
            fast = fast.next.next;
        }
        //两指针相遇后 快指针回到头节点 快慢指针都一次走一步，相遇的地方就是链表的入环节点
        fast = head;
        while (fast != slow){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    //两个链表无环的情况
    public static Node noLoop(Node head1, Node head2) {
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        //遍历两个链表的长度
        while (cur1.next!=null){
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next!=null){
            n--;
            cur2 = cur2.next;
        }
        //如果尾节点不相同则两个链表一定不相交  否则 两个链表一定有相交节点
        if (cur1 != cur2){
            return null;
        }
        //区分哪个链表长度长
        cur1 = n>=0 ? head1 : head2 ;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        //较长的链表先走两个链表的插值
        while (n > 0){
            cur1 = cur1.next;
        }
        //两个链表相交则停止 返回相遇节点
        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = head1;
        Node cur2 = head2;
        //两个链表入环节点相同 则将入环节点作为尾节点 重复两个链表无环且相交的情况
        if (loop1 == loop2){
            int n = 0;
            //遍历两个链表的长度
            while (cur1!=loop1){
                n++;
                cur1 = cur1.next;
            }
            while (cur2!=loop2){
                n--;
                cur2 = cur2.next;
            }
            //区分哪个链表长度长
            cur1 = n>=0 ? head1 : head2 ;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            //较长的链表先走两个链表的插值
            while (n > 0 ){
                n--;
                cur1 = cur1.next;
            }
            //两个链表相交则停止 返回相遇节点
            while (cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }
        else {
            //如果有环 且两个链表第一次入环节点不相等
            cur1 = loop1.next;
            //一个链表在环上转一圈  如果两个环相交 则 返回第一个链表的入环节点
            while (cur1 != loop1){
                if (cur1 == loop2){
                    //一旦相等 则两个链表的环是一样的 返回哪个环上的节点都可以 这里选择第一个链表的入环节点
                    return loop1;
                }
                cur1 = cur1.next;
            }
            //否则两个环不相交
            return null;
        }
    }
}
