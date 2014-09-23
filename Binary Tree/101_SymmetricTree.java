/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *Given a binary tree, check whether it is a mirror of itself
 *(ie, symmetric around its center).
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return isSymmetricChecker(root.left, root.right);
    }

    public boolean isSymmetricChecker(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return isSymmetricChecker(p.left, q.right) && isSymmetricChecker(p.right, q.left) && p.val == q.val;
    }

}
