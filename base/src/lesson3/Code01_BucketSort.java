package lesson3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 桶排序
 * */
public class Code01_BucketSort {

    /**
     * 桶排序
     * */
    public static void bucketSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int n = nums.length;
        int min = nums[0], max = nums[0];

        for (int i = 0 ; i<nums.length;i++){
            min = Math.min(nums[i],min);
            max = Math.max(nums[i],max);
        }
        // 确定每个桶所装的数据的范围size 需要保证至少有一个桶，故而需要加个1
        int size = (max-min) /n +1;
        // 所需的桶的个数cnt 需要保证每个桶至少要能装1个数，故而需要加个1；
        int count = (max-min) / size +1;
        //List类型的数组： 第i个桶需要放入的数据
        List<Integer>[] buckets = new List[count];

        for (int i = 0; i<count;i++){
            buckets[i] = new ArrayList<>();
        }
        // (当前数-最小值) / 每个桶所装数据的范围  = 对应桶的下标
        for (int i = 0;i< n;i++){
            int index = (nums[i]-min) / size;
            buckets[index].add(nums[i]);
        }
        //每个桶内进行排序
        for (int i = 0 ; i<count ;i++){
            buckets[i].sort(null);
        }
        //将排好序的桶内的数据 依次 放入原数组
        int index = 0 ;
        for (int i =0;i<n;i++){
            for (int j = 0; j < buckets[i].size(); j++) {
                nums[index++] = buckets[i].get(j);
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {19, 27, 35, 43, 31, 22, 54, 66, 78};
        bucketSort(nums);
        for (int num: nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 150;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            countSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        countSort(arr);
        printArray(arr);
    }

    /**
     * 计数排序
     * */
    public static void countSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i],max);
        }
        //{19, 27, 35, 43, 31, 22, 54, 66, 78}
        int buckets[] = new int[max+1];
        for (int i = 0; i<arr.length;i++){
            int m = arr[i];
            buckets[m] ++;
        }
        int index = 0;
        for (int i = 0 ;i<buckets.length;i++){
            while (buckets[i]-- > 0 ){
                arr[index++] = buckets[i];
            }
        }
    }



    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
