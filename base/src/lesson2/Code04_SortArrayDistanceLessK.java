package lesson2;

import java.util.PriorityQueue;

public class Code04_SortArrayDistanceLessK {
    public void sortedArrDistanceLessK(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        // k = 3
        //1 2 3 4 5 6
        for (;index<Math.min(arr.length,k);index++){
            heap.add(arr[index]);
        }
        int i = 0;
        for (;index<arr.length;i++,index++){
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
    }
}
