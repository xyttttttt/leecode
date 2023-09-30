package lesson7;

/**
 *  给定数组 arr，arr 中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值
 * 的货币可以使用任意张，再给定一个整数 aim，代表要找的钱数，求组成 aim 的最少货币
 * 数
 * */
public class Code02_LessMoneyCount {


    public static int moneyCount(int[] arr , int aim,int index ,int rest){
        if (index == arr.length){
            return  rest == 0 ? 1 : 0;
        }
        if (rest == 0){
            return 1;
        }
        int min = Integer.MAX_VALUE;
        //0张
        for (int zhang = 0; zhang * arr[index] <= rest ; zhang++) {
            min =  Math.min(moneyCount(arr,aim,index,rest-arr[index]*zhang)
                            ,moneyCount(arr,aim,index+1,rest));
        }
        return  min;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{5,2,3};
        int aim = 20;
        System.out.println(moneyCount(arr, aim, 0, aim));
    }
}
