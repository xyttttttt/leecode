package lesson2;

/**
 *
 * 荷兰国旗问题（三分）
 * */

public class Code05_NetherlandsFlag {

    public static int[] partition(int[] arr, int num) {
        int left = -1;
        int right = arr.length;
        int i = 0;
        //当  当前数位置 小于 大于区域左边界时成立
        while (i < right){
            if (arr[i]< num){
                swap(arr,i,left+1);
                i++;
                left++;
            }
            //和大于区域地左边界前一个数交换   当前位置不改变 因为交换过来的数还没有进行比较
            else if (arr[i] > num){
                swap(arr,i,right-1);
                right--;
            }
            //当前数和num相等
            else{
                i++;
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,1,2,3,2,1,2,3,2,1,2,2};

        int[] partition = partition(arr, 2);
        for (int m : partition) {
            System.out.println(m);
        }
    }


}
