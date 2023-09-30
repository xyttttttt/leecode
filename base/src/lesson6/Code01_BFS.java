package lesson6;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Code01_BFS {

    public static void bfs(Node node) {
        if (node == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        Set setNode = new HashSet();
        queue.add(node);
        setNode.add(node);
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next: cur.nexts){
                if (!setNode.contains(next)){
                    setNode.add(next);
                    queue.add(next);
                }
            }
        }
    }
}
