package org.moi.algorithm.leecode.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @program:
 * @description: 752. ��ת���� �Ѷȣ�medium
 * @author: moi
 * @create: 2021/2/12 22:29
 **/
public class OpenLock {

    /**
     * ��Ŀ������һ�������ĸ�Բ�β��ֵ�ת������ÿ�����ֶ���10�����֣� '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' ��ÿ�����ֿ���������ת������� '9' ��Ϊ? '0'��'0' ��Ϊ '9' ��ÿ����ת��ֻ����תһ�����ֵ�һλ���֡�
     *
     * ���ĳ�ʼ����Ϊ '0000' ��һ�������ĸ����ֵ����ֵ��ַ�����
     *
     * �б� deadends ������һ���������֣�һ�����ֵ����ֺ��б�����κ�һ��Ԫ����ͬ����������ᱻ�����������޷��ٱ���ת��
     *
     * �ַ��� target ������Խ��������֣�����Ҫ������С����ת���������������β��ܽ��������� -1��
     *
     * ?
     *
     * ʾ�� 1:
     *
     * ���룺deadends = ["0201","0101","0102","1212","2002"], target = "0202"
     * �����6
     * ���ͣ�
     * ���ܵ��ƶ�����Ϊ "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"��
     * ע�� "0000" -> "0001" -> "0002" -> "0102" -> "0202" �����������ǲ��ܽ����ģ�
     * ��Ϊ�������� "0102" ʱ������ͻᱻ������
     *
     *
     * ��������BFS�����ҵ����·��
     *
     */

    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();
        for (String str : deadends){
            //�����е�����������뵽set��
            dead.add(str);
        }
        //��¼�Ѿ��߹���·
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        int step = 0;
        while(!queue.isEmpty()){
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                String cur = queue.poll();
                //������������
                if (dead.contains(cur)) {
                    continue;
                }
                if(cur.equals(target)){
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    String plus = plusOne(cur,j);
                    //�����Ѿ��߹���·
                    if(!visited.contains(plus)){
                        queue.offer(plus);
                        visited.add(plus);
                    }
                    String down = downOne(cur,j);
                    if(!visited.contains(down)){
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    /**
     * ���²�һ��
     * @param str
     * @param index
     * @return
     */
    public String plusOne(String str,int index){
        char[] ch = str.toCharArray();
        if(ch[index]=='9'){
            ch[index] = '0';
        }else{
            ch[index]+=1;
        }
        return new String(ch);
    }

    /**
     * ���ϲ�һ��
     * @param str
     * @param index
     * @return
     */
    public String downOne(String str,int index){
        char[] ch = str.toCharArray();
        if(ch[index]=='0'){
            ch[index] = '9';
        }else{
            ch[index]-=1;
        }
        return new String(ch);
    }
}
