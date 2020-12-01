package org.moi.algorithm.leecode.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program:
 * @description: leeCode 把数组排成最小的数
 * @author: moi
 * @create: 2020/12/1 21:55
 **/
public class MakeArraySmall {


    /**
     * 题目：输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     */
    public static String minNumber(int[] nums) {
        String[] nums2 = new String[nums.length];
        for (int i = 0;i < nums.length;i++){
            nums2[i] = String.valueOf(nums[i]);
        }
        //用到了比较器来排序
        Arrays.sort(nums2,new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return compareTwoNums(o1,o2);
            }
        });
        StringBuilder res = new StringBuilder();
        for (int i = 0;i < nums2.length;i++){
            res.append(nums2[i]);
        }
        return res.toString();
    }
    private static int compareTwoNums(String a, String b){
        if (a.length() == b.length()){
            //如果两个字符串的长度一样，则按字典序排序
            return a.compareTo(b);
        }else{
            //两个字符串长度不一样
            int i = 0;
            int minLen = Math.min(a.length(),b.length());
            while (i < minLen){
                //排相同位的字符
                if (a.charAt(i) != b.charAt(i)){
                    return a.charAt(i) > b.charAt(i) ? 1 : -1;
                }
                i++;
            }
            //两个字符串位数不一样，要对高位也进行排序
            return a.length() > b.length() ? (compareTwoNums(a.substring(i),b)) : (compareTwoNums(a,b.substring(i)));
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,30,34,5,9};
        System.out.println(minNumber(arr));
    }
}
