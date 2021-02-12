package org.moi.algorithm.leecode.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @program:
 * @description: 752. 打开转盘锁 难度：medium
 * @author: moi
 * @create: 2021/2/12 22:29
 **/
public class OpenLock {

    /**
     * 题目：你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为? '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
     *
     * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
     *
     * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
     *
     * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
     *
     * ?
     *
     * 示例 1:
     *
     * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
     * 输出：6
     * 解释：
     * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
     * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
     * 因为当拨动到 "0102" 时这个锁就会被锁定。
     *
     *
     * 做法：用BFS做，找到最短路径
     *
     */

    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();
        for (String str : deadends){
            //将所有的死亡密码加入到set中
            dead.add(str);
        }
        //记录已经走过的路
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        int step = 0;
        while(!queue.isEmpty()){
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                String cur = queue.poll();
                //跳过死亡密码
                if (dead.contains(cur)) {
                    continue;
                }
                if(cur.equals(target)){
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    String plus = plusOne(cur,j);
                    //跳过已经走过的路
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
     * 往下拨一次
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
     * 往上拨一次
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
