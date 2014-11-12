/**Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
Hide Tags Depth-first Search Breadth-first Search Graph


 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 *
 * 这道题的大体思路是： 通过已知给的UndirectedGraphNode node，复制一个新的和它一样的node
 * UndirectedGraphNode 包含： linkedlist的neighbors 和 label
 *
 * Graph一般都会用BFS或是DFS。
 * 这里用BFS。BFS一般都会用Queue来做
 * 由于我们要找到graph上的每个node，并且建立他们的cloned node。由于此图是无向图，所以在找a ->b的时候
 * 也会通过b - > a
 * 所以避免重复寻找node，这里用map来记录一个node的邻居。所以a --> b; c -- > b这里在找a的邻居的时候，把b放进去了
 * 在下次找c的邻居的时候，就不会再放入b
 * 通过queue来把无重复的node一个个放进去。遍历queue来创建新的图
 *
 * 1. 通过遍历cur node的neighbor，创建当前节点的cloned neighbor
 * 2. 创建完cur的neighbor后，在根据已知的和neighbor的关系后，创立cloned cur
 * 和 cloned neighbor的关系
 * 3. 遍历queue中的每个节点。直到queue为空
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null){
            return null;
        }
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map =
                new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        //create a copied node, and copy the graph from starting with this node
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        queue.offer(node);
        //put the copied into map
        map.put(node, copy);

        while (!queue.isEmpty()){
            //cur is the original node (not copied)
            UndirectedGraphNode cur = queue.poll();
            for (int i = 0; i < cur.neighbors.size(); i++){
                //if we haven't put cur.neightbors into map, then put it into map
                //to check that to avoid put duplicates. ex. 1-->2 & 2 -->1
                //if we put 2 while checking 1. we don't need to put 2 again in next round
                UndirectedGraphNode neighbor = cur.neighbors.get(i);
                if (!map.containsKey(neighbor)){
                    /**1. copy node
                     * copy the neighboring node (only the node with label)**/
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    queue.offer(neighbor);
                }
                /**
                 * 2. copy neighbors
                        2-1 get the copied node from map
                        2-2 add COPIED NEIGHBORS (value we stored in the map) to the copied new node
                 **/
                 map.get(cur).neighbors.add(map.get(cur.neighbors.get(i)));
            }
        }
        return map.get(node);
    }
}
