package org.moi.algorithm.leecode.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program:
 * @description: leeCode 剑指offer 59题 队列的最大值 难度： medium
 * @author: moi
 * @create: 2020/11/28 23:45
 **/
public class QueueBigger {
    Queue<Integer> q;
    Deque<Integer> d;

    public QueueBigger() {
        q = new LinkedList<Integer>();
        d = new LinkedList<Integer>();
    }

    public int max_value() {
        if (d.isEmpty()) {
            return -1;
        }
        return d.peekFirst();
    }

    public void push_back(int value) {
        while (!d.isEmpty() && d.peekLast() < value) {
            d.pollLast();
        }
        d.offerLast(value);
        q.offer(value);
    }

    public int pop_front() {
        if (q.isEmpty()) {
            return -1;
        }
        int ans = q.poll();
        if (ans == d.peekFirst()) {
            d.pollFirst();
        }
        return ans;
    }

}

