package org.moi.algorithm.leecode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @program:
 * @description: leeCode 第三题（滑动窗口解决）
 * @author: moi
 * @create: 2020/11/17 22:23
 **/
public class LongerNotRepeatChar {

    /**
     *给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     */
    public static int lengthOfLongestSubstring(String s) {
        String[] arr = s.split("");
        int len = arr.length;
        if("".equals(s)){
            return 0;
        }else if(" ".equals(s)){
            return 1;
        }
        MyQueue1 myQueue1 = new MyQueue1();
        for(int i = 0;i<len;i++){
            myQueue1.push(arr[i]);
        }
        return myQueue1.getMax();
    }

    public static void main(String[] args) {
        String s = "";
        lengthOfLongestSubstring(s);
    }

}


/**
 * 队列 保证队列里的每个字符都是独一无二的，并且记录队列中曾经最大的长度
 */
class MyQueue1{

    private LinkedList<String> list = new LinkedList<String>();

    private Set<String> set = new HashSet<String>();

    private int count = 0;
    private int max = 0;

    public void push(String value){
        if(list.size() == 0){
            list.push(value);
            set.add(value);
            count++;
            max++;
        }else{
            if(set.contains(value)){
                while(!value.equals(list.getLast())) {
                    set.remove(list.getLast());
                    list.pollLast();
                    count--;
                }
                set.remove(list.getLast());
                list.pollLast();
                count--;
                list.push(value);
                set.add(value);
                count++;
            }else{
                list.push(value);
                set.add(value);
                count++;
            }
            if(count > max){
                max = count;
            }
        }
    }

    public int getMax(){
        return max;
    }

}