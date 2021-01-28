package org.moi.algorithm.leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program:
 * @description: 66. 加一 難度：easy
 * @author: moi
 * @create: 2021/1/28 22:06
 **/
public class PlusOne {

    /**
     * 題目：给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     *
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     *
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * ?
     *
     * 示例?1：
     *
     * 输入：digits = [1,2,3]
     * 输出：[1,2,4]
     * 解释：输入数组表示数字 123。
     *
     */

    public int[] plusOne(int[] digits) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < digits.length; i++) {
            stack.add(digits[i]);
        }
        List<Integer> list = new ArrayList<>();
        int flag = 0;
        if(stack.peek()+1>9){
            stack.pop();
            if(stack.isEmpty()){
                list.add(0);
                list.add(1);
            }else {
                list.add(0);
            }
            flag = 1;
        }else{
            list.add(stack.pop()+1);
        }
        while(!stack.isEmpty()){
            if(stack.peek()+flag>9){
                flag = 1;
                stack.pop();
                if(stack.isEmpty()){
                    list.add(0);
                    list.add(1);
                }else {
                    list.add(0);
                }
            }else{
                list.add(stack.pop()+flag);
                flag = 0;
            }
        }
        int[] res = new int[list.size()];
        int l = res.length;
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(l-1-i);
        }
        return res;

    }

    public static void main(String[] args) {
        int[] arr = {9,8,9};
        new PlusOne().plusOne(arr);
    }
}
