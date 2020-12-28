package org.moi.algorithm.leecode.greedyalgorithm;

/**
 * @program:
 * @description: 134. ����վ �Ѷ� medium
 * @author: moi
 * @create: 2020/12/28 21:49
 **/
public class GasStation {

    /**
     * ��Ŀ����һ����·����?N?������վ�����е�?i?������վ������?gas[i]?����
     *
     * ����һ�������������޵ĵ��������ӵ� i ������վ������ i+1?������վ��Ҫ��������?cost[i]?����������е�һ������վ��������ʼʱ����Ϊ�ա�
     *
     * ���������ƻ�·��ʻһ�ܣ��򷵻س���ʱ����վ�ı�ţ����򷵻� -1��
     *
     * ˵��:?
     *
     * �����Ŀ�н⣬�ô𰸼�ΪΨһ�𰸡�
     * ���������Ϊ�ǿ����飬�ҳ�����ͬ��
     * ���������е�Ԫ�ؾ�Ϊ�Ǹ�����
     *
     * ˼·�����gas����cost�Ļ��Ϳ���������
     */

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i = 0;i<gas.length;i++){
            //����������
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
