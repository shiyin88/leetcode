/**

 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.

 use array to hold the sum value is becasue Java can only pass by value. for example

 int a=1;
 void calculate(int a){
    a=a+1;
 }

 System.out.println(a); // the result is still 1 , not 2

 So,in order to track sum value of each calculation and not return the value of sum, we should use a collection
 or a wrapper class to hold it
 */
public class Solution {
    public static int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        int sum[] = {0};
        List<Integer> path = new ArrayList<Integer>();
        helper (root, path, sum);
        return sum[0];
    }
    public static void helper (TreeNode root, List<Integer> path, int[] sum){
        if (root == null){
        	return;
        }
        if (root.left == null && root.right == null){

            path.add(root.val);
            sum[0] = sum[0] + getValue(path);
            path.remove(path.size() - 1);
            return;
        }
        path.add(root.val);
        helper(root.left, path, sum);
        helper(root.right, path, sum);
        path.remove(path.size() - 1);

    }

    public static int getValue(List<Integer> path){
        int value = 0;
        for (int i = 0; i < path.size(); i++){
            value = 10 * value + path.get(i);
        }
        return value;
    }
}
