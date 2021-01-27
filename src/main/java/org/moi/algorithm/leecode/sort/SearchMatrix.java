package org.moi.algorithm.leecode.sort;

/**
 * @program:
 * @description: 240. 搜索二维矩阵 II 难度：medium
 * @author: moi
 * @create: 2021/1/27 21:43
 **/
public class SearchMatrix {

    /**
     * 题目：编写一个高效的算法来搜索?m?x?n?矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
     *
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     * ?
     *
     * 示例 1：
     *
     *
     * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
     * 输出：true
     *
     */

    public boolean searchMatrix(int[][] matrix, int target) {
        int xLen = matrix.length;
        int yLen = matrix[0].length;
        if(matrix[0][0] == target){
            return true;
        }
        for (int i = 1; i < xLen; i++) {
            if(matrix[i-1][0]<target&&matrix[i][0]>target){
                for (int j = 0; j < yLen; j++) {
                    if(matrix[i-1][j]==target){
                        return true;
                    }
                }
            }else if(matrix[i-1][0] == target||matrix[i][0]==target){
                return true;
            }else if(matrix[i][0]<target&&i+1==xLen){
                for (int j = 0; j < yLen; j++) {
                    if(matrix[i][j]==target){
                        return true;
                    }
                }
            }
        }
        for (int i = 1; i < yLen; i++) {
            if(matrix[0][i-1]<target&&matrix[0][i]>target){
                for (int j = 0; j < xLen; j++) {
                    if(matrix[j][i-1]==target){
                        return true;
                    }
                }
            }else if(matrix[0][i-1] == target||matrix[0][i]==target){
                return true;
            }else if(matrix[0][i]<target&&i+1==yLen){
                for (int j = 0; j < xLen; j++) {
                    if(matrix[j][i]==target){
                        return true;
                    }
                }
            }
        }
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }
}
