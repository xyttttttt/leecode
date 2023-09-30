package lesson5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Code03_TreeMaxWidth {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public void widthTraversal(Node head){
        if (head !=null){
            LinkedList<Node> nodes = new LinkedList<>();
            nodes.add(head);
            while (head!=null ||!nodes.isEmpty()){
                head = nodes.pop();
                System.out.println(head.value+" ");
                if (head.left!=null){
                    nodes.add(head.left);
                }
                if (head.right!=null){
                    nodes.add(head.right);
                }
            }
        }
    }

    public static int getMaxWidth(Node head) {
        if (head == null) {
            return 0;
        }
        int maxWidth = 0;
        int curLevel = 0;
        int curWidth = 0;
        LinkedList<Node> nodes = new LinkedList<>();
        //当前节点所对应的高度
        Map<Node,Integer> levelMap = new HashMap<>();
        nodes.add(head);
        levelMap.put(head,1);
        Node curNode = null;
        while (!nodes.isEmpty()){
            curNode = nodes.poll();
            if (curNode.left!=null){
                nodes.add(curNode.left);
                levelMap.put(curNode.left,levelMap.get(curNode)+1);
            }
            if (curNode.right!=null){
                nodes.add(curNode.right);
                levelMap.put(curNode.right,levelMap.get(curNode)+1);
            }
            if (levelMap.get(curNode) == curLevel){
                curWidth++;
            }else {
                maxWidth = Math.max(maxWidth,curWidth);
                curWidth = 1;
                curLevel = levelMap.get(curNode);
            }

        }
        return maxWidth;
    }
}
