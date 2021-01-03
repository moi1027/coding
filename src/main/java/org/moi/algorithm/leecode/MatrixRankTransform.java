package org.moi.algorithm.leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @program:
 * @description: leeCode 模拟面试
 * @author: moi
 * @create: 2021/1/3 22:32
 **/
public class MatrixRankTransform {

    /**
     * 题目：给你一个 m x n 的矩阵 matrix ，请你返回一个新的矩阵 answer ，其中 answer[row][col] 是 matrix[row][col] 的秩。
     *
     * 每个元素的 秩 是一个整数，表示这个元素相对于其他元素的大小关系，它按照如下规则计算：
     *
     * 秩是从 1 开始的一个整数。
     * 如果两个元素 p 和 q 在 同一行 或者 同一列 ，那么：
     * 如果 p < q ，那么 rank(p) < rank(q)
     * 如果 p == q ，那么 rank(p) == rank(q)
     * 如果 p > q ，那么 rank(p) > rank(q)
     * 秩 需要越 小 越好。
     * 题目保证按照上面规则 answer 数组是唯一的。
     */

    class MatrixInfo{
        private int x;
        private int y;
        private int value;
        public  MatrixInfo(int x,int y,int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    public int[][] matrixRankTransform(int[][] matrix) {
        List<MatrixInfo> matrixInfos = new ArrayList<>();
        for(int i = 0;i<matrix[0].length;i++){
            for(int j = 0;j<matrix.length;j++){
                MatrixInfo matrixInfo = new MatrixInfo(i,j,matrix[i][j]);
                matrixInfos.add(matrixInfo);
            }
        }
        Collections.sort(matrixInfos, new Comparator<MatrixInfo>() {
            @Override
            public int compare(MatrixInfo o1, MatrixInfo o2) {
                return o1.value-o2.value;
            }
        });
        int[][] res = new int[matrix[0].length][matrix.length];
        res[matrixInfos.get(0).x][matrixInfos.get(0).y] = 1;
        int  n = 1;
        for(int i = 1;i<matrixInfos.size();i++){
            if(matrixInfos.get(i).value == matrixInfos.get(i-1).value){
                res[matrixInfos.get(i).x][matrixInfos.get(i).y] = n;
            }else{
                n++;
                res[matrixInfos.get(i).x][matrixInfos.get(i).y] = n;
            }

        }
        return res;
    }
}

