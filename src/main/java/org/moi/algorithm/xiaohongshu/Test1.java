package org.moi.algorithm.xiaohongshu;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @program:
 * @description:
 * @author: moi
 * @create: 2021/2/24 0:00
 **/
public class Test1 {

    public void fun(){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        scanner.close();
        Queue queue = new LinkedList();
        int flag = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if(c=='('){
                flag++;
                continue;
            }


            if(flag==0){
                if(c=='<'){
                    sb.deleteCharAt(sb.length()-1);
                    continue;
                }
                sb.append(c);
                continue;
            }
            if(c==')'){
                flag--;
                continue;
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        new Test1().fun();
    }
}
