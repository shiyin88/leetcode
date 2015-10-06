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
 *              
 * 
 * in-order:   4 2 5 (1) 6 7 3 8
   pre-order: (1) 2 4 5  3 7 6 8
   由于preorder是先traverse root， 所以preorder中第一个数为root，即1为root
   然后我们iterate in-order的数列，找到root在inorder中所在的index i
   (**通过root所在的index，我们知道BST的左支点共有i - 1个index的叶子，右支点共有i+1个index的叶子)
   在新建的binary tree中，我们可知，inorder.left = root的左半部分的index, 即 [0, i - 1]
                                    inorder.right = root的右半部分, 即 [i + 1, inorder.length - 1]
    preorder 的left为: [pstart + 1, pstart + i - istart]
    preorder 的right为: [pstart + i - istart + 1, pend]
                                    
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
