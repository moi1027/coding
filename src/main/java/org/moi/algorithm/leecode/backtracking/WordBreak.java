package org.moi.algorithm.leecode.backtracking;

import java.util.*;

/**
 * @program:
 * @description: 139. 单词拆分 难度：medium
 * @author: moi
 * @create: 2021/1/17 22:42
 **/
public class WordBreak {


    /**
     * 题目：给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定?s 是否可以被空格拆分为一个或多个在字典中出现的单词。
     *
     * 说明：
     *
     * 拆分时可以重复使用字典中的单词。
     * 你可以假设字典中没有重复的单词。
     * 示例 1：
     *
     * 输入: s = "leetcode", wordDict = ["leet", "code"]
     * 输出: true
     * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
     * 示例 2：
     *
     * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
     * 输出: true
     * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     * ?    注意你可以重复使用字典中的单词。
     *
     *
     */


    /**
     * DFS的写法，使用递归有多个重复的子运算
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
     * 动态规划
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
