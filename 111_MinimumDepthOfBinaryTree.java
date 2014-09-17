/**
* Use BFS to get the shortest path
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path
        from the root node down to the nearest leaf node.
*/
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        Queue<Integer> counts = new LinkedList<Integer>();

        nodes.add(root);
        counts.add(1);
        while (nodes != null){
            TreeNode temp = nodes.remove();
            int curCount = counts.remove();

            if (temp.left != null){
              nodes.add(temp.left);
              counts.add(curCount + 1);
            }

            if (temp.right != null){
              nodes.add(temp.right);
              counts.add(curCount + 1);
            }

            if (temp.right == null && temp.left == null){
              return curCount;
            }
        }
        return 0;
    }
}
