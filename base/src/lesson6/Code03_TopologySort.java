package lesson6;

import java.util.*;

public class Code03_TopologySort {

    public static List<Node> sortedTopology(Graph graph) {
        Map<Node,Integer>  inMap = new HashMap<>();
        Queue<Node>  zeroInQueue = new LinkedList<>();

        for (Node curNode : graph.nodes.values()){
            inMap.put(curNode, curNode.in);
            if (curNode.in == 0){
                zeroInQueue.add(curNode);
            }
        }
        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()){
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for (Node next : cur.nexts){
                inMap.put(next,inMap.get(next)-1);
                if (next.in == 0){
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }
}
