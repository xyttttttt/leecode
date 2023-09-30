package lesson6;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Code02_DFS {

    public static void dfs(Node node) {
        if (node == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Set<Node> nodeSet = new HashSet<>();
        stack.push(node);
        nodeSet.add(node);
        System.out.println(node.value);

        while (!stack.isEmpty()){
            Node cur = stack.pop();
            for (Node next : cur.nexts){
                if (!nodeSet.contains(next)){
                    stack.push(cur);
                    stack.push(next);
                    System.out.println(next.value);
                    nodeSet.add(next);
                    break;
                }
            }
        }

    }
}
