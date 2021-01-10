package org.moi.algorithm.leecode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program:
 * @description: 39. 组合总和 难度：medium
 * @author: moi
 * @create: 2021/1/9 22:31
 **/
public class CombinationSum {

    /**
     * 题目：给定一个无重复元素的数组?candidates?和一个目标数?target?，找出?candidates?中所有可以使数字和为?target?的组合。
     *
     * candidates?中的数字可以无限制重复被选取。
     *
     * 说明：
     *
     * 所有数字（包括?target）都是正整数。
     * 解集不能包含重复的组合。?
     * 示例?1：
     *
     * 输入：candidates = [2,3,6,7], target = 7,
     * 所求解集为：
     * [
     *   [7],
     *   [2,2,3]
     * ]
     *
     *
     */

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        subCombinationSum(res,new ArrayList<>(),candidates,target,0);
        return res;
    }
    
    public void subCombinationSum(List<List<Integer>> res,List<Integer> list,int[] candidates,int target,int index){
        if(target<0){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if(target < 0){
                break;
            }
            list.add(candidates[i]);
            subCombinationSum(res,list,candidates,target-candidates[i],i);
            list.remove(list.size()-1);
        }
    }


}
