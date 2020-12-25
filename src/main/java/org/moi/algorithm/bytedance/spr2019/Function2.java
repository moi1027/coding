package org.moi.algorithm.bytedance.spr2019;

import sun.plugin.javascript.navig.Link;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @program:
 * @description: �ֽ����� 2019���б�����
 * @author: moi
 * @create: 2020/12/25 21:53
 **/
public class Function2 {

    /**
     * ��Ŀ��
     * �ҽ����󴸣���һ���ع����Ҹոսӵ��������ֽ�������ֽ��������ץ���ֲ����ӿ���˳������һ���ж��Ļ������������ع���������
     *
     * 1. �������ֽ�������ֵ�N��������ѡ��3������ص㡣
     * 2. Ϊ���໥��Ӧ�����Ǿ��������Զ�������ع���ľ��벻����D��
     *
     * �������Ǹ����! �������ܵļ��㣬���Ǵ�X�ֿ��е����������ѡ����һ�֡������������һʧ�������ɣ�����˳��
     * ����
     * ����û�뵽���ƻ�����ʧ���ˣ�����˳��ױ��С��Ů������cosplay�Ķ������ӳ����ֽ�������֡�ֻ������αװ̫�ɹ��ˣ����������������Ҳ���ֲ��˵ģ�
     *
     * �����⣺����N����ѡ��Ϊ�����Ľ�����������D�������Զ�������ع���ľ�������ֵ���Լ���ѡ���������꣬����������ж��У��󴸵�С���ж��������ѡ��
     * ע�⣺
     * 1. �����ع����������ͬһ�ص�
     * 2. �����ع��ǵȼ۵ģ���ͬ����λ�����(A, B, C) ֻ��һ������������������ع�֮�以��λ�á����ظ�ʹ��
     *
     *
     * ��������:
     * ��һ�а����ո�ָ����������� N��D(1?��?N?��?1000000; 1?��?D?��?1000000)
     *
     * �ڶ��а���N��������ĵ�λ�ã�ÿ��λ����һ��������ȡֵ����Ϊ[0, 1000000]����ʾ����С�������У����ֽ�������ֿ���һ�����ᣩ
     *
     * �������:
     * һ�����֣���ʾ��ͬ������������������������������ 99997867 ȡģ
     *
     * ��������1:
     * 4 3
     * 1 2 3 4
     *
     * �������1:
     * 4
     *
     * ����˵��1:
     * ��ѡ���� (1, 2, 3), (1, 2, 4), (1, 3, 4), (2, 3, 4)
     *
     * ��������2:
     * 5 19
     * 1 10 20 30 50
     *
     * �������2:
     * 1
     *
     * ����˵��2:
     * ��ѡ���� (1, 10, 20)
     */


    LinkedList<Integer> list = new LinkedList<>();

    public void solution(){


        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), D = sc.nextInt();
        long cnt = 0;
        if (N <= 2) {
            System.out.println(-1);
            return;
        }
        int[] locs = new int[N];
        for (int i = 0; i < N; i++) {
            locs[i] = sc.nextInt();
        }
        sc.close();
        int left = 0, right = 2;
        while (right < N) {
            if (locs[right] - locs[left] > D){
                left++;
            }else if (right - left < 2) {
                right++;
            }else {
                cnt += calC(right - left);
                right++;
            }
        }
        cnt %= 99997867;
        System.out.println(cnt);
    }



    private long calC(long num) {
        return num * (num - 1) / 2;
    }


    public static void main(String[] args) {
        new Function2().solution();
    }
}
