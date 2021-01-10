package org.moi.algorithm.leecode.sort;

/**
 * @program:
 * @description: 1287. ���������г��ִ�������25%��Ԫ�� �Ѷȣ�easy;
 * @author: moi
 * @create: 2021/1/10 20:07
 **/
public class FindSpecialInteger {

    /**
     * ��Ŀ������һ���ǵݼ���?����?�������飬��֪���������ǡ����һ�����������ĳ��ִ�����������Ԫ�������� 25%��
     *
     * �����ҵ��������������
     *
     * ?
     *
     * ʾ����
     *
     * ���룺arr = [1,2,2,6,6,6,6,7,10]
     * �����6
     *
     *
     */

    public int findSpecialInteger(int[] arr) {
        int len = arr.length;
        int flag = len >>2;
        int max = 1;
        int n = 1;
        for(int i = 1;i<len ;i++){
            if(arr[i]== arr[i-1]){
                n++;
            }else{
                max = Math.max(max,n);
                if(max>flag){
                    return arr[i-1];
                }
                n = 1;
            }
        }
        return arr[len-1];
    }

    public static void main(String[] args) {
        int[] arr = {1,1};
        new FindSpecialInteger().findSpecialInteger(arr);
    }
}
