package org.moi.algorithm.simple.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @description: µã¼¯
 * @author: moi
 * @create: 2021/1/9 18:31
 **/
public class Node {
    public int value;
    public int in;
    public int out;
    public List<Node> nexts;
    public List<Edge> edges;
    public Node(int value){
        this.value = value;
        this.in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
