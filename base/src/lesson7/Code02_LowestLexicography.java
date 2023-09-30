package lesson7;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 贪心算法  最小字典序
 * */
public class Code02_LowestLexicography {

    public static String  lowest(String str){



        char[] chars = str.toCharArray();
        String rest = "";
        int start = 0;
        int end = chars.length-1;
        while (start<=end){
            boolean flag= false;
            //从chars中最左边往右比较 加上索引值不越界
            for (int i = 0; i + start <= end; i++) {
                if (chars[i+start] < chars[end-i]){
                    flag = true;
                    break;
                } else if (chars[i+start] > chars[end-i]) {
                    flag = false;
                    break;
                }
            }
            if (flag)  rest += chars[start++];
            if (!flag)  rest += chars[end--];
        }
        return rest;
    }

    public static void main(String[] args) {
        String str = "adcghadb";
        System.out.println(lowest(str));
    }



}
