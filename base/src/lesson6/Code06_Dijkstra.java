package lesson6;

import java.security.interfaces.ECKey;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Code06_Dijkstra {

    public static HashMap<Node, Integer> dijkstra1(Node head) {
        //从head触发到所有点的最小距离
        //key：从head出发到达的key
        //value：从head出发到达key的最小距离
        //如果没有T记录，从head出发到T这个点的距离为正无穷
        //当前节点到源节点的最短距离
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        //已经求过距离的点，存在selectedNodes在，以后再也不碰
        HashSet<Node> selectNodeSet = new HashSet<>();

        distanceMap.put(head , 0);

        Node minNode = getMinDistanceAndUnselectedNode(distanceMap,selectNodeSet);

        while (minNode != null){
            int distance = distanceMap.get(minNode);
            for (Edge edge: minNode.edges){
                Node toNode = edge.to;
                if (!distanceMap.containsKey(toNode)){
                    distanceMap.put(toNode,distance+edge.weight);
                }else {
                    distanceMap.put(toNode,Math.min(distanceMap.get(toNode),distance+edge.weight));
                }
            }
            selectNodeSet.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap,selectNodeSet);
        }
        return distanceMap;
    }

    public static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap,
                                                       HashSet<Node> touchedNodes) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if (!touchedNodes.contains(node) && distance<minDistance){
                minDistance = distance;
                minNode = node;
            }
        }
        return minNode;
    }


    

}
