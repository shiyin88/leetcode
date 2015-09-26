/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
Hide Tags Tree Dynamic Programming

这道题用dp做。
非常经典，用概率做。
假设 n = 2， 那么当root 为i的时候，
             左面则为 i - 1, 右面为 i + 1，则一共有(i - 1) * (i + 1)的解法
参考：http://www.lifeincode.net/programming/leetcode-unique-binary-search-trees-i-and-ii-java/
In “Unique Binary Search Trees”,
we are only required to output the number of the trees.
We know that all nodes in the left subtree are smaller than the root.
And all nodes in the right subtree are larger than the root.
For a integer n, we have n options to be the root.
In these options, assuming i is the value that we choose to be the root.
The value in left subtree are from 1 to i – 1,
and the values in right subtree are from i + 1 to n.
If 1 to i – 1 can form p different trees,
and i + 1 to n can form q different trees,
then we will have p * q trees when i is the root.
In fact, the number of different trees depends on how many number to form the tree.

We can use an array to save the number of different trees that n integers can form.
We fill the array from bottom to up, starting from 0 to n.
**/
public class Solution {
    public int numTrees(int n) {
        int[] result = new int[n + 1];
        //初始化，当n=0，即empty tree，一种BST形式。
        result[0] = 1;
        for (int i = 1; i <= n; i++){
            for (int k = 0; k < i; k++) {
                /**i表示以i为root所以能组成BST的可能形式。
                 * 由于左右结点的变换性，所以i需要累加得出当前i个数下
                 * 所有可能的BST
                 *      如果当前以k + 1为root，
                 *      k为k + 1的左边left node
                 *      i - k - 1为k + 1的right node
                 * */
                result[i] += result[k] * result[i - k - 1];
            }
        }
        return result[n];
    }
}
