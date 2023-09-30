package lesson1;

/**
 * 局部最小值
 * 数组第一个数 小于 数组第二个数    则返回 0；
 * 数组最后一个数 小于 数组倒数第二个数    则返回 arr.length-1；
 * 在中间  局部最小值必须满足 左右两边的数都大于自己
 * */
public class Code09_FindOneLessValueIndex {
    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length ==0){
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]){
            return 0;
        }
        if (arr[arr.length-1] < arr[arr.length-2]){
            return arr.length-1;
        }
        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        //[5,2,3,5,6,8,7,9,4,3,8]
        while (left<right){
            mid = left + ((right-left) >> 1);
            if (arr[mid+1] < arr[mid]){
                left = mid +1;
            }
            if (arr[mid] > arr[mid-1]){
                right = mid - 1;
            }
            if (arr[mid] <= arr[mid-1] && arr[mid] <=arr[mid+1]){
                return mid;
            }
        }
        return left;
    }
}
