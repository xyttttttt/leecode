package lesson6;

public class GraphGenerator {

    public static Graph createGraph(Integer[][] matrix) {  //matrix所有的边
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            Integer from = matrix[i][0];
            Integer to = matrix[i][1];
            Integer weight = matrix[i][2];
            if (!graph.nodes.containsKey(from)){
                graph.nodes.put(from,new Node(from));
            }
            if (!graph.nodes.containsKey(to)){
                graph.nodes.put(to,new Node(to));
            }
            Node nodeFrom = graph.nodes.get(from);
            Node nodeTo = graph.nodes.get(to);
            Edge newEdge = new Edge(weight,nodeFrom,nodeTo);
            nodeFrom.nexts.add(nodeTo);
            nodeFrom.out++;
            nodeTo.in++;
            nodeFrom.edges.add(newEdge);
            graph.edges.add(newEdge);
        }
        return graph;
    }
}
