package org.moi.algorithm.leecode.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @program:
 * @description: 57. 插入区间 难度：hard
 * @author: moi
 * @create: 2020/12/29 21:48
 **/
public class InsertInterval {

    /**
     * 题目：给出一个无重叠的 ，按照区间起始端点排序的区间列表。
     *
     * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
     *
     * ?
     *
     * 示例?1：
     *
     * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
     * 输出：[[1,5],[6,9]]
     * 示例?2：
     *
     * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
     * 输出：[[1,2],[3,10],[12,16]]
     * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10]?重叠。
     *
     *
     */
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean place = false;
        List<int[]> list = new ArrayList<>();
        for(int[] interval:intervals){
            if(interval[0]>right){
                if(!place){
                    list.add(new int[]{left,right});
                    place = true;
                }
                list.add(interval);
            }else if(interval[1]<left){
                list.add(interval);
            }else{
                left = Math.min(left,interval[0]);
                right = Math.max(right,interval[1]);
            }
        }
        if(!place){
            list.add(new int[]{left,right});
        }
        int[][] res = new int[list.size()][];
        for(int i = 0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
        insert(arr,new int[]{4,8});
    }
}
