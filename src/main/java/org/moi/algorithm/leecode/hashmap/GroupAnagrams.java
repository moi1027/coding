package org.moi.algorithm.leecode.hashmap;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @program:
 * @description: 49. ��ĸ��λ�ʷ��� �Ѷȣ�medium
 * @author: moi
 * @create: 2021/1/10 22:19
 **/
public class GroupAnagrams {

    /**
     * ��Ŀ������һ���ַ������飬����ĸ��λ�������һ����ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ�����
     *
     * ʾ��:
     *
     * ����: ["eat", "tea", "tan", "ate", "nat", "bat"]
     * ���:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     *
     * ˼·����ÿ���ַ���hashֵ��ÿ���ַ�����hashֵ��Ⱦ�����ĸ��λ��
     */

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        int[] flag = new int[strs.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = 0;
        int[] flag1 = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        for(String s:strs){
            int num = 1;
            for (int i = 0; i < s.length(); i++) {
                //�ص��������hash�㷨�ı�д
                num+=flag1[s.charAt(i)-'a']*num&Integer.MAX_VALUE;
            }
            flag[n++] = num;
            map.put(num,1);
        }
        for (Integer entry:map.keySet()) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < flag.length; j++) {
                if(entry == flag[j]){
                    list.add(strs[j]);
                }
            }
            res.add(list);
        }
        return res;
    }



    public static void main(String[] args) {
        String[] strs = {"tho","vet"};
        new GroupAnagrams().groupAnagrams(strs);
    }
}
