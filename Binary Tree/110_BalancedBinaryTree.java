/**Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as a binary tree
in which the depth of the two subtrees of every node never differ by more than 1.
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * A binary tree is balanced when the depth (from the root) of the left and
 right sub trees of every node differs by 1 or less
 http://www.algoqueue.com/algoqueue/default/view/8912896/check-binary-tree-balanced-or-not
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = height(root.left); //take left node as root, and get the height of left tree
        int right = height(root.right);//get the height of right tree
        if (Math.abs(left - right) >1){
            return false;
        }
            return isBalanced(root.left) && isBalanced(root.right);//ensure all the subtree's left and right subtrees no differs
            //by 1 or less
            //a tree has several subtrees and subnodes; gotta loop all the way down to
            //make sure left and right nodes are all balanced.
    }
    //get the height of the tree;
    public int height(TreeNode root){
        if (root == null) return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
