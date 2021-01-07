package org.moi.algorithm.leecode.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @program:
 * @description: 32. 最长有效括号 难度：hard
 * @author: moi
 * @create: 2021/1/7 23:23
 **/
public class LongestValidParentheses {

    /**
     * 题目：给你一个只包含 '('?和 ')'?的字符串，找出最长有效（格式正确且连续）括号子串的长度。
     *
     * ?
     *
     * 示例 1：
     *
     * 输入：s = "(()"
     * 输出：2
     * 解释：最长有效括号子串是 "()"
     * 示例 2：
     *
     * 输入：s = ")()())"
     * 输出：4
     * 解释：最长有效括号子串是 "()()"
     * 示例 3：
     *
     * 输入：s = ""
     * 输出：0
     *
     * 思路：用栈存括号的）
     */


    /**
     * 思路：用栈存（的下标，匹配的合法（）的下标记录下来，让这些下标在映射数组中的值为0（数组默认被1填充），最后统计连续0的的最大区间长度
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if(s.length()<=1){
            return 0;
        }

        int num = 0;
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        int[] flag = new int[s.length()];
        Arrays.fill(flag,1);
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                stack.add(i);
            }else if(s.charAt(i)==')' && !stack.isEmpty()){
                int n = stack.pop();
                flag[i] = 0;
                flag[n] = 0;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if(flag[i] == 0){
                num++;
            }else{
                max = Math.max(max,num);
                num = 0;
            }
        }
        max = Math.max(max,num);
        return max;
    }

    public static void main(String[] args) {
        new LongestValidParentheses().longestValidParentheses("()(()");
    }
}
