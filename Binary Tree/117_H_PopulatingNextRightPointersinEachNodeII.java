/**
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
Hide Tags Tree Depth-first Search

 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 * 同时维护两个指针：
 * root 和它的 next指针
 * 这道题是从右节点开始处理，在处理完右节点和next的关系后
 * 再处理左节点
 * 即先找到x节点的next 节点(是null或是left或是right)
 * 再和x链接。由于next节点是在右面，所以从右开始处理
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null){
            return;
        }

        TreeLinkNode p = root.next;//root的next节点
        /**
         * 当p.next != null的时候，把p顺次move到它的
         * 左或是右节点，为root的左右节点和p节点连接
         * 做准备
         **/
        while (p != null){
            if (p.left != null){
                p = p.left;
                break;
            }
            if (p.right != null){
                p = p.right;
                break;
            }
            /**
             * 如果p没有左右孩子，
             * 则root的左右树不会与p链接，
             * 找到p的next节点，继续搜索其左右孩子，使得p和其左右孩子链接
             * 如果找不到，则p为null，跳出while循环，使得其左或是右孩子
             * 与null链接**/
            p = p.next;
        }
        /**
         * 先检查root.right
         * 如果right有值，即把right和p链接**/
        if (root.right != null){
            root.right.next = p;
        }
        /**
         * 判断root.left
         * 的时候，要判断root.right是否有值，
         * 如果有，和left连接
         * 如果没有，和p连接**/
        if (root.left != null){
            root.left.next = root.right != null ? root.right : p;
        }
        connect(root.right);
        connect(root.left);


    }
}
