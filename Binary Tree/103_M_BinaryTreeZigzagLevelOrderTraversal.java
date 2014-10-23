/**
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }

 建Queue， 基本不变但是在把值放入list中的时候，引入变量k
 k % 2 == 0 则放入正序 --> list.add(val);
 k % 2 != 0 放入倒序 -->list.add(0, val);
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        queue.offer(root);
        int k = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> path = new ArrayList<Integer>();

            for (int i = 0; i < size; i++){
                TreeNode head = queue.poll();
                if (k % 2 == 0){
                    path.add(head.val);
                }else{
                    path.add(0, head.val);
                }
                if (head.left != null){
                    queue.offer(head.left);
                }
                if (head.right != null){
                    queue.offer(head.right);
                }
            }
            result.add(path);
            k++;
        }
        return result;

    }
}
