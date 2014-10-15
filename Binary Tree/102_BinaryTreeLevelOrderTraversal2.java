/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }

 Time Complexity: O(n)
 Only use one queue to solve the probelm. minimized the space

 这道题用一个queue来完成题目要求.减少了空间复杂度,但是相应的提高了时间复杂度
 用了两个递归
 外层 while 保证queue不是空,即要保证遍历完queue里面的Treenode
 内层的for loop 是确保遍历完在每层的queue里面的Treenode
 即一层有两个Treenode, 当queue把他们的左子树和右子树放进去后,即4个,做操作加入到List内
 然后下一次通过for loop遍历queue里面的Treenode 当没poll一个的时候,再加入这个poll出去
 node的左右子点,放到queue的尾部
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> results = new ArrayList<List<Integer>>();

        if (root == null) return results;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();//不可以在下面的for loop里面直接i < queue.size
            //由于size是变化的,即使在i < 1 poll root后 但是在加完root的left和right后
            //queue的size又增加了
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
            results.add(level);
        }
        return results;
    }
}
