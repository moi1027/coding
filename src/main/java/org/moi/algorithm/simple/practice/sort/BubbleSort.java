package org.moi.algorithm.simple.practice.sort;

/**
 * @program:
 * @description: √∞≈›≈≈–Ú
 * @author: moi
 * @create: 2021/2/26 22:19
 **/
public class BubbleSort {

    public int[] bubbleSort(int[] num){
        if(num == null|| num.length<2){
            return num;
        }
        for (int i = 0; i < num.length; i++) {
            for (int j = i; j < num.length; j++) {
                if(num[i]>num[j]){
                    swap(num,i,j);
                }
            }
        }
        return num;
    }

    private void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,1,5,9,2,4};
        System.out.println(new BubbleSort().bubbleSort(arr).toString());
    }
}
