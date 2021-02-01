package org.moi.algorithm.leecode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @program:
 * @description: 394. �ַ������� �Ѷȣ�medium
 * @author: moi
 * @create: 2021/2/1 10:29
 **/
public class DecodeString {


    /**
     * ��Ŀ������һ������������ַ������������������ַ�����
     *
     * �������Ϊ: k[encoded_string]����ʾ���з������ڲ��� encoded_string �����ظ� k �Ρ�ע�� k ��֤Ϊ��������
     *
     * �������Ϊ�����ַ���������Ч�ģ������ַ�����û�ж���Ŀո�������ķ��������Ƿ��ϸ�ʽҪ��ġ�
     *
     * ���⣬�������Ϊԭʼ���ݲ��������֣����е�����ֻ��ʾ�ظ��Ĵ��� k �����粻�������?3a?��?2[4]?�����롣
     *
     * ?
     *
     * ʾ�� 1��
     *
     * ���룺s = "3[a]2[bc]"
     * �����"aaabcbc"
     * ʾ�� 2��
     *
     * ���룺s = "3[a2[c]]"
     * �����"accaccacc"
     *
     *
     */

    public String decodeString(String s) {
        StringBuffer sb = new StringBuffer();
        Stack<Integer> mulitStack = new Stack<>();
        Stack<StringBuffer> stringBufferStack = new Stack<>();
        int num = 0;
        for(Character c:s.toCharArray()){
            if(Character.isDigit(c)){
                //��ȡǰ������֣������Ǽ�λ��
                num = num*10+c-'0';
            }else if(c == '['){
                stringBufferStack.add(sb);
                mulitStack.add(num);
                num = 0;
                sb = new StringBuffer();
            }else if(Character.isAlphabetic(c)){
                sb.append(c);
            }else{
                StringBuffer tmp = stringBufferStack.pop();
                Integer tmpNum = mulitStack.pop();
                for (int i = 0; i < tmpNum; i++) {
                    tmp.append(sb);
                }
                sb = tmp;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "100[leetcode]";
        System.out.println(new DecodeString().decodeString(s));
    }
}
