package org.moi.algorithm.offer;

/**
 * @program:
 * @description: ��ָoffer��һ�⣺��һ����ά�����У�ÿ��һά����ĳ�����ͬ����ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳�����������һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
 * @author: moi
 * @create: 2021/3/6 22:06
 **/
public class FindArray {

    public boolean Find(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            if(bsFind(array[i],target)){
                return true;
            }
        }
        return false;
    }

    public boolean bsFind(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return false;
    }


    public static void main(String[] args) {
        int[][] arr = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(new FindArray().Find(15,arr));
    }
}