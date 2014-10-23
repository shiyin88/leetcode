/**
Given inorder and postorder traversal of a tree, construct the binary tree.
Note:
You may assume that duplicates do not exist in the tree.
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 分析：1.如何根据树得中根与后根求树，简单说明一下：
（1）后根遍历的最后一个节点是该树的根；root : postorder[pend];
（2）在中根遍历中找到该节点，下标记为index，该节点将树左右分开
        在postorder的数组中找到root后，用forloop 遍历 inorder 数组，找到root所在的index i
        在inorder的数组中： A[i - 1] 为root的left ； A[i + 1] 为root的right
（3）后根遍历中［0,index-1]就是左子树的节点，[index,lenth-1]就是右子树的节点
        由于index i不是length，我们把它转化成length。root在instorder的数组中的位置为 ： i - instart
        root.left在postorder的位置为: pstart + (i - instart) - 1;
        root.right在postorder的位置为： pstart + (i - instart);
（4）分别对左子树和右子树进行递归求解
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int instart, int inend, int[] postorder, int pstart, int pend){
        if (instart > inend || pstart > pend){
            return null;
        }
        //find root from postorder : last node in the array
        TreeNode root = new TreeNode(postorder[pend]);
        int i = 0;//represent the index of root in the inorder array
        for (i = 0; i < inorder.length; i++){
            if (inorder[i] == root.val){
                break;
            }
        }
        //divide and conquer
        root.left = buildTree(inorder, instart, i - 1, postorder, pstart, pstart + i - (instart + 1));
        root.right = buildTree(inorder, i + 1, inend, postorder, pstart + i - instart, pend - 1);
        return root;
    }
}
