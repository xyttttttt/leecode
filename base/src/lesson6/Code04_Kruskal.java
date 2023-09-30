package lesson6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Code04_Kruskal {

    public static class MySets{
        //key  node
        //value  set集合：当前node集合所在的set集合
        public static HashMap<Node, List<Node>> setMap;

        public static void  MySet(List<Node> nodes){
            //初始：每个节点自己为一个集合
            for (Node cur: nodes){
                List<Node> set = new ArrayList<>();
                set.add(cur);
                setMap.put(cur,set);
            }
        }
        //判断两个节点是否是同一个集合
        public static boolean isSameSet(Node from,Node to){
            List<Node> fromNode = setMap.get(from);
            List<Node> toNode = setMap.get(to);
            return fromNode == toNode;
        }
        //将两个集合合并
        public void union(Node from , Node to){
            List<Node> fromNode = setMap.get(from);
            List<Node> toNode = setMap.get(to);
            for (Node curToNode : toNode){
                fromNode.add(curToNode);
            }
            for (Node curToNode : toNode){
                setMap.put(curToNode,fromNode);
            }
        }
    }
}
