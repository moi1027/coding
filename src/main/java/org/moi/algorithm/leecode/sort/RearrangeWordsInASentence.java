package org.moi.algorithm.leecode.sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @program:
 * @description: leeCode 1451 �������о����еĵ��� �Ѷȣ�medium
 * @author: moi
 * @create: 2020/12/17 21:34
 **/
public class RearrangeWordsInASentence {

    /**
     * ��Ŀ�������ӡ���һ���ÿո�ָ����ʵ��ַ���������һ������������ʽ�ľ��� text :
     *
     * ���ӵ�����ĸ��д
     * text �е�ÿ�����ʶ��õ����ո�ָ���
     * ������������ text �еĵ��ʣ�ʹ���е��ʰ��䳤�ȵ��������С�����������ʵĳ�����ͬ����������ԭ�����е����˳��
     *
     * ��ͬ����������ʽ�����µľ��ӡ�
     *
     * ˼·�����Զ�������
     */

    public static String arrangeWords(String text) {
        String[] texts = text.split(" ");
        Arrays.sort(texts, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        StringBuilder sb = new StringBuilder();
        texts[0] = texts[0].substring(0,1).toUpperCase()+texts[0].substring(1);
        for(int i = 0;i<texts.length;i++){
            if(i != 0){
                texts[i] = texts[i].substring(0,1).toLowerCase()+texts[i].substring(1);
            }
            sb.append(texts[i]);
            if(i+1 != texts.length){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String text = "Leetcode is cool";
        arrangeWords(text);
    }
}
