/**
 * Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        Queue<TreeNode> node = new LinkedList<TreeNode>();
        node.offer(root);
        int n = 0;
        while (!node.isEmpty()) {
            //通过用queue来保存节点
            TreeNode cur = node.poll();
            if (cur.left != null) {
                node.offer(cur.left);
            }
            if (cur.right != null) {
                node.offer(cur.right);
            }
            //通过此处，置换entire sub left 和 right tree
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
        }
        return root;
    }
}
