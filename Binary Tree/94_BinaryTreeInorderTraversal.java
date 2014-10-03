/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //iteration
 //whenever we reach the left leaf node, add to the list
 //then add its right node
 //if no right node, then we pop the stack, add the node
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        if (root == null) return result;

        TreeNode node = root;
        while (node != null || !stack.empty()){
            if (node != null){
                stack.push(node);
                node = node.left;
            }else{
                TreeNode popped = stack.pop();
                result.add(popped.val);
                node = popped.right;
            }
        }
        return result;

    }
}


public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.peek();
          if (){
            if (cur.left != null){
              stack.push(cur.left);
            }else if (cur.right ! = null){
              stack.push(cur.right);
            }else if (cur.right == null && cur.left == null){
              result.add(stack.pop().val);
            }
          }else if (cur.)


            TreeNode pre = cur;
        }
    }
}
