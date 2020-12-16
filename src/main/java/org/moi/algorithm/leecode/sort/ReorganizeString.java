package org.moi.algorithm.leecode.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program:
 * @description: 重构字符串 leeCode 767 难度：medium
 * @author: moi
 * @create: 2020/12/16 21:25
 **/
public class ReorganizeString {

    /**
     * 题目：给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
     *
     * 若可行，输出任意可行的结果。若不可行，返回空字符串。
     */

    public static  String reorganizeString(String S) {
        int[] count = new int[26];
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<S.length();i++){
            count[S.charAt(i)-'a']++;
            max = Math.max(max,count[S.charAt(i)-'a']);
        }
        if(max>(S.length()+1)/2){
            return "";
        }
        //大根堆
        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return count[o2-'a']-count[o1-'a'];
            }
        });
        //将数据插入到大根堆里面
        for(Character a = 'a';a<='z';a++){
            if(count[a-'a']>0){
                queue.offer(a);
            }
        }
        StringBuilder sb = new StringBuilder("");
        while(queue.size()>1){
            Character a = queue.poll();
            Character b = queue.poll();
            sb.append(a);
            sb.append(b);
            if(--count[a-'a']>0){
                queue.offer(a);
            }
            if(--count[b-'a']>0){
                queue.offer(b);
            }
        }
        if(queue.size()>0){
            sb.append(queue.poll());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(reorganizeString(s));
    }
}
