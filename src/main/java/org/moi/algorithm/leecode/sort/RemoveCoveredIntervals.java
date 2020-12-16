package org.moi.algorithm.leecode.sort;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @program:
 * @description: leeCode 1288 删除被覆盖区间
 * @author: moi
 * @create: 2020/12/16 21:59
 **/
public class RemoveCoveredIntervals {

    /**
     * 题目：给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
     *
     * 只有当?c <= a?且?b <= d?时，我们才认为区间?[a,b) 被区间?[c,d) 覆盖。
     *
     * 在完成所有删除操作后，请你返回列表中剩余区间的数目。
     *
     *
     */

    public static int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //比较每个数组的第一项，如果相等，则按第二项的降序排列，如果不相等则按第一项的升序排序
                return o1[0] == o2[0] ? o2[1] - o1[1]: o1[0] - o2[0];
            }
        });
        int pre_end = 0;
        int count = 0;
        int end = 0;
        for(int[] arr: intervals){
            end = arr[1];
            if(pre_end<end){
                count++;
                pre_end = end;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] s =  {{1,4},{3,6},{2,8}};
        removeCoveredIntervals(s);
    }
}
