package lesson5;

/**
 * 找到一个节点的后继结点
 * */
public class Code08_SuccessorNode {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getSuccessorNode(Node node) {
        if (node == null){
            return node;
        }
        Node parent = null;
        if (node.right != null){
            return geLeftMost(node.right);
        }else {
            parent = node.parent;
            while (parent!=null && parent.left!=node){
                node = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

    private static Node geLeftMost(Node node) {
        while (node.left!=null){
            node = node.left;
        }
        return node;
    }
}
