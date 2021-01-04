package org.moi.algorithm.leecode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program:
 * @description: 课程表
 * @author: moi
 * @create: 2021/1/4 21:32
 **/
public class CourseSchedule {

    /**
     *题目：你这个学期必须选修 numCourse 门课程，记为?0?到?numCourse-1 。
     *
     * 在选修某些课程之前需要一些先修课程。?例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
     *
     * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
     *
     * ?
     *
     * 示例 1:
     *
     * 输入: 2, [[1,0]]
     * 输出: true
     * 解释:?总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
     * 示例 2:
     *
     * 输入: 2, [[1,0],[0,1]]
     * 输出: false
     * 解释:?总共有 2 门课程。学习课程 1 之前，你需要先完成?课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
     *
     *
     * 思路：用图的拓扑排序的方法来写，有向无环图
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
            //有向图的终点当做下标
            edges.get(info[1]).add(info[0]);
            indeg[info[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            //入度为0的点入队
            if(indeg[i] == 0){
                queue.offer(i);
            }
        }
        int visited = 0;
        while (!queue.isEmpty()) {
            //用来统计最后排序的节点个数
            ++visited;
            int u = queue.poll();
            for (int v: edges.get(u)) {
                //入度减一
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
