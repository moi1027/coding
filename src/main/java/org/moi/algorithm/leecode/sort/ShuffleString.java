package org.moi.algorithm.leecode.sort;

import java.util.HashMap;
import java.util.Map;

/**
 * @program:
 * @description: leeCode �� 1528 �� ���������ַ��� �Ѷȣ�easy
 * @author: moi
 * @create: 2020/12/11 22:11
 **/
public class ShuffleString {

    /**
     * ��Ŀ������һ���ַ��� s ��һ�� ������ͬ ���������� indices ��
     *
     * �������������ַ��� s �����е� i ���ַ���Ҫ�ƶ��� indices[i] ָʾ��λ�á�
     *
     * �����������к���ַ�����
     *
     */

    public static String restoreString(String s, int[] indices) {
        StringBuffer sb = new StringBuffer();
        Map map =new HashMap();
        for(int i  = 0;i<indices.length;i++){
            map.put(indices[i],i);
        }
        for(int i = 0;i<indices.length;i++){
            sb.append(s.charAt((Integer) map.get(i)));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "codeleet";
        int[] arr = {4,5,6,7,0,2,1,3};
        restoreString(s,arr);
    }

}
