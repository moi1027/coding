package org.moi.algorithm.leecode.sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @program:
 * @description: leeCode 1451 重新排列句子中的单词 难度：medium
 * @author: moi
 * @create: 2020/12/17 21:34
 **/
public class RearrangeWordsInASentence {

    /**
     * 题目：「句子」是一个用空格分隔单词的字符串。给你一个满足下述格式的句子 text :
     *
     * 句子的首字母大写
     * text 中的每个单词都用单个空格分隔。
     * 请你重新排列 text 中的单词，使所有单词按其长度的升序排列。如果两个单词的长度相同，则保留其在原句子中的相对顺序。
     *
     * 请同样按上述格式返回新的句子。
     *
     * 思路：用自定义排序
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
