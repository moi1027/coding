package org.moi.algorithm.simple.practice.sort;

/**
 * @program:
 * @description: ¶þ·Ö²éÕÒ
 * @author: moi
 * @create: 2021/2/26 22:39
 **/
public class BSExist {

    public int bsExist(int[] sortedArr,int num){
        int L = 0,R = sortedArr.length-1;
        while(L<R){
            int tmp = R>>1;
            if(sortedArr[tmp]>num){
                R = tmp-1;
            }else if(sortedArr[tmp]<num){
                L = tmp+1;
            }else{
                return tmp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(new BSExist().bsExist(arr,2));
    }
}
