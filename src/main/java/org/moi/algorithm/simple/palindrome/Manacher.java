package org.moi.algorithm.simple.palindrome;

/**
 * @program:
 * @description: 解决回文问题  大多数都可以套用这个算法
 * @author: moi
 * @create: 2020/11/29 14:10
 **/
public class Manacher {

    /**
     * 解法一: 暴力法 将给定的字符串给全部进行加工，在每个字符的中间都加上一个特定的字符，然后对每个字符进行发散查找，记下每个回文字符串的长度，最后比较所有的回文字符的长度 O(N^2)
     *
     *
     * 解法二：manacher算法，设置三个条件，1.一个回文半径数组parr[] 2.回文最右边界 R 3.回文的中心点
     *                     parr[]数组是存放所有的回文字符串的长度，如果只有一个的话则就为1，
     *                     R代表的是最长回文串的最右边界，回文半径等于R-中心点
     *                     C代表每个回文串的中心点
     *                     R 和 C 的初始值都为-1
     *O(N)
     */



    public static int manacherDetail(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        char[] str= manacherString(s);
        int[] parr = new int[str.length];
        int R = -1;
        int C = -1;
        int max = Integer.MIN_VALUE;
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
            //给max赋值为最大的回文半径
            max = Math.max(max, parr[i]);
        }
        //最后返回的数由于有特殊字符的加入，需要减去1
        return max - 1;
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
        String s = "12121hjsadasj12";
        System.out.println(manacherDetail(s));
    }
}
