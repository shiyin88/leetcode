/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //recursion
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null){
            return result;
        }

        TreeNode prev = null;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.peek();

            // go down the tree.
            //check if current node is leaf, if so, process it and pop stack,
            //otherwise, keep going down
            if (prev == null || prev.left == cur || prev.right == cur){//tracking down
                if (cur.left != null){
                    stack.push(cur.left);
                }else if (cur.right != null){
                    stack.push(cur.right);
                }else{
                    stack.pop();
                    result.add(cur.val);
                }
            ////go up the tree from left node
            //need to check if there is a right child
            //if yes, push it to stack
            //otherwise, process parent and pop stack
            }else if (cur.left == prev){
                if (cur.right != null){
                    stack.push(cur.right);
                }else{
                    stack.pop();
                    result.add(cur.val);
                }
            //go up the tree from right node 
            //after coming back from right node, process parent node and pop stack.
            }else if (cur.right == prev){
                stack.pop();
                result.add(cur.val);
            }
            prev = cur;
        }

        return result;
    }
}

//recursion
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        postorderTraversal_helper(root, result);
        return result;

    }

    public void postorderTraversal_helper(TreeNode root, List<Integer> result){
        if (root == null){
            return;
        }

        postorderTraversal_helper(root.left, result);
        postorderTraversal_helper(root.right, result);
        result.add(root.val);
    }
}

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //divide and conquer
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        if (root == null){
            return result;
        }
        //divide
        List<Integer> left = postorderTraversal(root.left);
        List<Integer> right = postorderTraversal(root.right);
        //conquer
        result.addAll(left);
        result.addAll(right);
        result.add(root.val);
        return result;
    }
}
