/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root
node down to the farthest leaf node.
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return maxDepthHelper(root, 1);
    }

    public int maxDepthHelper(TreeNode root, int depth){
        if (root == null) return 0;
        return Math.max(maxDepthHelper(root.left, depth), maxDepthHelper(root.right, depth)) + 1;
    }
}
