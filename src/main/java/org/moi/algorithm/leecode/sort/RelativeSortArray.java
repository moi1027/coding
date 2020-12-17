package org.moi.algorithm.leecode.sort;

import java.util.*;

/**
 * @program:
 * @description: leeCode 1122 ������������ �Ѷȣ�easy
 * @author: moi
 * @create: 2020/12/17 21:24
 **/
public class RelativeSortArray {

    /**
     * ��Ŀ�������������飬arr1 ��?arr2��
     *
     * arr2?�е�Ԫ�ظ�����ͬ
     * arr2 �е�ÿ��Ԫ�ض�������?arr1?��
     * �� arr1?�е�Ԫ�ؽ�������ʹ arr1 ��������˳���?arr2?�е����˳����ͬ��δ��?arr2?�г��ֹ���Ԫ����Ҫ�����������?arr1?��ĩβ��
     *
     * ˼·�����Զ�������
     */

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<arr1.length;i++){
            list.add(arr1[i]);
        }
        for(int i = 0;i<arr2.length;i++){
            map.put(arr2[i],i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(map.containsKey(o1)||map.containsKey(o2)){
                    return map.getOrDefault(o1,1001)-map.getOrDefault(o2,1001);
                }
                return o1-o2;
            }
        });
        for(int i = 0;i<list.size();i++){
            arr1[i] = list.get(i);
        }
        return arr1;
    }

}
