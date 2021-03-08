package org.moi.algorithm.offer;

/**
 * @program:
 * @description: 剑指offer,替换字符串
 * @author: moi
 * @create: 2021/3/6 22:16
 **/
public class ReplaceSpace {

    /**
     * 题目：请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     */

    public String replaceSpace (String s) {
        // write code here
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)==' '){
                sb.append('%');
                sb.append('2');
                sb.append('0');
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
