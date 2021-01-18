package org.moi.algorithm.simple.palindrome;

/**
 * @program:
 * @description: 5. 最长回文子串 难度：medium
 * @author: moi
 * @create: 2021/1/18 22:02
 **/
public class LongestPalindrome {

    /**
     * 题目：给你一个字符串 s，找到 s 中最长的回文子串。
     *
     * ?
     *
     * 示例 1：
     *
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     *
     *
     */

    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        char[] str= manacherString(s);
        int[] parr = new int[str.length];
        //回文数组的右边界
        int R = -1;
        //回文数组的中心点
        int C = -1;
        int max = Integer.MIN_VALUE;
        int num = Integer.MIN_VALUE;
        for(int i = 0;i<str.length;i++){
            //每个parr[]中的元素初始化都为1，如果当i点处于目前最大回文字符串的右边界R内部时，则取以最大回文字符串的中心点C找他在parr数组的对称点
            //如果改对称点的回文区域范围已经有在最大回文字符串的区域范围外面时，就取二者的最小值
            parr[i] = R>i ?Math.min(parr[2*C-i],R-i):1;
            //在每个parr元素已有的范围内去判断以外的范围是否还能不能构成回文串，如果可以，则回文半径要加1，不行则跳出循环
            while (i + parr[i] < str.length && i - parr[i] > -1) {
                if (str[i + parr[i]] == str[i - parr[i]]) {
                    parr[i]++;
                }else {
                    break;
                }
            }
            //如果出现更大的回文字符串的时候，移动最右边界，并且将中心点改变
            if (i + parr[i] > R) {
                R = i + parr[i];
                C = i;
            }
            //找到最大回文字符串的起始下标
            num = max>parr[i]?num:i-parr[i]+1;
            //给max赋值为最大的回文半径
            max = Math.max(max, parr[i]);

        }
        StringBuffer sb = new StringBuffer();
        for (int i = num; i < num+(max-1)*2; i++) {
            if(str[i]!='#'){
                sb.append(str[i]);
            }
        }
        //最后返回的数由于有特殊字符的加入，需要减去1
        return sb.toString();
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
        String s = "cbbd";
        new LongestPalindrome().longestPalindrome(s);
    }
}
