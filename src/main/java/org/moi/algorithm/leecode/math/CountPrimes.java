package org.moi.algorithm.leecode.math;

/**
 * @program:
 * @description: leecode 计数质数 难度：easy
 * @author: moi
 * @create: 2020/12/3 9:40
 **/
public class CountPrimes {


    /**
     * 统计所有小于非负整数 n 的质数的数量。
     */
    public static int countPrimes(int n) {
        if(n<=1){
            return 0;
        }
        int count = 0;
        for(int i = 2;i<n;i++){
            boolean falg = true;
            for(int j = 2;j<=(int)Math.sqrt(i);j++){
                if(i%j == 0){
                    falg = false;
                    break;
                }
            }
            if(falg){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(countPrimes(n));
    }
}
