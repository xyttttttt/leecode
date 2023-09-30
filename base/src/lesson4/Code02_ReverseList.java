package lesson4;


/**
 * 反转单项列表
 * 反转双向列表
 * */
public class Code02_ReverseList {
    /**
     * 定义单向列表
     * */
    public static class Node {
        public int value;
        public Node next;
        public Node pre;
        public Node(int value) {
            this.value = value;
        }
    }
    /**
     * 反转单向列表
     * */
    public static Node reverseList(Node head) {
        Node pre =null;
        Node next = null;
        while (head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    /**
     * 定义双向列表
     * */
    public static class DoubleNode {
        public int value;
        public DoubleNode pre;
        public DoubleNode next;
        public DoubleNode(int value) {
            this.value = value;
        }
    }

    public static DoubleNode reverseList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next =null;
        while (head!=null){
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }


    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void printDoubleLinkedList(DoubleNode head) {
        System.out.print("Double Linked List: ");
        DoubleNode end = null;
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.next;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.pre;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        printLinkedList(head1);
        head1 = reverseList(head1);
        printLinkedList(head1);

        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.pre = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.pre = head2.next;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.pre = head2.next.next;
        printDoubleLinkedList(head2);
        printDoubleLinkedList(reverseList(head2));

    }
}
