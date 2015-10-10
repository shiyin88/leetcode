/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Hide Tags Tree Stack Design
Show Similar Problems

通过stack，在constructor内先把最做subtree存入stack内。
next() 方法返回当下最小的node，
必定是存储在当前stack内的首node。因为stack只存left subtree，
根据bst的定义，left肯定是最小的。即stack.pop()

然后遍历其当前pop节点的right subtree，由于我们只需要找next的
最小节点，所以每次push的时候，只需要push left subtree。

hasNext ： 只要通过判断stack是否是空，既可以判断是否当前有最小节点。
 */

public class BSTIterator {
    Stack<TreeNode> stack = null;
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        int value = node.val;
        if (node.right != null) {
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return value;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
