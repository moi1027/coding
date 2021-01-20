package org.moi.algorithm.leecode.dynamic;

/**
 * @program:
 * @description: 200. �������� �Ѷȣ�medium
 * @author: moi
 * @create: 2021/1/20 22:13
 **/
public class NumIslands {

    /**
     * ��Ŀ������һ����?'1'��½�أ��� '0'��ˮ����ɵĵĶ�ά����������������е����������
     *
     * �������Ǳ�ˮ��Χ������ÿ������ֻ����ˮƽ�����/����ֱ���������ڵ�½�������γɡ�
     *
     * ���⣬����Լ��������������߾���ˮ��Χ��
     *
     * ?
     *
     * ʾ�� 1��
     *
     * ���룺grid = [
     *   ["1","1","1","1","0"],
     *   ["1","1","0","1","0"],
     *   ["1","1","0","0","0"],
     *   ["0","0","0","0","0"]
     * ]
     * �����1
     *
     *
     */

    public int numIslands(char[][] grid) {
        int xLen = grid.length;
        int yLen = grid[0].length;
        int num = 0;
        for (int i = 0; i < yLen; i++) {
            if(grid[0][i]=='1'){
               if(i>0&&(grid[0][i-1]=='1'||grid[0][i-1]=='2')) {
                   grid[0][i] = '2';
               }
            }
        }
        for (int i = 0; i < xLen; i++) {
            if(grid[i][0]=='1'){
                if(i>0&&(grid[i-1][0]=='1'||grid[i-1][0]=='2')) {
                    grid[i][0] = '2';
                }
            }
        }
        for (int i = 1; i < xLen; i++) {
            for (int j = 1; j < yLen; j++) {
                if(grid[i][j]=='1'){
                    if(grid[i-1][j]=='2'||grid[i][j-1]=='2'){
                        grid[i][j]='2';
                    }
                    if(grid[i-1][j]=='1'||grid[i][j-1]=='1'){
                        grid[i][j]='2';
                    }
                }
            }
        }
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if(grid[i][j]=='1'){
                    num++;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        char[][] nums = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        //char[][] nums = {{'1','0','1','1','0','1','1'}};
        System.out.println(new NumIslands().numIslands(nums));
    }
}
