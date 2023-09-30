package main.lesson1_fastSlowPointer;

/**
 * 盛水最多的容器
 *
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 *
 * 示例 1：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 * */
public class Code03_FastSlowPointer {
    public int maxArea(int[] height) {
        if(height.length == 1){
            return height[0];
        }
        int left = 0;
        int right = height.length-1;
        int max = 0;
        //水占的长度         水的最大高度
        int l = right -left, h = 0;
        while(left < right){
            //两者最小值为水的高度
            h = Math.min(height[left] , height[right]);
            max = Math.max(max,l*h);
            //长度小的一方指针变动   （保证面积最大）
            if(h == height[left]){
                left++;
            }else {
                right--;
            }
            l--;
        }
        return max;
    }

}
