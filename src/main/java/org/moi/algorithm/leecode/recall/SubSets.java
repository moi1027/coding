package org.moi.algorithm.leecode.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @description: 78 leeCode 子集 难度 medium
 * @author: moi
 * @create: 2020/12/18 22:09
 **/
public class SubSets {


    /**
     * 题目：给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     *
     * 说明：解集不能包含重复的子集。
     * 思路：用回溯
     */

    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public   List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3};
        SubSets s = new SubSets();
        s.subsets(arr);
    }

}
