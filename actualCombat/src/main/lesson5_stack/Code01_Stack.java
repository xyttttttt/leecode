package main.lesson5_stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.function.Consumer;

/**
 * 给你一个包含若干星号 * 的字符串 s 。
 *
 * 在一步操作中，你可以：
 *
 * 选中 s 中的一个星号。
 * 移除星号 左侧 最近的那个 非星号 字符，并移除该星号自身。
 * 返回移除 所有 星号之后的字符串。
 *
 * 注意：
 *
 * 生成的输入保证总是可以执行题面中描述的操作。
 * 可以证明结果字符串是唯一的。
 *
 *
 * 示例 1：
 *
 * 输入：s = "leet**cod*e"
 * 输出："lecoe"
 * 解释：从左到右执行移除操作：
 * - 距离第 1 个星号最近的字符是 "leet**cod*e" 中的 't' ，s 变为 "lee*cod*e" 。
 * - 距离第 2 个星号最近的字符是 "lee*cod*e" 中的 'e' ，s 变为 "lecod*e" 。
 * - 距离第 3 个星号最近的字符是 "lecod*e" 中的 'd' ，s 变为 "lecoe" 。
 * 不存在其他星号，返回 "lecoe" 。
 * 示例 2：
 *
 * 输入：s = "erase*****"
 * 输出：""
 * 解释：整个字符串都会被移除，所以返回空字符串。
 * */
public class Code01_Stack {

    public String removeStars(String s) {
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < ch.length;i++){
            if(ch[i] == '*'){
                stack.pop();
                continue;
            }
            stack.push(ch[i]);
        }
        StringBuffer res = new StringBuffer();

        stack.forEach(new Consumer<Character>() {
            @Override
            public void accept(Character character) {
                res.append(character);
            }
        });
        return res.toString();
    }

    //虚拟栈
    public String removeStars2(String s) {
        StringBuilder res = new StringBuilder();
        char[] c = new char[s.length()];
        int index = -1;  //指向栈顶元素
        //不能直接返回c
        for(char ch : s.toCharArray()){
            //数组元素覆盖  ，
            if(ch != '*'){
                c[++index] = ch;
            }else{
                //如果为 '*' 栈顶指针--
                index--;
            }
        }

        for(int i = 0;i <= index; i++){
            res.append(c[i]);
        }
        return res.toString();
    }


}
