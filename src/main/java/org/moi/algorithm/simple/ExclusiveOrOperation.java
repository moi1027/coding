package org.moi.algorithm.simple;

/**
 * @program:
 * @description: 异或运算 (相加无进位运算)
 * @author: moi
 * @create: 2020/11/14 21:45
 **/
public class ExclusiveOrOperation {

    /**
     * 与运算法则 0&0 = 0；0&1=0；1&0=0；1&1=1；
     * &运算：相当于十进制 相同位做加法的1/2
     * |运算：相当于十进制 相同位做加法的1/2与不同位做加法求和
     * ^运算：相当于十进制不同位做加法
     *
     */

    /**
     * 利用异或运算将两个数的值给交换
     * @param a
     * @param b
     */
    public static void swap(int a,int b){
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println(a+" "+b);
    }


    public static int searchOne(int[] arr){
        //查找数组中的唯一一个奇数项的元素
        int eor = 0;
        for(int i: arr){
            eor = eor ^ i;
        }
        System.out.println(eor);
        return eor;
    }


    public static int extractRightOne(int a){
        //提取二进制a 中最右边的一个1的二进制数
        //加入传进来的数是10 则为 00000110
        //取最右一个1 则为00000010 = 2
        int ans = a&((~a)+1);
        System.out.println(ans);
        return ans;
    }

    public static void searchTwo(int[] arr){
        //当一个数组中有两个奇数次项是求出这两项
        int eor = searchOne(arr);
        //得到异或之后的数的最右边的1
        int rightOne = extractRightOne(eor);
        int onlyOne = 0;
        for(int i:arr){
            //用rightOne去与运算一下相当于补齐一个奇数项只留下另一个奇数项
            if((i&rightOne) != 0){
                onlyOne ^= i;
            }
        }
        System.out.println(onlyOne+" "+(eor^onlyOne));
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,2,2};
        int[] arr1 = {1,1,1,2,2,2,2,3};
        swap(2,3);
        searchOne(arr);
        extractRightOne(10);
        searchTwo(arr1);
    }

}
