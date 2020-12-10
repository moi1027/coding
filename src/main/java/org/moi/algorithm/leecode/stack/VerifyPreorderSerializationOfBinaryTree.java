package org.moi.algorithm.leecode.stack;

/**
 * @program:
 * @description: leeCode ��֤��������ǰ�����л� ��331 �� �Ѷȣ� medium
 * @author: moi
 * @create: 2020/12/10 22:01
 **/
public class VerifyPreorderSerializationOfBinaryTree {

    /**
     * ��Ŀ�����л���������һ�ַ�����ʹ��ǰ�����������������һ���ǿսڵ�ʱ�����ǿ��Լ�¼������ڵ��ֵ���������һ���սڵ㣬���ǿ���ʹ��һ�����ֵ��¼������ #��
     *
     * ˼·:ÿ���Ϸ��Ľڵ㶼Ҫռ��һ����λ
     */

    public static boolean isValidSerialization(String preorder) {
        int slots = 1;
        for(int i = 0;i<preorder.length();i++){
            //Ϊ�˱���һ������Ҷ�ӽڵ��Ǹ���λ��
            if(preorder.charAt(i)==','){
                --slots;
                if(slots<0){
                    return false;
                }
                if(preorder.charAt(i-1) != '#'){
                    slots+=2;
                }

            }
        }
        slots = preorder.charAt(preorder.length()-1)=='#'?slots-1:slots+1;
        return slots == 0;
    }

    public static void main(String[] args) {
        String s = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        isValidSerialization(s);
    }
}
