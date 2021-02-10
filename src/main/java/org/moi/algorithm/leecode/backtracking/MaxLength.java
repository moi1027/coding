package org.moi.algorithm.leecode.backtracking;

import javax.print.attribute.HashPrintJobAttributeSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program:
 * @description: 1239. �����ַ�������󳤶� �Ѷȣ�medium
 * @author: moi
 * @create: 2021/2/9 16:30
 **/
public class MaxLength {

    /**
     * ��Ŀ������һ���ַ������� arr���ַ��� s �ǽ� arr ĳһ�������ַ����������õ��ַ�������� s �е�ÿһ���ַ���ֻ���ֹ�һ�Σ���ô������һ�����н⡣
     *
     * �뷵�����п��н� s ������ȡ�
     *
     * ?
     *
     * ʾ�� 1��
     *
     * ���룺arr = ["un","iq","ue"]
     * �����4
     * ���ͣ����п��ܵĴ�������� "","un","iq","ue","uniq" �� "ique"����󳤶�Ϊ 4��
     *
     *
     */

    int res = 0;
    public int maxLength(List<String> arr) {
        backtrack(arr,0,new ArrayList<>());
        return res;
    }

    private void backtrack(List<String> arr,int index,List<String> selected){
        if(index == arr.size()){
            int len = 0;
            for (int i = 0; i < selected.size(); i++) {
                len += selected.get(i).length();
            }
            res = Math.max(res,len);
            return;
        }
        for (int i = index; i < arr.size(); i++) {
            if(isValid(selected,arr.get(i))){
                selected.add(arr.get(i));
                backtrack(arr,i+1,selected);
                selected.remove(arr.get(i));
            }else{
                continue;
            }
        }
    }

    private Boolean isValid(List<String> sb,String str){
        Map<Character,Integer> map = new HashMap<>(16);
        for (int i = 0; i < str.length(); i++) {
            if(map.containsKey(str.charAt(i))){
                return false;
            }
            map.put(str.charAt(i),1);
        }
        for (int i = 0; i < sb.size(); i++) {
            for (int j = 0; j < sb.get(i).length(); j++) {
                if(map.containsKey(sb.get(i).charAt(j))){
                    return false;
                }
            }
        }
        int len = 0;
        for (int i = 0; i < sb.size(); i++) {
            len += sb.get(i).length();
        }
        res = Math.max(res,len+str.length());
        return true;
    }

    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("jnfbyktlrqumowxd");
        arr.add("mvhgcpxnjzrdei");

        System.out.println(new MaxLength().maxLength(arr));
    }
}
