package lesson7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 贪心算法： 金条切割问题 给定一个数组 ，求出切割金条所需最小代价
 *
 * 解法思路：哈夫曼编码   （反过来切割）
 *          将数组中的元素加入小根堆  每次弹出两个栈顶元素并纳入结果中
 *          再将弹出两个元素之和加入堆
 *
 * */
public class Code03_LessMoneySplitGold {

    public static  int lessMoney(int[] arr){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int rest = 0;
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);

        }
        while (queue.size()>1){
            int cur = queue.poll()+queue.poll();
            rest+=cur;
            queue.add(cur);
        }
        return rest;
    }

    public static class maxHeapArr implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    }


    public static void main(String[] args) {
        // solution
        int[] arr = { 10,20,30};
        System.out.println(lessMoney(arr));

        int[] arrForHeap = { 3, 5, 2, 7, 0, 1, 6, 4 };
        System.out.println(lessMoney(arrForHeap));
    }
}
