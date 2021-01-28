package org.moi.algorithm.leecode.sort;

/**
 * @program:
 * @description: 58. 最后一个单词的长度 難度：easy
 * @author: moi
 * @create: 2021/1/28 21:57
 **/
public class LengthOfLastWord {

    /**
     * 題目：给定一个仅包含大小写字母和空格?' '?的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
     *
     * 如果不存在最后一个单词，请返回 0?。
     *
     * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
     *
     * ?
     *
     * 示例:
     *
     * 输入: "Hello World"
     * 输出: 5
     *
     */

    public int lengthOfLastWord(String s) {
        s = s.trim();
        int len = s.length();
        if(len == 0){
            return 0;
        }
        int count = 0;
        for (int i = len-1; i >=0; i--) {
            if(s.charAt(i)>='a'&&s.charAt(i)<='z'){
                count++;
            }else if(s.charAt(i) == ' '){
                break;
            }else if(s.charAt(i)>='A'&&s.charAt(i)<='Z'){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "a ";
        System.out.println(new LengthOfLastWord().lengthOfLastWord(s));
    }
}
