/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 题目十分巧妙。
 Inodrder 为先遍历直到 root.left = null 然后上跳回溯到root，
 然后向右走 {
            如果坐子树不为空 则继续遍历左子树
            root
            右子树
          }
在while loop内
 通过stack，不停地遍历左子树，加入stack
 当左子树 == null pop stack中的一个节点，放入list中
    然后给node赋值它的右子树。
 通过以上条件不停遍历，知道stack内的treenode全部取出来，或是node 为空
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
