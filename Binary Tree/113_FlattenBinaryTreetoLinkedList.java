/**
 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
click to show hints.

Show Tags

 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 1) 第一种解法： -通过recursion来求preorder traversal的TreeNode，并且存在List中
 *                 -构建一个新树，并且left = null
 *                 -新树的head赋值给root
 * 2) 第二种解法： 更简便。通过递归。 基本解法和preorder traversal 相似。
 */
public class Solution {
    private static TreeNode lastVisit = null;
    public static void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        TreeNode savedRight = root.right;
        //initialize a new node, and fill the nodes from root
        if (lastVisit != null){
            lastVisit.left = null;//assign null to left
            lastVisit.right = root;//right will be filled with left child tree first
        }

        lastVisit = root;
        /**go to left first and fill it to lastVisit node's right tree
         * and save right child **/
        flatten(root.left);
        flatten(savedRight);
    }

}
//solution 1
public static void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        List<TreeNode> result = new ArrayList<TreeNode>();
        helper(root, result);
        TreeNode r = result.get(0);
        TreeNode head = r;
        int count = 1;
        while (count <= result.size()){
            r.left = null;
            r.right = result.get(count);
            count++;
            r = r.right;
        }
        root = head;
		/*2----
		 * TreeNode temp = null;
		build(root,temp);*/

    }
public static void helper(TreeNode root, List<TreeNode> result){
        if (root == null){
            return;
        }
       result.add(root);
       helper(root.left, result);
       helper(root.right, result);
}
