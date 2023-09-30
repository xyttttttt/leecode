package lesson7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Code05_IPO {

    public static class Node{
        public int profits;
        public int capital;
        public Node(int profits, int capital) {
            this.profits = profits;
            this.capital = capital;
        }
    }
    public static class MaxProfitComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.profits-o1.profits;
        }
    }


    /**
     * costs[i]表示i号项目的花费
     * profits[i]表示i号项目在扣除花费之后还能挣到的钱(利润)
     * K表示你只能串行的最多做k个项目
     * W表示你初始的资金
     * */
    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        Node[] nodes = new Node[Profits.length];
        for (int i = 0; i < Profits.length; i++) {
            nodes[i] = new Node(Profits[i],Capital[i] );
        }
        String s = "123";







        }
    }
}
