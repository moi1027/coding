package org.moi.algorithm.leecode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program:
 * @description: 210. �γ̱� II �Ѷȣ�medium
 * @author: moi
 * @create: 2021/1/4 22:08
 **/
public class CourseScheduleII {

    /**
     * ��Ŀ�� �������ܹ��� n �ſ���Ҫѡ����Ϊ?0?��?n-1��
     *
     * ��ѡ��ĳЩ�γ�֮ǰ��ҪһЩ���޿γ̡�?���磬��Ҫѧϰ�γ� 0 ������Ҫ����ɿγ�?1 ��������һ��ƥ������ʾ����: [0,1]
     *
     * �����γ������Լ����ǵ��Ⱦ�������������Ϊ��ѧ�����пγ������ŵ�ѧϰ˳��
     *
     * ���ܻ��ж����ȷ��˳����ֻҪ����һ�־Ϳ����ˡ����������������пγ̣�����һ�������顣
     *
     * ʾ��?1:
     *
     * ����: 2, [[1,0]]
     * ���: [0,1]
     * ����:?�ܹ��� 2 �ſγ̡�Ҫѧϰ�γ� 1������Ҫ����ɿγ� 0����ˣ���ȷ�Ŀγ�˳��Ϊ [0,1] ��
     * ʾ��?2:
     *
     * ����: 4, [[1,0],[2,0],[3,1],[3,2]]
     * ���: [0,1,2,3] or [0,2,1,3]
     * ����:?�ܹ��� 4 �ſγ̡�Ҫѧϰ�γ� 3����Ӧ������ɿγ� 1 �Ϳγ� 2�����ҿγ� 1 �Ϳγ� 2 ��Ӧ�����ڿγ� 0 ֮��
     * ?    ��ˣ�һ����ȷ�Ŀγ�˳����?[0,1,2,3] ����һ����ȷ��������?[0,2,1,3] ��
     * ˵��:
     *
     * ������Ⱦ��������ɱ�Ե�б��ʾ��ͼ�Σ��������ڽӾ���������μ�ͼ�ı�ʾ����
     * ����Լٶ�������Ⱦ�������û���ظ��ıߡ�
     *
     * ˼·����ͼ���������������������� �����޻�ͼ BFS
     */

    List<List<Integer>> edges;
    int[] indeg;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }
        indeg = new int[numCourses];
        for(int[] info:prerequisites){
            edges.get(info[1]).add(info[0]);
            indeg[info[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(indeg[i]==0){
                queue.offer(i);
            }
        }
        int[] res = new int[numCourses];
        int nums = 0;
        while(!queue.isEmpty()){
            int u = queue.poll();
            res[nums] = u;
            nums++;
            for(int v : edges.get(u)){
                indeg[v]--;
                if(indeg[v]==0){
                    queue.offer(v);
                }
            }
        }
        if(nums == numCourses){
            return res;
        }else{
            return new int[]{};
        }

    }

    public static void main(String[] args) {
        int[][] p = {{1,0},{2,0},{3,1},{3,2}};
        new CourseScheduleII().findOrder(4,p);
    }
}
