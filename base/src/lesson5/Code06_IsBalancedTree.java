package lesson5;

/**
 * 是否是平衡树
 * */
public class Code06_IsBalancedTree {

    public static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
        }
    }
    public static boolean isBalanced(Node head) {
        return process(head).isBalanced;
    }

    public static class ReturnType {
        public boolean isBalanced;
        public int height;

        public ReturnType(boolean isB, int hei) {
            isBalanced = isB;
            height = hei;
        }
    }
    public static ReturnType process(Node x) {
        if (x == null){
            return new ReturnType(true,0);
        }
        ReturnType leftData = process(x.left);
        ReturnType rightData = process(x.right);
        int height = Math.max(leftData.height,rightData.height)+1;
        //三个条件不满足其中之一返回false
        //左树是平衡树  右树是平衡树  左右两树高度差不超过二
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced
                            &&(Math.abs(leftData.height-rightData.height)<2);
        return new ReturnType(isBalanced,height);
    }
}
