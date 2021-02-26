package org.moi.algorithm.simple.practice.sort;

/**
 * @program:
 * @description: —°‘Ò≈≈–Ú
 * @author: moi
 * @create: 2021/2/26 22:12
 **/
public class SelectCort {

    public int[] selectSort(int[] num){
        if(num==null||num.length<2){
            return num;
        }
        for (int i = 0; i < num.length; i++) {
            int minIndex = i;
            for (int j = num.length-1; j >=i; j--) {
                minIndex = num[j]>num[minIndex]?minIndex:j;
            }
            swap(num,i,minIndex);
        }
        return num;
    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,1,5,9,2,4};
        System.out.println(new SelectCort().selectSort(arr).toString());
    }
}
