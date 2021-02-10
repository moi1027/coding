package org.moi.algorithm.leecode.backtracking;

import javax.print.attribute.HashPrintJobAttributeSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program:
 * @description: 1239. 串联字符串的最大长度 难度：medium
 * @author: moi
 * @create: 2021/2/9 16:30
 **/
public class MaxLength {

    /**
     * 题目：给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。
     *
     * 请返回所有可行解 s 中最长长度。
     *
     * ?
     *
     * 示例 1：
     *
     * 输入：arr = ["un","iq","ue"]
     * 输出：4
     * 解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和 "ique"，最大长度为 4。
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
