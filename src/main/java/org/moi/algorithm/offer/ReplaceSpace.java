package org.moi.algorithm.offer;

/**
 * @program:
 * @description: ��ָoffer,�滻�ַ���
 * @author: moi
 * @create: 2021/3/6 22:16
 **/
public class ReplaceSpace {

    /**
     * ��Ŀ����ʵ��һ����������һ���ַ����е�ÿ���ո��滻�ɡ�%20�������磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
     */

    public String replaceSpace (String s) {
        // write code here
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)==' '){
                sb.append('%');
                sb.append('2');
                sb.append('0');
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
