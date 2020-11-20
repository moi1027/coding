package org.moi.algorithm.leecode.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @program:
 * @description: leeCode 第20题 有效的括号 快手出现过此题！！！ 难度 ：easy
 * @author: moi
 * @create: 2020/11/19 21:34
 **/
public class ValidParentheses {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     */

    public static boolean isValid(String s) {
        int len = s.length();
        //如果字符串不是偶数的长度则必然闭合不了
        if(len % 2 != 0){
            return false;
        }
        Map<Character,Character> map =new HashMap<Character, Character>(){{
            put(')','(');
            put(']','[');
            put('}','{');
        }};
        //采用栈的解决方式 对比成功之后直接出栈 要保证括号的顺序
        Deque<Character> stack = new LinkedList<Character>();
        for(int i = 0;i<len;i++){
            Character a = s.charAt(i);
            if(map.containsKey(a)){
                if(stack.isEmpty() || !stack.peek().equals(map.get(a))){
                    return false;
                }
                stack.pop();
            }else{
                stack.push(a);
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
}
