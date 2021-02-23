package org.moi.algorithm.youzan;

import java.util.*;

/**
 * @program:
 * @description:
 * @author: moi
 * @create: 2021/2/23 23:05
 **/
public class Test3 {

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
        Arrays.sort(nums);
        System.out.println(nums[nums.length-4]);
    }

    public static void main(String[] args) {
        new Test3().fun();
    }
}
