/**
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 此题是 用Recursion
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        if (root.left == null && root.right == null){
            if (root.val == sum){
                return true;
            }
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);


    }
}

/**用两个queue
 * 一个记录节点，另一个记录从root到当前node的sum value
 * exit 状态为：如果当前node所对应的value = sum 则为true
 * 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
       if (root == null) return false;
       
       Queue<TreeNode> q = new LinkedList<TreeNode>();
       Queue<Integer> values = new LinkedList<Integer>();
       q.offer(root);
       values.offer(root.val);
       
       while (!q.isEmpty()) {
           TreeNode node = q.poll();
           int val = values.poll();
           if (node.left == null && node.right == null && val == sum) {
               return true;
           }
           
           if (node.left != null) {
               q.offer(node.left);
               values.offer(val + node.left.val);
           }
           if (node.right != null) {
               q.offer(node.right);
               values.offer(val + node.right.val);
           }
       }
       return false;
    }
    
}
