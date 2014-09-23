/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        return findMinDepth(root, 1);
    }

    public int findMinDepth(TreeNode root, int depth){
        if (root == null) return Integer.MAX_VALUE;

        if (root.left == null && root.right == null) return depth;

        return Math.min(findMinDepth(root.left, depth + 1), findMinDepth(root.right, depth + 1));
    }
}
