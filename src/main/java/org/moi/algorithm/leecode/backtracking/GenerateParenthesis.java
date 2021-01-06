package org.moi.algorithm.leecode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @description: 22. �������� �Ѷȣ� medium
 * @author: moi
 * @create: 2021/1/6 21:07
 **/
public class GenerateParenthesis {

    /**
     * ��Ŀ������ n?�����������ŵĶ������������һ�������������ܹ��������п��ܵĲ��� ��Ч�� ������ϡ�
     *
     * ?
     *
     * ʾ����
     *
     * ���룺n = 3
     * �����[
     *        "((()))",
     *        "(()())",
     *        "(())()",
     *        "()(())",
     *        "()()()"
     *      ]
     *
     * ˼·���û��ݵķ��������
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
        //������������()���Ⱥ�˳��
        if(right<left){
            sb.append(")");
            subGenerateParenthesis(res,sb,n,left,right+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
