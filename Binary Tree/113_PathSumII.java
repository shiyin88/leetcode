/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }

 Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]

DFS traversal and combination

if TreeNode {1, 2} and sum = 0;
after walk through the Tree to the leaf node when root.val == 2 --> sum = -3
As only when sum == 0; we put the value to arrayList result. so now we put nothing
to the result. So we go to if (root == null) return; return to result.
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();

        if (root == null) return result;
        helper(root, sum, result, path);
        return result;
    }

    private void helper(TreeNode root, int sum, List<List<Integer>> result, List<Integer> path){

        if (root == null) return;

        sum -= root.val;

        if (root.left == null && root.right == null){//find the leaf node
            if (sum == 0){
                path.add(root.val);
                result.add(new ArrayList(path));
                path.remove(path.size() - 1);//put a remove function is for
                //if we traversed left leaf node, we need to remove the left node and traverse to its
                //right node again as well
            }
            return;//but that is not ending, we have to return to the DFS, and keep searching
        }
        path.add(root.val);
        helper(root.left, sum, result, path);
        helper(root.right, sum, result, path);
        path.remove(path.size() - 1);

    }
}
