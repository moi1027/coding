package org.moi.algorithm.leecode.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @program:
 * @description: 57. �������� �Ѷȣ�hard
 * @author: moi
 * @create: 2020/12/29 21:48
 **/
public class InsertInterval {

    /**
     * ��Ŀ������һ�����ص��� ������������ʼ�˵�����������б�
     *
     * ���б��в���һ���µ����䣬����Ҫȷ���б��е�������Ȼ�����Ҳ��ص�������б�Ҫ�Ļ������Ժϲ����䣩��
     *
     * ?
     *
     * ʾ��?1��
     *
     * ���룺intervals = [[1,3],[6,9]], newInterval = [2,5]
     * �����[[1,5],[6,9]]
     * ʾ��?2��
     *
     * ���룺intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
     * �����[[1,2],[3,10],[12,16]]
     * ���ͣ�������Ϊ�µ����� [4,8] �� [3,5],[6,7],[8,10]?�ص���
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
