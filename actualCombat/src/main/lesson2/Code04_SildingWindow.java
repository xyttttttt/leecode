package main.lesson2;

/**
 * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
 *
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 *
 * 如果不存在这样的子数组，请返回 0 。
 *
 *
 *
 * 提示 1：
 *
 * 输入：nums = [1,1,0,1]
 * 输出：3
 * 解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。
 * 示例 2：
 *
 * 输入：nums = [0,1,1,1,0,1,1,0,1]
 * 输出：5
 * 解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。
 * 示例 3：
 *
 * 输入：nums = [1,1,1]
 * 输出：2
 * 解释：你必须要删除一个元素。
 * */
public class Code04_SildingWindow {

    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];      //以i位置结尾的最长连续全1子数组
        int[] suf = new int[n];      //以i位置开头的最长连续全1子数组

        pre[0] = nums[0];
        for(int i=1;i<n;i++){
            pre[i] = nums[i] == 0 ? 0 : pre[i-1]+1;
        }
        suf[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--){
            suf[i] = nums[i] == 0 ? 0 : suf[i+1]+1;
        }
        int max = 0,preSum = 0,sufSum = 0;
        for(int i = 0;i<n ; i++){
            preSum = i == 0 ? 0 : pre[i-1];
            sufSum = i == n-1 ? 0 : suf[i+1];
            max = Math.max(max,preSum+sufSum);
        }
        return max;
    }

    public int longestSubarray2(int[] nums) {
        int res = 0;
        int p0 = 0, p1 =0;
        for(int num : nums){
            if(num == 0){
                p1 = p0;
                p0 = 0;
            }else{
                p1++;
                p0++;
            }
            res = Math.max(res,p1);
        }
        if(res == nums.length) --res;
        return res;
    }
}
