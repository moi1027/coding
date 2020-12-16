package org.moi.algorithm.leecode.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program:
 * @description: �ع��ַ��� leeCode 767 �Ѷȣ�medium
 * @author: moi
 * @create: 2020/12/16 21:25
 **/
public class ReorganizeString {

    /**
     * ��Ŀ������һ���ַ���S������Ƿ��������Ų����е���ĸ��ʹ�������ڵ��ַ���ͬ��
     *
     * �����У����������еĽ�����������У����ؿ��ַ�����
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
        //�����
        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return count[o2-'a']-count[o1-'a'];
            }
        });
        //�����ݲ��뵽���������
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
