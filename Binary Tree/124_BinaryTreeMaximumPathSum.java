/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.

 */
public class Solution {

    int max;

    public int maxPathSum(TreeNode root) {
        max = (root == null) ? 0 : root.val;
        findMax(root);
        return max;
    }

    public int findMax(TreeNode root){
        if (root == null){
            return 0;
        }
        //divide
        int left = Math.max(findMax(root.left), 0);
        int right = Math.max(findMax(root.right), 0);

        //conquer
        //get the current max
        max = Math.max(max, left + right + root.val);

        //find the sum of largest path of current node
        return root.val + Math.max(left, right);
    }
}
