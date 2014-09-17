/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 Add all node to a queue and store sum value of each node to another queue.
 When it is a leaf node, check the stored sum value.

For example above, the queue would be: 5 - 4 - 8 - 11 - 13 - 4 - 7 - 2 - 1.
It will check node 13, 7, 2 and 1.

This is a typical breadth first search(BFS) problem.
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> counts = new LinkedList<Integer>();
        nodes.add(root);
        counts.add(root.val);

        while(!nodes.isEmpty()){
            TreeNode cur = nodes.remove();
            int val = counts.remove();

            if (cur.left == null && cur.right == null && val == sum){
                return true;
            }

            if (cur.left != null){
                nodes.add(cur.left);
                counts.add(val + cur.left.val);
            }

            if (cur.right != null){
                nodes.add(cur.right);
                counts.add(val + cur.right.val);
            }
        }
        return false;


    }
}
