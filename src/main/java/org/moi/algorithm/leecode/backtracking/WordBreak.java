package org.moi.algorithm.leecode.backtracking;

import java.util.*;

/**
 * @program:
 * @description: 139. ���ʲ�� �Ѷȣ�medium
 * @author: moi
 * @create: 2021/1/17 22:42
 **/
public class WordBreak {


    /**
     * ��Ŀ������һ���ǿ��ַ��� s ��һ�������ǿյ��ʵ��б� wordDict���ж�?s �Ƿ���Ա��ո���Ϊһ���������ֵ��г��ֵĵ��ʡ�
     *
     * ˵����
     *
     * ���ʱ�����ظ�ʹ���ֵ��еĵ��ʡ�
     * ����Լ����ֵ���û���ظ��ĵ��ʡ�
     * ʾ�� 1��
     *
     * ����: s = "leetcode", wordDict = ["leet", "code"]
     * ���: true
     * ����: ���� true ��Ϊ "leetcode" ���Ա���ֳ� "leet code"��
     * ʾ�� 2��
     *
     * ����: s = "applepenapple", wordDict = ["apple", "pen"]
     * ���: true
     * ����: ���� true ��Ϊ "applepenapple" ���Ա���ֳ� "apple pen apple"��
     * ?    ע��������ظ�ʹ���ֵ��еĵ��ʡ�
     *
     *
     */


    /**
     * DFS��д����ʹ�õݹ��ж���ظ���������
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak1(String s, List<String> wordDict) {
        Map<String,Boolean> map =new HashMap<>();
        for (String word:wordDict) {
            map.put(word,true);
        }
        return dfs(s,map);
    }

    public Boolean dfs(String s,Map map){
        if(s.length() == 0){
            return true;
        }
        Boolean res = false;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = i+1; j <=s.length(); j++) {
                if(map.containsKey(s.substring(i,j))){
                    res = dfs(s.substring(j),map);
                    if(res){
                        return res;
                    }
                }
                if(j == s.length()&&!map.containsKey(s.substring(i,j))){
                    return res;
                }
            }
        }
        return res;
    }


    /**
     * ��̬�滮
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak2(String s, List<String> wordDict) {
        Map<String,Boolean> map =new HashMap<>();
        for (String word:wordDict) {
            map.put(word,true);
        }
        Boolean[] dp = new Boolean[s.length()+1];
        Arrays.fill(dp,false);
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && map.containsKey(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
//        wordDict.add("sand");
//        wordDict.add("and");
//        wordDict.add("cat");
        System.out.println(new WordBreak().wordBreak2(s,wordDict));

    }
}
