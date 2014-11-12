/**
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

Reference:
http://www.lifeincode.net/programming/leetcode-unique-binary-search-trees-i-and-ii-java/
In “Unique Binary Search Trees II”, we need to generate all trees.
The algorithm has the same idea. But we don’t just return the numbers.
We return the trees that n integers can from. Then we use a nested for-loop to
go through every possible combinations of left tree and right tree for a given root. We will do it recursively because it’s the same for the left tree and right tree of root.


Hide Tags Tree Dynamic Programming

 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public static List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }
    public static List<TreeNode> generate(int start, int end){
        List<TreeNode> result = new ArrayList<TreeNode>();
        /**
         * 防止当n = 0的情况。进入generate方法后，start = 0， end = 1；
         * 则不能运行下面的for 循环，则直接return 空集**/
        if (start > end){
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++){
            List<TreeNode> left = generate(start, i - 1);
            List<TreeNode> right = generate(i + 1, end);
            for (TreeNode l : left){
                for (TreeNode r : right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
