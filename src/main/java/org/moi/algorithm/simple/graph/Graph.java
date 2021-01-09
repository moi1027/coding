package org.moi.algorithm.simple.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @program:
 * @description: 图
 * @author: moi
 * @create: 2021/1/9 20:41
 **/
public class Graph {
    public HashMap<Integer,Node> nodes;
    public HashSet<Edge> edges;
    public Graph(){
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
