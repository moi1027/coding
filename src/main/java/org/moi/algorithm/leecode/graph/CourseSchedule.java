package org.moi.algorithm.leecode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program:
 * @description: �γ̱�
 * @author: moi
 * @create: 2021/1/4 21:32
 **/
public class CourseSchedule {

    /**
     *��Ŀ�������ѧ�ڱ���ѡ�� numCourse �ſγ̣���Ϊ?0?��?numCourse-1 ��
     *
     * ��ѡ��ĳЩ�γ�֮ǰ��ҪһЩ���޿γ̡�?���磬��Ҫѧϰ�γ� 0 ������Ҫ����ɿγ� 1 ��������һ��ƥ������ʾ���ǣ�[0,1]
     *
     * �����γ������Լ����ǵ��Ⱦ������������ж��Ƿ����������пγ̵�ѧϰ��
     *
     * ?
     *
     * ʾ�� 1:
     *
     * ����: 2, [[1,0]]
     * ���: true
     * ����:?�ܹ��� 2 �ſγ̡�ѧϰ�γ� 1 ֮ǰ������Ҫ��ɿγ� 0���������ǿ��ܵġ�
     * ʾ�� 2:
     *
     * ����: 2, [[1,0],[0,1]]
     * ���: false
     * ����:?�ܹ��� 2 �ſγ̡�ѧϰ�γ� 1 ֮ǰ������Ҫ�����?�γ� 0������ѧϰ�γ� 0 ֮ǰ���㻹Ӧ����ɿγ� 1�����ǲ����ܵġ�
     *
     *
     * ˼·����ͼ����������ķ�����д�������޻�ͼ
     */

    List<List<Integer>> edges;
    int[] indeg;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for(int i = 0;i<numCourses;i++){
            edges.add(new ArrayList<Integer>());
        }
        indeg = new int[numCourses];
        for(int[] info : prerequisites){
            //����ͼ���յ㵱���±�
            edges.get(info[1]).add(info[0]);
            indeg[info[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            //���Ϊ0�ĵ����
            if(indeg[i] == 0){
                queue.offer(i);
            }
        }
        int visited = 0;
        while (!queue.isEmpty()) {
            //����ͳ���������Ľڵ����
            ++visited;
            int u = queue.poll();
            for (int v: edges.get(u)) {
                //��ȼ�һ
                --indeg[v];
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return visited == numCourses;
    }

    public static void main(String[] args) {
        int[][] p = {{1,0}};
        new CourseSchedule().canFinish(2,p);
    }
}
