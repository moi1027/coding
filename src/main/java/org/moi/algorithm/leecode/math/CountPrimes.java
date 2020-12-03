package org.moi.algorithm.leecode.math;

/**
 * @program:
 * @description: leecode �������� �Ѷȣ�easy
 * @author: moi
 * @create: 2020/12/3 9:40
 **/
public class CountPrimes {


    /**
     * ͳ������С�ڷǸ����� n ��������������
     */
    public static int countPrimes(int n) {
        if(n<=1){
            return 0;
        }
        int count = 0;
        for(int i = 2;i<n;i++){
            boolean falg = true;
            for(int j = 2;j<=(int)Math.sqrt(i);j++){
                if(i%j == 0){
                    falg = false;
                    break;
                }
            }
            if(falg){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(countPrimes(n));
    }
}
