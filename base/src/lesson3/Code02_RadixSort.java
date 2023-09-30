package lesson3;

import java.util.Arrays;

public class Code02_RadixSort {

    public static void radixSort(int[] arr) {
        if (arr==null || arr.length<2){
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }

    public static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i],max);
        }
        int res = 0;
        //2565
        while (max != 0){
            max = max /10;
            res ++;
        }
        return  res;
    }

    public static void radixSort(int[] arr,int begin, int end, int digit) {
        int radix = 10;
        int index = 0;
        int j = 0;
        for (int i = 1; i <= digit; i++) {
            int[] buckets = new int[end-begin+1];
            int[] count = new int[radix];

            for ( j = 0; j < arr.length; j++) {
                //当前位 的值为 d ,count[d]++
                int d = getDigit(arr[j],i);
                count[d]++;
            }

            //前缀和 从基数1开始到9
            //当前位 的值为 d   count[d]表示数组中第i位的数字小于等于d 的数有几个
            for (index = 1; index < radix;index++){
                count[index] = count[index] + count[index-1];
            }

            //数组从右往左遍历 确定在桶内排的位置  count[d]--  数组中第i位的数字小于等于d的数  减一个
            for ( j = end; j >= begin; j-- ){
                int d = getDigit(arr[j],i);
                //错误： buckets[d] = arr[i];
                //不破坏原有的排序，得到相对有序得到序列
                buckets[count[d]-1] = arr[j];
                count[d]--;
            }
            for (index=begin,j=0; j<=end; index++,j++){
                arr[index] = buckets[j];
            }
        }
    }



    //数组第i位的数  ， 第 d(个/十/百) 位
    public static int getDigit(int x, int d) {
//        如 10^(3-1)  = 100
        //  45684 / 100 = 456       456 % 10 = 6
        // 当前数 d 位 上的值为多少
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
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

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100000;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            radixSort(arr1);
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
        radixSort(arr);
        printArray(arr);

    }
}
