package org.moi.algorithm.youzan;

import java.util.Scanner;

/**
 * @program:
 * @description:
 * @author: moi
 * @create: 2021/2/23 22:54
 **/
public class Test1 {

    public void fun(){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        scanner.close();
        line = line.substring(1,line.length()-1);
        String[] str = line.split(",");
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            nums[i] = Integer.valueOf(str[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(num+i<0||num-i>=nums.length){
                System.out.println(true);
                return;
            }
            for (int j = i+1; j < nums.length; j++) {
                num += nums[j];
                if(num-j>=nums.length||num+j<0){
                    System.out.println(true);
                    return;
                }
            }
        }
        System.out.println(false);
    }

    public static void main(String[] args) {
        new Test1().fun();
    }
}
