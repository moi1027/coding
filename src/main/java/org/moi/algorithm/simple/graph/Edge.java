package org.moi.algorithm.simple.graph;

/**
 * @program:
 * @description: ±ß¼¯
 * @author: moi
 * @create: 2021/1/9 18:31
 **/
public class Edge {
    public Node form;
    public Node to;
    public int weight;
    public Edge(Node f,Node t,int value){
        form = f;
        to = t;
        weight = value;
    }
}
