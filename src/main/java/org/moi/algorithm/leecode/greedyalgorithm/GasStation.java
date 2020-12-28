package org.moi.algorithm.leecode.greedyalgorithm;

/**
 * @program:
 * @description: 134. 加油站 难度 medium
 * @author: moi
 * @create: 2020/12/28 21:49
 **/
public class GasStation {

    /**
     * 题目：在一条环路上有?N?个加油站，其中第?i?个加油站有汽油?gas[i]?升。
     *
     * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1?个加油站需要消耗汽油?cost[i]?升。你从其中的一个加油站出发，开始时油箱为空。
     *
     * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
     *
     * 说明:?
     *
     * 如果题目有解，该答案即为唯一答案。
     * 输入数组均为非空数组，且长度相同。
     * 输入数组中的元素均为非负数。
     *
     * 思路：如果gas大于cost的话就可以往下走
     */

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i = 0;i<gas.length;i++){
            //汽车的油量
            int carGas = 0;
            if(gas[i]>=cost[i]){
                carGas = carGas+gas[i];
                int j = i;
                while(carGas-cost[j]>=0){
                    carGas-=cost[j];
                    j=++j==cost.length?j%(cost.length):j;
                    if(j==i){
                        return i;
                    }
                    carGas += gas[j];
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas,cost));
    }
}
