package org.moi.algorithm.leecode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @program:
 * @description: ��ǩ��֤�� leeCode 591 �Ѷȣ�hard
 * @author: moi
 * @create: 2020/12/17 22:10
 **/
public class TagValidator {

    /**
     * ��Ŀ������һ����ʾ����Ƭ�ε��ַ���������Ҫʵ��һ����֤����������δ��룬���������Ƿ�Ϸ����Ϸ��Ĵ���Ƭ����Ҫ�������µ����й���
     *
     * ������뱻�Ϸ��ıպϱ�ǩ��Χ�����򣬴�������Ч�ġ�
     * �պϱ�ǩ����һ���Ϸ���Ҫ�ϸ���ϸ�ʽ��<TAG_NAME>TAG_CONTENT</TAG_NAME>�����У�<TAG_NAME>����ʼ��ǩ��</TAG_NAME>�ǽ�����ǩ����ʼ�ͽ�����ǩ�е� TAG_NAME Ӧ����ͬ�����ҽ���?TAG_NAME �� TAG_CONTENT ���ǺϷ��ģ��պϱ�ǩ���ǺϷ��ġ�
     * �Ϸ���?TAG_NAME?�����д�д��ĸ�������ڷ�Χ [1,9] ֮�䡣���򣬸�?TAG_NAME?�ǲ��Ϸ��ġ�
     * �Ϸ���?TAG_CONTENT?���԰��������Ϸ��ıպϱ�ǩ��cdata?����ο�����7���������ַ���ע��ο�����1�����˲�ƥ���<����ƥ�����ʼ�ͽ�����ǩ����ƥ��Ļ���в��Ϸ� TAG_NAME �ıպϱ�ǩ������TAG_CONTENT?�ǲ��Ϸ��ġ�
     * һ����ʼ��ǩ�����û�о�����ͬ?TAG_NAME �Ľ�����ǩ��֮ƥ�䣬�ǲ��Ϸ��ġ���֮��Ȼ����������Ҳ��Ҫ���Ǳ�ǩǶ�׵����⡣
     * һ��<��������Ҳ���һ��������>��֮ƥ�䣬�ǲ��Ϸ��ġ����ҵ����ҵ�һ��<��</ʱ������ֱ����һ��>��ǰ���ַ�����Ӧ��������Ϊ?TAG_NAME����һ���Ϸ�����
     * cdata �����¸�ʽ��<![CDATA[CDATA_CONTENT]]>��CDATA_CONTENT?�ķ�Χ�������?<![CDATA[?�ͺ����ĵ�һ��?]]>֮����ַ���
     * CDATA_CONTENT?���԰��������ַ���cdata �Ĺ�������ֹ��֤������CDATA_CONTENT�����Լ�ʹ������һЩ�ַ����Ա�����Ϊ��ǩ�����ۺϷ����ǲ��Ϸ�����ҲӦ�ý�������Ϊ�����ַ���
     *
     * ˼·����ջ���
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
