/**
 *
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

Hide Tags Tree Array Depth-first Search

 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * Same with Construct Binary Tree from Postorder and Inorder Traversal
 * Root : preorder[pstart];
 * Inorder :    left : i - 1; right : i + 1
 * Preorder :   left : i - instart + pstart
 *              right : i - instart + pstart + 1
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int pstart, int pend, int[] inorder, int instart, int inend){
        if (pstart > pend || instart > inend){
            return null;
        }
        TreeNode root = new TreeNode(preorder[pstart]);
        int i = 0;
        for (i = 0; i < inorder.length; i++){
            if (inorder[i] == root.val){
                break;
            }
        }
        //root.left = myBuildTree(inorder, instart, position - 1,
                //preorder, prestart + 1, prestart + position - instart);
       // root.right = myBuildTree(inorder, position + 1, inend,
               // preorder, position - inend + preend + 1, preend);
        root.left = buildTree(preorder, pstart + 1, pstart + i - instart, inorder, instart, i - 1);
        root.right = buildTree(preorder, pstart + i - instart + 1, pend, inorder, i + 1, inend);
        return root;
    }
}
