package org.moi.algorithm.leecode;

import java.math.BigDecimal;

/**
 * @program:
 * @description: 50. Pow(x, n) �Ѷȣ�medium
 * @author: moi
 * @create: 2021/2/2 20:45
 **/
public class MyPow {

    /**
     * ��Ŀ��ʵ��?pow(x, n)?�������� x �� n ���ݺ���������xn����
     *
     * ?
     *
     * ʾ�� 1��
     *
     * ���룺x = 2.00000, n = 10
     * �����1024.00000
     * ʾ�� 2��
     *
     * ���룺x = 2.10000, n = 3
     * �����9.26100
     * ʾ�� 3��
     *
     * ���룺x = 2.00000, n = -2
     * �����0.25000
     * ���ͣ�2-2 = 1/22 = 1/4 = 0.25
     *
     *
     */

    public double myPow(double x, int n) {
        double res =  1.0;
        if(n<0){
            x = 1/x;
            n = -n;
        }else if(x == 0){
            return 1;
        }
        if(x == 1){
            res = 1;
            return res;
        }
        for (int i = 0; i < n; i++) {
            res = res*x;
        }
        BigDecimal bg = new BigDecimal(res);
         res = bg.setScale(2, BigDecimal.ROUND_DOWN).doubleValue();

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MyPow().myPow(2.00000,-2147483648));
        System.out.println(Math.pow(2.00000,-2147483648));
    }
}
