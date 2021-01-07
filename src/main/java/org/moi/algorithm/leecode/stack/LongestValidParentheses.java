package org.moi.algorithm.leecode.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @program:
 * @description: 32. ���Ч���� �Ѷȣ�hard
 * @author: moi
 * @create: 2021/1/7 23:23
 **/
public class LongestValidParentheses {

    /**
     * ��Ŀ������һ��ֻ���� '('?�� ')'?���ַ������ҳ����Ч����ʽ��ȷ�������������Ӵ��ĳ��ȡ�
     *
     * ?
     *
     * ʾ�� 1��
     *
     * ���룺s = "(()"
     * �����2
     * ���ͣ����Ч�����Ӵ��� "()"
     * ʾ�� 2��
     *
     * ���룺s = ")()())"
     * �����4
     * ���ͣ����Ч�����Ӵ��� "()()"
     * ʾ�� 3��
     *
     * ���룺s = ""
     * �����0
     *
     * ˼·����ջ�����ŵģ�
     */


    /**
     * ˼·����ջ�棨���±꣬ƥ��ĺϷ��������±��¼����������Щ�±���ӳ�������е�ֵΪ0������Ĭ�ϱ�1��䣩�����ͳ������0�ĵ�������䳤��
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
