package org.moi.algorithm.leecode.sort;

/**
 * @program:
 * @description: 58. ���һ�����ʵĳ��� �y�ȣ�easy
 * @author: moi
 * @create: 2021/1/28 21:57
 **/
public class LengthOfLastWord {

    /**
     * �}Ŀ������һ����������Сд��ĸ�Ϳո�?' '?���ַ��� s�����������һ�����ʵĳ��ȡ�����ַ����������ҹ�����ʾ����ô���һ�����ʾ��������ֵĵ��ʡ�
     *
     * ������������һ�����ʣ��뷵�� 0?��
     *
     * ˵����һ��������ָ������ĸ��ɡ��������κοո��ַ��� ������ַ�����
     *
     * ?
     *
     * ʾ��:
     *
     * ����: "Hello World"
     * ���: 5
     *
     */

    public int lengthOfLastWord(String s) {
        s = s.trim();
        int len = s.length();
        if(len == 0){
            return 0;
        }
        int count = 0;
        for (int i = len-1; i >=0; i--) {
            if(s.charAt(i)>='a'&&s.charAt(i)<='z'){
                count++;
            }else if(s.charAt(i) == ' '){
                break;
            }else if(s.charAt(i)>='A'&&s.charAt(i)<='Z'){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "a ";
        System.out.println(new LengthOfLastWord().lengthOfLastWord(s));
    }
}
