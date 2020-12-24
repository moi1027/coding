package org.moi.algorithm.leecode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @program:
 * @description: 56. 合并区间 难度：medium
 * @author: moi
 * @create: 2020/12/24 22:40
 **/
public class MergeIntervals {

    /**
     * 题目：给出一个区间的集合，请合并所有重叠的区间。
     *
     *
     * 示例 1:
     *
     * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * 示例?2:
     *
     * 输入: intervals = [[1,4],[4,5]]
     * 输出: [[1,5]]
     * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
     *
     *
     */

    public int[][] merge(int[][] intervals) {
        if(intervals.length== 0){
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> list = new ArrayList<int[]>();
        for(int i = 0;i<intervals.length;i++){
            int l = intervals[i][0];
            int r = intervals[i][1];
            if(list.size()==0||list.get(list.size()-1)[1]<l){
                list.add(new int[]{l,r});
            }else{
                list.get(list.size()-1)[1]=Math.max(list.get(list.size()-1)[1],r);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
