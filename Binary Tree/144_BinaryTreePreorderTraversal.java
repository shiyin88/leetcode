/**Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?

 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**Stack
这道题通过用stack来完成preorder traversal
首先，list加入root.val
如果 right 和 left ！= null stack先后push right 和 left node
由于stack的特性是FIFO， 所以要想保住 root -> left -> right的特性，就要先push right
然后是left
*/
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();

        if (root == null){
            return result;
        }
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }
        return result;
    }
}
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        traverse(root, M_Reverse Linked List II
);
        return result;
    }

    public void traverse(TreeNode root, List<Integer> result){
       if (root == null){
           return;
       }
       /**
       即遵从preorder 的特性
       root -> left -> right
       当root == null的时候， 即我们已经从leaf node 走到了null，这时候要return
       返回上枝**/
       result.add(root.val);
       traverse(root.left, result);
       traverse(root.right, result);
    }
}

/**
divide and conquer
*/
public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // null or leaf
        if (root == null) {
            return result;
        }

        // Divide
        ArrayList<Integer> left = preorderTraversal(root.left);
        ArrayList<Integer> right = preorderTraversal(root.right);

        // Conquer
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        //Appends all of the elements in the specified collection to
        //the end of this list, in the order that they are returned by the specified collection's Iterator.
        return result;
    }
}
