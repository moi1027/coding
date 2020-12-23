package org.moi.algorithm.leecode.heap;

import java.util.*;

/**
 * @program:
 * @description: 692. 前K个高频单词 难度：medium
 * @author: moi
 * @create: 2020/12/23 23:02
 **/
public class TopKFrequent {

    /**
     * 题目：给一非空的单词列表，返回前 k 个出现次数最多的单词。
     *
     * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序
     */

    public static List<String> topKFrequent(String[] words, int k) {
        Map<Object,Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(int i = 0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
            set.add(words[i]);
        }
        List<String> list = new ArrayList<>();
        Object[] strings = set.toArray();

        Arrays.sort(strings, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return map.get(o1).equals(map.get(o2))?o1.toString().compareTo(o2.toString()):map.get(o2)-map.get(o1);

            }
        });
        for(int i = 0;i<k;i++){
            list.add((String)strings[i]);
        }
        return list;

    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        topKFrequent(words,2);
    }
}
