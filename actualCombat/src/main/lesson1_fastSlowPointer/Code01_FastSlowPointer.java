package main.lesson1_fastSlowPointer;
/**
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 *
 * 输入: nums = [0]
 * 输出: [0]
 * */


public class Code01_FastSlowPointer {
    public static void moveZeroes1(int[] nums) {
        int left = 0;       //指向最左边零的指针
        boolean flag =true;   //判断是否是第一次记录零所在的位置
        for(int index = 0; index<nums.length;index++){
            if(nums[index] == 0){  //当前值为零并且第一次记录零位置
                if(flag){
                    left = index;
                    flag = false;
                }
            }
            if(nums[index] != 0){  //当前位置不为零  和最左边的零交换
                swap(nums,left++,index);
            }
        }
    }
    public static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 方法二
     *
     * */
    public void moveZeroes2(int[] nums) {
        int index = 0;
        for(int i = 0; i<nums.length;i++){
            if(nums[i]!=0){
                nums[index++] = nums[i];
            }
        }
        for(int i = index;i<nums.length;i++){
            nums[i]= 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,2,1,3};
        moveZeroes1(arr);
    }
}
