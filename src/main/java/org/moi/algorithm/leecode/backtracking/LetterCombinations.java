package org.moi.algorithm.leecode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program:
 * @description: 17. �绰�������ĸ��� �Ѷȣ� medium
 * @author: moi
 * @create: 2021/1/5 21:46
 **/
public class LetterCombinations {

    /**
     * ��Ŀ������һ������������?2-9?���ַ����������������ܱ�ʾ����ĸ��ϡ�
     *
     * �������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1 ����Ӧ�κ���ĸ��
     *
     *
     *
     * ʾ��:
     *
     * ���룺"23"
     * �����["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     *
     * ˼·���û��ݷ������
     */


    /**
     * ���ݷ�Ҫע��ɾ��ĩβ���ݵ�ʱ����ɾ������ӣ�ɾ�������
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0){
            return res;
        }
        Map<Character,String> map = new HashMap<Character,String>(){{
            put('2',"abc");
            put('3',"def");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");
        }};
        subLetterCombinations(res,map,digits,0,new StringBuffer());
        return res;
    }

    public void subLetterCombinations(List<String> res,Map map,String digits,int index,StringBuffer sb){
        if(digits.length()==index){
            res.add(sb.toString());
            return;
        }
        String buttonWords = (String) map.get(digits.charAt(index));
        for (int i = 0; i < buttonWords.length(); i++) {
            sb.append(buttonWords.charAt(i));
            subLetterCombinations(res,map,digits,index+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        new LetterCombinations().letterCombinations("23");
    }
}
