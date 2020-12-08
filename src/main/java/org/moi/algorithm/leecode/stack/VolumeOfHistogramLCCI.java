package org.moi.algorithm.leecode.stack;

import java.util.Stack;

/**
 * @program:
 * @description: ������ 17.21 ֱ��ͼ��ˮ��  �Ѷȣ�hard
 * @author: moi
 * @create: 2020/12/8 22:15
 **/
public class VolumeOfHistogramLCCI {
    /**
     * ��Ŀ������һ��ֱ��ͼ(Ҳ����״ͼ)���������˴�����ԴԴ���ϵص�ˮ�����ֱ��ͼ�ܴ����ˮ��?ֱ��ͼ�Ŀ��Ϊ 1��
     *
     * ˼·���õ���ջ�������Ϊ����ˮ����
     */

    /**
     * �ڲ���һ������ջ���ڲ����������ջ�ǵ�ÿ��Ԫ�ض��ǵݼ��ģ�������ֱ�ջ��Ԫ�ش��Ԫ�أ����ջֱ��ջ��Ԫ�ش��ڼ�����ջ��Ԫ��
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        if(height.length<3){
            return 0;
        }
        int water = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<height.length;i++){
            while(!stack.isEmpty()&&height[i]>height[stack.peek()]){
                int popnum = stack.pop();
                while(!stack.isEmpty()&& height[stack.peek()]==height[popnum]){
                    stack.pop();
                }
                if(!stack.isEmpty()){
                    int tmp = height[stack.peek()];
                    int h = Math.min(tmp-height[popnum],height[i] - height[popnum]);
                    int w = i-stack.peek()-1;
                    water+=h*w;
                }
            }
            stack.push(i);
        }
        return water;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(arr));
    }
}
