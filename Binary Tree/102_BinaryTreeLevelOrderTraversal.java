/**
*Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
*
*For example:
*Given binary tree {3,9,20,#,#,15,7},
*return [ [3], [9, 20], [15, 7] ]

此题是一个while循环,但是两个queue
一个queue代表了父节点的一行的数
另一个queue接收 (在遍历父节点的queue内的treenode后) 其queue里面Treenode的子节点们
两个queens不断替换,最后实现结果
*/
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
      // ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
      ArrayList<Integer> subarray = new ArrayList<Integer>();
      List<List<Integer>> allArrays = new ArrayList<List<Integer>>();
      Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
      Queue<TreeNode> queue2 = new LinkedList<TreeNode>();

      if (root == null){
        return allArrays;
      }

      queue1.add(root);

      while(!queue1.isEmpty()){
        TreeNode node = queue1.remove();
        subarray.add(node.val);

        if (node.left != null){
          queue2.add(node.left);
        }

        if (node.right != null){
            queue2.add(node.right);
        }
        if (queue1.isEmpty()){
          queue1 = queue2;
          queue2 = new LinkedList<TreeNode>();
          allArrays.add(subarray);
          subarray = new ArrayList<Integer>();
        }
      }

      return allArrays;
    }
}
