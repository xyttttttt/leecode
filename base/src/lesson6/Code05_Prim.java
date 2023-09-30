package lesson6;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Code05_Prim {
    public static class EdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight-o2.weight;
        }
    }
    public static Set<Edge> primMST(Graph graph) {
        //声明小根堆
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        //to 遍历过的点
        HashSet<Node> set = new HashSet<>();

        Set<Edge>  result = new HashSet<>();//依次挑选的边放入result

        for (Node node : graph.nodes.values()){   //处理森林问题  （ 图不连通 ）
            if (!set.contains(node)){       //没有遍历过当前点
                set.add(node);
                for (Edge edge:node.edges){        //解锁当前点的所有边进入小根堆
                    priorityQueue.add(edge);
                }
                while (!priorityQueue.isEmpty()){
                    Edge edge = priorityQueue.poll();   //弹出一个权值最小的边
                    Node toNode = edge.to;          //获取弹出边的to点
                    if (!set.contains(toNode)){     //如果没有遍历过toNode
                        result.add(edge);           //要这条边
                        set.add(toNode);
                        for (Edge nextEdge: toNode.edges){  //解锁toNode拥有的所有边
                            priorityQueue.add(nextEdge);
                        }
                    }
                }
            }
        }
        return result;
    }

}
