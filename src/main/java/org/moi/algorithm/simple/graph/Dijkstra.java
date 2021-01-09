package org.moi.algorithm.simple.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @program:
 * @description: �Ͻ�˹�����㷨
 * @author: moi
 * @create: 2021/1/9 21:01
 **/
public class Dijkstra {

    /**
     * ������Ҫָ�������㣬���յó������㵽���нڵ����̾���
     *      ǰ������Ҫ��ڵ�ߵ�Ȩֵ��Ϊ�Ǹ���
     */

    /**
     * ����ʵ�ְ� ��hashMap �� set ������ʵ��
     */
    public static Map<Node,Integer> dijkstra1(Node from){
        HashMap<Node,Integer> distanceMap = new HashMap<>();
        distanceMap.put(from,0);
        HashSet<Node> selectedNodes = new HashSet<>();
        Node minNode = getMinDistanceAndUnselected(distanceMap,selectedNodes);
        while(minNode !=null){
            int distance = distanceMap.get(minNode);
            for(Edge edge:minNode.edges){
                Node toNode = edge.to;
                if(!distanceMap.containsKey(toNode)){
                    distanceMap.put(toNode,distance+edge.weight);
                }else{
                    distanceMap.put(toNode,Math.min(distanceMap.get(toNode),distance+edge.weight));
                }
            }
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnselected(distanceMap,selectedNodes);
        }
        return distanceMap;
    }

    public static Node getMinDistanceAndUnselected(HashMap<Node,Integer> distanceMap,HashSet<Node> selectdNodes){
        int MinDistance = Integer.MAX_VALUE;
        Node MinNode = null;
        for(Map.Entry<Node,Integer> entry:distanceMap.entrySet()){
            int distance = entry.getValue();
            Node node = entry.getKey();
            if(!selectdNodes.contains(node) && distance<MinDistance){
                MinNode = node;
                MinDistance = distance;
            }
        }
        return MinNode;
    }
}
