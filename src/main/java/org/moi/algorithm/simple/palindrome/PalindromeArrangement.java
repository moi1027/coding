package org.moi.algorithm.simple.palindrome;

import java.util.HashMap;
import java.util.Map;

/**
 * @program:
 * @description: leecode 回文排列 难度：easy
 * @author: moi
 * @create: 2020/11/29 15:16
 **/
public class PalindromeArrangement {

    /**
     * 题目：给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
     *
     * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
     *
     * 回文串不一定是字典当中的单词。
     *
     * 思路：要构成回文字符，如果给定的字符串的总数为奇数，则只能有一个奇数项的字符
     *      如果给定的总数为偶数，则不能存在奇数项的字符
     */


    public static boolean canPermutePalindrome(String s) {
        if(s == null || s.length() == 0){
            return false;
        }
        int len = s.length();
        char[] str = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<len;i++){
            int n = map.getOrDefault(str[i],0);
            map.put(str[i],n+1);
        }
        int count = 0;

        for (Map.Entry<Character,Integer> entry : map.entrySet()) {
            if(entry.getValue()%2 != 0){
                count++;
            }
            if(entry.getValue() == str.length){
                return true;
            }
        }
        if(len%2 == 0){
            if(count == 0) {
                return true;
            }else{
                return false;
            }
        }else {
            if(count == 1){
                return true;
            }else{
                return false;
            }
        }
    }

    public static void main(String[] args) {
        String s = "aabbccc";
        System.out.println(canPermutePalindrome(s));
    }

}
