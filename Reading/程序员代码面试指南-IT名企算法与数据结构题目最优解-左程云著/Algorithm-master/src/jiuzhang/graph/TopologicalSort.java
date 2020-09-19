package jiuzhang.graph;

import java.util.*;

/**
 * Created by Dell on 2017-08-23.
 */
public class TopologicalSort {
    class DirectedGraphNode {
      int label;
      ArrayList<DirectedGraphNode> neighbors;
      DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
    };
    /**
     * 图的拓扑排序，将所有点的入度记到map中，入度为0的点拓扑顺序最小
     */

    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        //记录所有点的入度
        ArrayList<DirectedGraphNode> res=new ArrayList<>();
        HashMap<DirectedGraphNode,Integer> map=new HashMap<>();
        for(int i=0;i<graph.size();i++){
            for(int j=0;j<graph.get(i).neighbors.size();j++){
                if(map.containsKey(graph.get(i).neighbors.get(j))){
                   map.put(graph.get(i).neighbors.get(j),map.get(graph.get(i).neighbors.get(j))+1);
                }else{
                    map.put(graph.get(i).neighbors.get(j),1);
                }
            }
        }
        //q是待遍历的队列
        Queue<DirectedGraphNode> q=new LinkedList<>();
        //将未与图产生联系的节点加入q中
        for(DirectedGraphNode node:graph){
            if(!map.containsKey(node)){
                res.add(node);
                q.add(node);
            }
        }
        while (!q.isEmpty()){
            DirectedGraphNode node=q.poll();
            for (DirectedGraphNode n:node.neighbors){
                map.put(n,map.get(n)-1);
                if(map.get(n)==0){
                    q.offer(n);
                }
            }
        }
        return res;

    }

}
