/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
这道题和上道题不同的是,这道题要把输出的所有list要倒序排列
可以用add(0, value); 来完成,保证从queue poll出来的的数都放到index 0的位置上.
由于queue是先进先出,即先出去的value在放到list后,就会放到list中最后面
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
         List<List<Integer>> results = new ArrayList<List<Integer>>();

        if (root == null) return results;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<Integer>();
            for (int i = 0; i < size; i++){
                TreeNode head = queue.poll();
                level.add(head.val);
                if (head.left != null){
                    queue.offer(head.left);
                }
                if (head.right != null){
                    queue.offer(head.right);
                }
            }
            //Inserts the specified element at the specified position in this list (optional operation). Shifts the element                 //currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
            //here, whenever we add a new node, it will always put to the first place,and the rest shift to the right
            results.add(0, level);
        }
        return results;
    }
}
