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
        int nLandNums = 0;
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if(grid[i][j] == '1'){
                    infect(grid,i,j);
                    nLandNums++;
                }
            }
        }
        return nLandNums;
    }


    /**
     * ��Ⱦ����
     * @param nums
     * @param i
     * @param j
     */
    public void infect(char[][] nums,int i,int j){
        if(i<0||j<0||i>=nums.length||j>=nums[0].length||nums[i][j]!='1'){
            return;
        }
        nums[i][j] = '2';
        infect(nums,i-1,j);
        infect(nums,i+1,j);
        infect(nums,i,j-1);
        infect(nums,i,j+1);
    }

    public static void main(String[] args) {
        char[][] nums = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        //char[][] nums = {{'1','0','1','1','0','1','1'}};
        System.out.println(new NumIslands().numIslands(nums));
    }
}
