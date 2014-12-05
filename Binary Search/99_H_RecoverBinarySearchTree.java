/**
 * Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

Hide Tags Tree Depth-first Search

 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * reference : http://huntfor.iteye.com/blog/2077665
 * 通过两个pointer root和pre
 * 找到需要置换的两个元素，分别为first和second
 * 然后置换位置。
 *
 * 通过inorder traversal得出的node是ascending order的
 * 当pre(即前一步的root)和root分别不为null的时候，
 * 正常应该pre < root
 * 如果pre > root，分别pre设为first second设为root
 * 第一次遍历，我们确定了first的node，在之后的遍历我们要确立
 * second的遍历。但是为了防止之后的遍历，first的值不改变，我们只在
 * 第一次给first赋值，即first = null的时候。
 */
public class Solution {
    TreeNode pre = null, first = null, second = null;
    public void recoverTree(TreeNode root) {
        findNode(root);
        swap(first,second);
    }

    public void findNode(TreeNode root){
        if (root == null){
            return;
        }
        findNode(root.left);

        if (pre != null && pre.val > root.val){
            if (first == null){
                //为了保存第一次存下来的值。防止在存second的值时，
                //first也变化了
                first = pre;
            }
                second = root;
        }
        pre = root;
        findNode(root.right);
    }
    public void swap(TreeNode first, TreeNode second){
        //由于node有left和right。如果直接swap TreeNode会破坏它和左右的关系
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }
}
