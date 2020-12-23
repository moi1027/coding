package org.moi.algorithm.leecode.heap;

import java.util.*;

/**
 * @program:
 * @description: 692. ǰK����Ƶ���� �Ѷȣ�medium
 * @author: moi
 * @create: 2020/12/23 23:02
 **/
public class TopKFrequent {

    /**
     * ��Ŀ����һ�ǿյĵ����б�����ǰ k �����ִ������ĵ��ʡ�
     *
     * ���صĴ�Ӧ�ð����ʳ���Ƶ���ɸߵ������������ͬ�ĵ�������ͬ����Ƶ�ʣ�����ĸ˳������
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
