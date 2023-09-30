package lesson6;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int value;                    //点上的值
    public int in;		                 //入度
    public int out;		                 //出度
    public ArrayList<Node> nexts;     //当前点出发 由他发散出去的边 连接的点
    public ArrayList<Edge> edges;    //当前点所拥有的边

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
