package org.moi.algorithm.simple.palindrome;

/**
 * @program:
 * @description: leeCode 第9题 回文数 难度：easy
 * @author: moi
 * @create: 2020/11/29 15:05
 **/
public class palindromeInt {


    /**
     * 题目：判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
     *
     * 本题不需要使用到manacher算法
     */

    public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        String s = String.valueOf(x);
        char[] str = manacherString(s);
        int med = str.length/2;
        int i = 1;
        while(med-i>0&&med+i<str.length){
            if(str[med-i] == str[med+i]){
                i++;
            }else{
                break;
            }
        }
        if(med+i == str.length-1){
            return true;
        }
        return false;


    }

    public static char[] manacherString(String str){
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }


    public static void main(String[] args) {
        int i = 121;
        System.out.println(isPalindrome(i));
    }
}
