package org.moi.algorithm.offer;

/**
 * @program:
 * @description: 整数中1出现的次数
 * @author: moi
 * @create: 2021/3/14 23:29
 **/
public class NumberOf1Between1AndN {

    /**
     * 题目：剑指offer:求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
     */

    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1; i <=n; i++) {
            count+=fun(i);
        }
        return count;
    }

    public int fun(int n){
        String s = String.valueOf(n);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1'){
                res++;
            }
        }
        return res;
    }
}
