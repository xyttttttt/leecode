package main.lesson1_fastSlowPointer;
/**
 * 判断子序列
 *
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 进阶：
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * 示例 1：
 *
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 * */
public class Code02_FastSlowPointer {
    public boolean isSubsequence(String s, String t) {
        if(s.isEmpty()){
            return true;
        }
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        if(chars.length<1 || chart.length <1){
            return false;
        }
        int indext = 0;
        int indexs = 0;
        boolean flag = false;
        //长字符串遍历
        while(indext<chart.length){
            //两个字符相等 指针都加一
            if(chart[indext] == chars[indexs]){
                indexs++;
                indext++;
            }
            //两个指针不相等 长指针加一
            else if(chart[indext] != chars[indexs]){
                indext++;
            }
            if(indexs == chars.length){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
