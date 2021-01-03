package org.moi.algorithm.leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @program:
 * @description: leeCode ģ������
 * @author: moi
 * @create: 2021/1/3 22:32
 **/
public class MatrixRankTransform {

    /**
     * ��Ŀ������һ�� m x n �ľ��� matrix �����㷵��һ���µľ��� answer ������ answer[row][col] �� matrix[row][col] ���ȡ�
     *
     * ÿ��Ԫ�ص� �� ��һ����������ʾ���Ԫ�����������Ԫ�صĴ�С��ϵ�����������¹�����㣺
     *
     * ���Ǵ� 1 ��ʼ��һ��������
     * �������Ԫ�� p �� q �� ͬһ�� ���� ͬһ�� ����ô��
     * ��� p < q ����ô rank(p) < rank(q)
     * ��� p == q ����ô rank(p) == rank(q)
     * ��� p > q ����ô rank(p) > rank(q)
     * �� ��ҪԽ С Խ�á�
     * ��Ŀ��֤����������� answer ������Ψһ�ġ�
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

