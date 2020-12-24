package org.moi.algorithm.leecode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @program:
 * @description: 56. �ϲ����� �Ѷȣ�medium
 * @author: moi
 * @create: 2020/12/24 22:40
 **/
public class MergeIntervals {

    /**
     * ��Ŀ������һ������ļ��ϣ���ϲ������ص������䡣
     *
     *
     * ʾ�� 1:
     *
     * ����: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * ���: [[1,6],[8,10],[15,18]]
     * ����: ���� [1,3] �� [2,6] �ص�, �����Ǻϲ�Ϊ [1,6].
     * ʾ��?2:
     *
     * ����: intervals = [[1,4],[4,5]]
     * ���: [[1,5]]
     * ����: ���� [1,4] �� [4,5] �ɱ���Ϊ�ص����䡣
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
            //�Ƚ������ұ߽�Ĵ�С
            if(list.size()==0||list.get(list.size()-1)[1]<l){
                list.add(new int[]{l,r});
            }else{
                list.get(list.size()-1)[1]=Math.max(list.get(list.size()-1)[1],r);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
