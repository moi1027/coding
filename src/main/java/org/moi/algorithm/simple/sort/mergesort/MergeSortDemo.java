package org.moi.algorithm.simple.sort.mergesort;

/**
 * @program:
 * @description: 排序之一：归并排序 时间复杂度 O(N*logN)
 * @author: moi
 * @create: 2020/11/22 14:14
 **/
public class MergeSortDemo {

    /**
     * 归并排序解释：归并排序将一个数组分成两部分，对左右两边做一个排序，最后将有序的
     *           两边做一个归并（要申请一个额外的空间）这样一次排序就做好了，当对一个
     *           数组层层递归调用这种方法时，从最小粒度开始做好了排序，最后反推回原数组
     *           让数组都做好了排序
     */


    /**
     * 第一种方式：递归的方式
     * @param arr
     * @param L
     * @param R
     */
    public static void  process(int[] arr,int L,int R){
        if(L == R){
            return ;
        }
        //让变量medium 来作为一个L R 下标的中间下标
        int medium = L+((R-L)>>1);
        //将左边的数组空间进行排序
        process(arr,L,medium);
        //将右边的数组空间进行排序
        process(arr,medium+1,R);
        merge(arr,L,medium,R);
    }

    /**
     * 进行合并
     * @param arr
     * @param L
     * @param medium
     * @param R
     */
    public static void merge(int[] arr,int L,int medium,int R){
        //先开辟一个额外的空间
        int[] newInt = new int[R-L+1];
        int i = 0;
        //需要两个指针变量 让这两个指针变量都指向左右两个数组空间的第一个数的下标，通过移动这两个下标从而来进行排序合并
        int p1 = L,p2 = medium+1;
        //条件是下标不会越界
        while(p1 <= medium &&p2 <= R){
            //一行代码进行合并
            //解释：当左边的arr[p1]<arr[p2]的时候就将arr[p1]赋值给newInt[i],然后将p1指针指向下一项，反之也是如此
            newInt[i++] = arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
        }
        //解释：当有一方的数组已经全部被排序完毕之后，另外一方还有数没有插入到这个额外空间中时，就要将另外一方的数插入到额外空间中
        while(p1 <= medium){
            newInt[i++] = arr[p1++];
        }
        while(p2 <= R){
            newInt[i++] = arr[p2++];
        }
        //将额外空间中排序好的数写回到原数组中
        for(i = 0;i<newInt.length;i++){
            arr[L+i] = newInt[i];
        }
        //至此就完成了一个排序
    }

    /**
     * 开始计算时间复杂度：
     * 由于是递归算法，解释如下：
     * 递归分为两个部分，则可用公式：T(N) = a*T(N/b)+O(N^d);
     * 有两个部分则 a = 2,b =2; 而d 的取值要取决于 merge()方法的时间复杂度
     *          merge的时间复杂度：一次给额外的数组赋值，循环N次。一次将额外数组的数据写回到原数组，循环N次。则为2*N，忽略常数项 则为O(N)
     * 由于merge方法的时间复杂度为O(N),d = 1
     * 所以符合loga(下)b == d ==>log2 = 1:则时间复杂度为O(N*logN)
     *
     */


    /***********************************************分割*************************************************/

    /**
     * 解法2:非递归的方式
     * @param arr
     */
    public static void  process2(int[] arr){
        if(arr.length<2||arr==null){
            return;
        }
        int len = arr.length;
        //最先开始的左边数组的大小,由于归并是由左边和右边的两方进行归并的，所以归并的初始规模是2
        int mergeSize = 1;
        while(mergeSize<len){
            int l = 0;
            //从头开始 0
            while(l<len) {
                int medium = l + mergeSize - 1;
                if (medium > len) {
                    break;
                }
                int r = Math.min(medium + mergeSize, len - 1);
                //对每个规模大小的小块进行归并
                merge(arr, l, medium, r);
                //移动到下一个小模块
                l = r + 1;
            }
            //避免下标越界，不影响功能
            if(mergeSize > len/2){
                break;
            }
            //归并的规模扩大2倍
            mergeSize <<=1;
        }
    }

    /**
     * 计算非递归方式的时间复杂度：
     *      由于第一个while是以2的倍数的方式进行递增的为logN 而第二个while是以单增的方式进行递增的，所以为N
     *      另个while嵌套,而merge的时间复杂度为O(N),最后得到时间复杂度还是为O(N*logN)
     */





    public static void main(String[] args) {
        int[] arr = {1,2,4,7,3,1};
        process2(arr);
        for(int i = 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

}
