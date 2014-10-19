/**
Given a singly linked list where elements are sorted in ascending order,
convert it to a height balanced BST.
http://blog.csdn.net/fightforyourdream/article/details/16940205

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }

 这道题非常巧，通过recursion来build二叉树。 找到LinkedList中的中点，然后在建立树的时候，
 树的左子树为[head, middle]
 树的右子树为[middle, null]
 通过不断地循环，找到[root, mid] , [mid, tail] 的中点，接在root的left和right上
 1）新建一个traversal的方法，parameter为（ListNode head，ListNode tail）
 2)通过fast和slow runner来获得middle node
 3)通过recursion获得treenode的左子树和右子树
 4)termination: recursion的结点为head == tail
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {

        return traversal(head, null);
    }
    public TreeNode traversal (ListNode head, ListNode tail){
        //当遍历结束后，recursion的结点
        //由于traversal是遍历两段 前半段为[root,mid] 当不断的寻找中点，最终head和tail
        //同时指向head 以及后半段[mid, tail] 最终head和tail同时指向tail表面到了leaf
        if (head == tail){//tree leaf node
            return null;
        }
        //find mid-node
        ListNode fast = head.next;
        ListNode slow = head;//is middle point
        //由于前半段是不停的recursion root到mid mid为tail，而不是null为mid
        while(fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        //build tree
        TreeNode root = new TreeNode(slow.val);
        root.left = traversal(head, slow);
        root.right = traversal(slow.next, tail);
        return root;
    }

}
