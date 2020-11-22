package org.moi.algorithm.simple.sort.quicksort;

/**
 * @program:
 * @description: 排序之一：快速排序 时间复杂度：O(N*logN)
 * @author: moi
 * @create: 2020/11/22 15:51
 **/
public class QuickSortDemo {


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // arr[L...R] 玩荷兰国旗问题的划分，以arr[R]做划分值
    //  <arr[R]  ==arr[R]  > arr[R]
    public static int[] netherlandsFlag(int[] arr, int L, int R) {
        if (L > R) {
            return new int[] { -1, -1 };
        }
        if (L == R) {
            return new int[] { L, R };
        }
        // < 区 右边界
        int less = L - 1;
        // > 区 左边界
        int more = R;
        int index = L;
        while (index < more) {
            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] < arr[R]) {
                swap(arr, index++, ++less);
            } else { // >
                swap(arr, index, --more);
            }
        }
        swap(arr, more, R);
        return new int[] { less + 1, more };
    }


    /**
     * 直接上3.0版本
     * @param arr
     * @param L
     * @param R
     */
    public static void process(int[] arr,int L,int R){
        if (L >= R) {
            return;
        }
        //随机生成一个基准数
        swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
        int[] equalArea = netherlandsFlag(arr, L, R);
        process(arr, L, equalArea[0] - 1);
        process(arr, equalArea[1] + 1, R);
    }



}
