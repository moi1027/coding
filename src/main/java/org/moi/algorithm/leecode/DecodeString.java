package org.moi.algorithm.leecode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @program:
 * @description: 394. 字符串解码 难度：medium
 * @author: moi
 * @create: 2021/2/1 10:29
 **/
public class DecodeString {


    /**
     * 题目：给定一个经过编码的字符串，返回它解码后的字符串。
     *
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     *
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     *
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像?3a?或?2[4]?的输入。
     *
     * ?
     *
     * 示例 1：
     *
     * 输入：s = "3[a]2[bc]"
     * 输出："aaabcbc"
     * 示例 2：
     *
     * 输入：s = "3[a2[c]]"
     * 输出："accaccacc"
     *
     *
     */

    public String decodeString(String s) {
        StringBuffer sb = new StringBuffer();
        Stack<Integer> mulitStack = new Stack<>();
        Stack<StringBuffer> stringBufferStack = new Stack<>();
        int num = 0;
        for(Character c:s.toCharArray()){
            if(Character.isDigit(c)){
                //获取前面的数字，不管是几位数
                num = num*10+c-'0';
            }else if(c == '['){
                stringBufferStack.add(sb);
                mulitStack.add(num);
                num = 0;
                sb = new StringBuffer();
            }else if(Character.isAlphabetic(c)){
                sb.append(c);
            }else{
                StringBuffer tmp = stringBufferStack.pop();
                Integer tmpNum = mulitStack.pop();
                for (int i = 0; i < tmpNum; i++) {
                    tmp.append(sb);
                }
                sb = tmp;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "100[leetcode]";
        System.out.println(new DecodeString().decodeString(s));
    }
}
