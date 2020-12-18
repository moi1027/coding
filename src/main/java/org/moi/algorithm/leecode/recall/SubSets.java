package org.moi.algorithm.leecode.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @description: 78 leeCode �Ӽ� �Ѷ� medium
 * @author: moi
 * @create: 2020/12/18 22:09
 **/
public class SubSets {


    /**
     * ��Ŀ������һ�鲻���ظ�Ԫ�ص��������� nums�����ظ��������п��ܵ��Ӽ����ݼ�����
     *
     * ˵�����⼯���ܰ����ظ����Ӽ���
     * ˼·���û���
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
