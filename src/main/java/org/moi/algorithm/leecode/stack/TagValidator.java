package org.moi.algorithm.leecode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @program:
 * @description: 标签验证器 leeCode 591 难度：hard
 * @author: moi
 * @create: 2020/12/17 22:10
 **/
public class TagValidator {

    /**
     * 题目：给定一个表示代码片段的字符串，你需要实现一个验证器来解析这段代码，并返回它是否合法。合法的代码片段需要遵守以下的所有规则：
     *
     * 代码必须被合法的闭合标签包围。否则，代码是无效的。
     * 闭合标签（不一定合法）要严格符合格式：<TAG_NAME>TAG_CONTENT</TAG_NAME>。其中，<TAG_NAME>是起始标签，</TAG_NAME>是结束标签。起始和结束标签中的 TAG_NAME 应当相同。当且仅当?TAG_NAME 和 TAG_CONTENT 都是合法的，闭合标签才是合法的。
     * 合法的?TAG_NAME?仅含有大写字母，长度在范围 [1,9] 之间。否则，该?TAG_NAME?是不合法的。
     * 合法的?TAG_CONTENT?可以包含其他合法的闭合标签，cdata?（请参考规则7）和任意字符（注意参考规则1）除了不匹配的<、不匹配的起始和结束标签、不匹配的或带有不合法 TAG_NAME 的闭合标签。否则，TAG_CONTENT?是不合法的。
     * 一个起始标签，如果没有具有相同?TAG_NAME 的结束标签与之匹配，是不合法的。反之亦然。不过，你也需要考虑标签嵌套的问题。
     * 一个<，如果你找不到一个后续的>与之匹配，是不合法的。并且当你找到一个<或</时，所有直到下一个>的前的字符，都应当被解析为?TAG_NAME（不一定合法）。
     * cdata 有如下格式：<![CDATA[CDATA_CONTENT]]>。CDATA_CONTENT?的范围被定义成?<![CDATA[?和后续的第一个?]]>之间的字符。
     * CDATA_CONTENT?可以包含任意字符。cdata 的功能是阻止验证器解析CDATA_CONTENT，所以即使其中有一些字符可以被解析为标签（无论合法还是不合法），也应该将它们视为常规字符。
     *
     * 思路：用栈解决
     */

    public static boolean isValid(String code) {
        Stack<String> stack = new Stack<>();
        Map<String,String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        if(code.charAt(0) != '<'){
            return false;
        }
        for(int i = 0;i<code.length();i++){
            char c = code.charAt(i);
            if(c == '<'){
                if(!sb.toString().contains("<![CDATA")) {
                    sb.delete(0, sb.length());
                }
                num = 0;
            }
            sb.append(c);
            num++;
            if(c == '>'){
                if(sb.charAt(0)!='<'){
                    continue;
                }
                if(num>9){
                    if(!sb.toString().contains("<![CDATA")){
                        return false;
                    }

                }

                String s = sb.toString();
                sb.delete(0,sb.length());
                if(!s.contains("<![CDATA")&&!s.contains("]]>")){
                    if(map.containsKey(s)||!stack.isEmpty()){
                        if(stack.peek().equals(map.get(s))) {
                            stack.pop();
                        }
                    }else {
                        for(int j = 1;j<sb.length()-1;j++){
                            if(sb.charAt(j)<'A'||sb.charAt(j)>'Z'){
                                return false;
                            }
                        }
                        map.put(s.substring(0, 1) + "/" + s.substring(1), s);
                        stack.push(s);
                    }
                }
                num = 0;
            }
        }
        return stack.isEmpty()&&map.size()>0;
    }

    public static void main(String[] args) {
        String code = "<TRUE><![CDATA[wahaha]]]><![CDATA[]> wahaha]]></TRUE>";
        System.out.println(isValid(code));
    }
}
