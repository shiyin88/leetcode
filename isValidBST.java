/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 /**
 *
 Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Thoughts about This Problem

All values on the left sub tree must be less than root, and all values on the right sub tree must be greater than root.

from http://www.programcreek.com/2012/12/leetcode-validate-binary-search-tree-java/
*/
public class Solution {

    public boolean isValidBST(TreeNode root) {

        return validate(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public boolean validate(TreeNode root, int max, int min){
        if (root == null){
            return true;
        }

        if (root.val <= min || root.val >= max){
            return false;
        }

        return validate(root.left, root.val, min) && validate(root.right, max, root.val);
    }
}

//solution 2

public class Solution {
    int lastNodeVal = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }

        if(!isValidBST(root.left)){
            return false;
        }
        if (lastNodeVal >= root.val){
            return false;
        }
        lastNodeVal = root.val;
        if(!isValidBST(root.right)){
            return false;
        }
        return true;
    }
}
