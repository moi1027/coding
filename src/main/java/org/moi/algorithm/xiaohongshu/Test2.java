package org.moi.algorithm.xiaohongshu;

import java.util.Scanner;

/**
 * @program:
 * @description:
 * @author: moi
 * @create: 2021/2/24 0:19
 **/
public class Test2 {

    public void fun(){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String line = scanner.nextLine();
        scanner.close();
        String[] str = line.split(" ");
        int[] nums = new int[num];
        for (int i = 0; i < num; i++) {
            nums[i] = Integer.valueOf(str[0]);
        }
    }
}
