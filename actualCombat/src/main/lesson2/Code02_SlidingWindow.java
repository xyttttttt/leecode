package main.lesson2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 定长字符串中元音字母的最大个数
 * 给你字符串 s 和整数 k 。
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 * 英文中的 元音字母 为（a, e, i, o, u）。

 * 示例 1：
 *
 * 输入：s = "abciiidef", k = 3
 * 输出：3
 * 解释：子字符串 "iii" 包含 3 个元音字母。
 * 示例 2：
 *
 * 输入：s = "aeiou", k = 2
 * 输出：2
 * 解释：任意长度为 2 的子字符串都包含 2 个元音字母。
 * 示例 3：
 *
 * */
public class Code02_SlidingWindow {
    public int maxVowels(String s, int k) {
        Set<Character> stringSet = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        int res = 0;
        char[] chars = s.toCharArray();
        for(int i=0;i<k;i++){
            if (i>=s.length()) return res;
            if(stringSet.contains(chars[i])){
                res++;
            }
        }

        int max = res;
        for(int i = k;i<s.length();i++){
            if(stringSet.contains(chars[i])){
                res++;
            }
            if(stringSet.contains(chars[i-k])){
                res--;
            }
            max = Math.max(res,max);
        }
        return max;
    }
}
