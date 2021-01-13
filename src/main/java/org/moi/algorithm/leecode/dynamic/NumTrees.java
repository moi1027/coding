package org.moi.algorithm.leecode.dynamic;

/**
 * @program:
 * @description:
 * @author: moi
 * @create: 2021/1/13 22:46
 **/
public class NumTrees {

    public int numTrees(int n) {
        int[] tree = new int[n<=3?4:n+1];
        tree[0] = 1;tree[1] = 1;tree[2] = 3;tree[3] = 5;
        subNumTrees(n,tree);
        return tree[n];
    }

    public int subNumTrees(int n,int[] tree){
        if(tree[n]!=0){
            return tree[n];
        }
        int res = 0;
        for (int i = 1; i < n; i++) {
            int left = tree[i-1]==0?subNumTrees(i-1,tree):tree[i-1];
            int right = tree[n-i]==0?subNumTrees(n-i,tree):tree[n-i];
            res +=left*right;
        }
        tree[n] = res;
        return res;
    }

    public static void main(String[] args) {
        new NumTrees().numTrees(4);
    }
}
