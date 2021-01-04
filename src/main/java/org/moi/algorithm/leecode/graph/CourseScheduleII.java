package org.moi.algorithm.leecode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program:
 * @description: 210. 课程表 II 难度：medium
 * @author: moi
 * @create: 2021/1/4 22:08
 **/
public class CourseScheduleII {

    /**
     * 题目： 现在你总共有 n 门课需要选，记为?0?到?n-1。
     *
     * 在选修某些课程之前需要一些先修课程。?例如，想要学习课程 0 ，你需要先完成课程?1 ，我们用一个匹配来表示他们: [0,1]
     *
     * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
     *
     * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
     *
     * 示例?1:
     *
     * 输入: 2, [[1,0]]
     * 输出: [0,1]
     * 解释:?总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
     * 示例?2:
     *
     * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
     * 输出: [0,1,2,3] or [0,2,1,3]
     * 解释:?总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
     * ?    因此，一个正确的课程顺序是?[0,1,2,3] 。另一个正确的排序是?[0,2,1,3] 。
     * 说明:
     *
     * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
     * 你可以假定输入的先决条件中没有重复的边。
     *
     * 思路：用图的拓扑排序来解决这个问题 有向无环图 BFS
     */

    List<List<Integer>> edges;
    int[] indeg;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
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
