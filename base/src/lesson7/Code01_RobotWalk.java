package lesson7;

/**
 * 假设有排成一行的 N 个位置，记为 1~N，N 一定大于或等于 2。开始时机器人在其中的 M 位
 * 置上(M 一定是 1~N 中的一个)，机器人可以往左走或者往右走，如果机器人来到 1 位置， 那
 * 么下一步只能往右来到 2 位置;如果机器人来到 N 位置，那么下一步只能往左来到 N-1 位置。
 * 规定机器人必须走 K 步，最终能来到 P 位置(P 也一定是 1~N 中的一个)的方法有多少种。给
 * 定四个参数 N、M、K、P，返回方法数。
 * */


public class Code01_RobotWalk {

    public static int  walkWays1(int N, int M,int K,int P){
        if (K == 0){
            return  M == P ? 1 : 0 ;
        }
        if (M == 1){
            return walkWays1(N,M+1,K-1,P);
        } else if (M == N){
            return walkWays1(N,M-1,K-1,P);
        }
        return walkWays1(N, M-1, K-1, P) + walkWays1(N, M+1, K-1, P);
    }

    /**
     * 记忆化搜索
     * */
    //dp[i][j]  机器人i步走到j位置
    public static int  walkWays2(int N, int P, int M,int K){
        int[][] dp = new int[K+1][N+1];
        for (int i = 0; i <=K; i++) {
            for (int j = 0; j <= N; j++) {
                dp[i][j] = -1;
            }
        }
        return f2(N,P,K,M,dp);
    }

    public static int  f2(int N, int P, int rest,int cur,int[][] dp){
        if (dp[rest][cur] != -1){
            return dp[rest][cur];
        }
        if (rest == 0){
            dp[rest][cur] = cur == P ? 1 : 0;
            return dp[rest][cur];
        }
        if (cur == 1){
            dp[rest][cur] = f2(N,P,rest-1,cur+1,dp);
        } else if (cur ==  N){
            dp[rest][cur] = f2(N,P,rest-1,cur-1,dp);
        } else {
            dp[rest][cur] = f2(N,P,rest-1,cur+1,dp) +f2(N,P,rest-1,cur-1,dp);
        }
        return dp[rest][cur];
    }


    //严格表依赖结构的方法
    public static int  walkWays3(int N, int P, int M,int K){
        int[][] dp = new int[K+1][N+1];
        for (int i = 0; i <=N; i++) {
            dp[0][i] = i == P ? 1 : 0;
        }
        return f3(N,P,K,M,dp);
    }

    public static int  f3(int N, int P, int rest,int cur,int[][] dp){
        for (int i = 1; i <=rest ; i++) {
            for (int j = 1; j <= N ; j++) {
                if (j == 1){
                    dp[i][j] = dp[i-1][j+1];
                } else if (j == N) {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = dp[i-1][j+1]+ dp[i-1][j-1];
                }
            }
        }
        return dp[rest][cur];
    }









    public static void main(String[] args) {
        int result = walkWays1(5,2,3,3);
        int result2 = walkWays1(3,1,3,3);
        System.out.println(result);
        System.out.println(result2);
        int result3 = walkWays2(5,2,3,3);
        int result4 = walkWays2(3,1,3,3);
        System.out.println(result3);
        System.out.println(result4);
        int result5 = walkWays3(5,2,3,3);
        int result6 = walkWays3(3,1,3,3);
        System.out.println(result5);
        System.out.println(result6);
    }
}
