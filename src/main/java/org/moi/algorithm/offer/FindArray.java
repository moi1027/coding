package org.moi.algorithm.offer;

/**
 * @program:
 * @description: 剑指offer第一题：在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
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