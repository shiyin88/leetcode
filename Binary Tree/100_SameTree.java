/**
Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.


 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //在判断edge的时候，先判断&&然后||
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        //必须同时满足三个条件 才能保证true
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right) && p.val == q.val;
    }
}
 /**
         如果分开写，如此，不为true
         ex treenode(1) treenode(2);
         到达return的时候，两个node left 和 right 都为null 即会return true
         但是是false因为两个tree的value不等
         所以必须满足三个条件才可以
        if (p.val == q.val){
            return true;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);**/
