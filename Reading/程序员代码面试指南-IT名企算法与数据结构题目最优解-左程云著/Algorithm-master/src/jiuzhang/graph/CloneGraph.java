package jiuzhang.graph;

/**
 * Created by Dell on 2017-08-21.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class CloneGraph {
    //无向图节点
    class UndirectedGraphNode {
      int label;
      ArrayList<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
  };

    /**
     * 克隆图，图包括该节点本身的值，该节点所有的邻居节点
     * @param node
     * @return
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        LinkedList<UndirectedGraphNode> queue=new LinkedList<>();
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map=new HashMap<>();
        //先复制第一个节点
        queue.add(node);
        map.put(node,new UndirectedGraphNode(node.label));
        while(!queue.isEmpty()){
            UndirectedGraphNode old=queue.poll();
            for(int i=0;i<old.neighbors.size();i++){
                if(!map.containsKey(old.neighbors.get(i))){
                    map.put(old.neighbors.get(i),new UndirectedGraphNode(old.neighbors.get(i).label));
                    queue.add(old.neighbors.get(i));
                }
                map.get(old).neighbors.add(map.get(old.neighbors.get(i)));
            }
        }
        return map.get(node);
    }
    /**
     * 使用宽度优先搜索，像克隆复杂链表一样克隆
     * 分两步，克隆点，克隆边
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph1(UndirectedGraphNode node) {
        if(node==null)
            return null;
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();//保存的是遍历过的节点，和copy的节点
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(node,copy);
        queue.offer(node);
        while(!queue.isEmpty())
        {
            UndirectedGraphNode cur = queue.poll();
            for(int i=0;i<cur.neighbors.size();i++)
            {//复制所有的节点，将复制过的保存到map和queue中
                if(!map.containsKey(cur.neighbors.get(i)))
                {//map复制的是节点
                    copy = new UndirectedGraphNode(cur.neighbors.get(i).label);
                    map.put(cur.neighbors.get(i),copy);
                    queue.offer(cur.neighbors.get(i));
                }
                map.get(cur).neighbors.add(map.get(cur.neighbors.get(i)));//复制的是边
            }
        }
        return map.get(node);
    }
}
