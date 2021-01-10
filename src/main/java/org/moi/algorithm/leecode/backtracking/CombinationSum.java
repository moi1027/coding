package org.moi.algorithm.leecode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program:
 * @description: 39. ����ܺ� �Ѷȣ�medium
 * @author: moi
 * @create: 2021/1/9 22:31
 **/
public class CombinationSum {

    /**
     * ��Ŀ������һ�����ظ�Ԫ�ص�����?candidates?��һ��Ŀ����?target?���ҳ�?candidates?�����п���ʹ���ֺ�Ϊ?target?����ϡ�
     *
     * candidates?�е����ֿ����������ظ���ѡȡ��
     *
     * ˵����
     *
     * �������֣�����?target��������������
     * �⼯���ܰ����ظ�����ϡ�?
     * ʾ��?1��
     *
     * ���룺candidates = [2,3,6,7], target = 7,
     * ����⼯Ϊ��
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
