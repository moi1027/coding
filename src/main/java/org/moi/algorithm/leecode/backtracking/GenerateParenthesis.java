package org.moi.algorithm.leecode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @description: 22. 括号生成 难度： medium
 * @author: moi
 * @create: 2021/1/6 21:07
 **/
public class GenerateParenthesis {

    /**
     * 题目：数字 n?代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     *
     * ?
     *
     * 示例：
     *
     * 输入：n = 3
     * 输出：[
     *        "((()))",
     *        "(()())",
     *        "(())()",
     *        "()(())",
     *        "()()()"
     *      ]
     *
     * 思路：用回溯的方法来解决
     */

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        subGenerateParenthesis(res,new StringBuffer(),n,0,0);
        return res;
    }

    public void subGenerateParenthesis(List<String> res,StringBuffer sb,int n,int left,int right){
        if(sb.length()==2*n){
            res.add(sb.toString());
            return ;
        }
        if(left<n){
            sb.append("(");
            subGenerateParenthesis(res,sb,n,left+1,right);
            sb.deleteCharAt(sb.length()-1);
        }
        //这里用来控制()的先后顺序
        if(right<left){
            sb.append(")");
            subGenerateParenthesis(res,sb,n,left,right+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
