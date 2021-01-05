package org.moi.algorithm.leecode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program:
 * @description: 17. 电话号码的字母组合 难度： medium
 * @author: moi
 * @create: 2021/1/5 21:46
 **/
public class LetterCombinations {

    /**
     * 题目：给定一个仅包含数字?2-9?的字符串，返回所有它能表示的字母组合。
     *
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *
     *
     *
     * 示例:
     *
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     *
     * 思路：用回溯法来解决
     */


    /**
     * 回溯法要注意删除末尾数据的时机，删除再添加，删除再添加
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
