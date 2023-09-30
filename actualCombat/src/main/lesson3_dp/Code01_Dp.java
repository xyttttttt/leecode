package main.lesson3_dp;

/**
 * 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 *
 * 示例 1：
 * 输入：m = 3, n = 7
 * 输出：28
 * 示例 2：
 * */
public class Code01_Dp {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        dp[0][0] = 0;
        for(int i = 0;i<n;i++){
            dp[i][0] = 1;
        }
        for(int j = 0;j<m;j++){
            dp[0][j] = 1;
        }
        for(int i = 1;i<n;i++){
            for(int j = 1; j<m;j++){
                dp[i][j] = dp[i][j-1] +dp[i-1][j];
            }
        }
        return dp[n-1][m-1];
    }
}
