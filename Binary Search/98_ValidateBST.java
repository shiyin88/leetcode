/**
from http://www.programcreek.com/2012/12/leetcode-validate-binary-search-tree-java/
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.


 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 这道题通过一个wrapper class， 里面设两个变量，最大值和最小值，
 * 通过最大值和最小值表示left, right & root三者的关系
 * root.left.val < root.val < root.right.val
 * 所以 在返回值时要保证 (root.left, root, min) && (root.right, max, root.val)
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return validateBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    public boolean validateBST(TreeNode root, int max, int min){
        if (root == null){
            return true;
        }
        if (root.val <= min || root.val >= max){
            return false;
        }
        //比较left, right & root三者的关系
        //root.left.val < root.val -->最大值为root.val
        //root.right > root.val ---> 最小值为root.val
        return validateBST(root.left, root.val, min) && validateBST(root.right, max, root.val);
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
