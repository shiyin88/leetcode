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
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {

        return traversal(head, null);
    }
    public TreeNode traversal (ListNode head, ListNode tail){
        if (head == tail){//tree leaf node
            return null;
        }

        ListNode fast = head.next;
        ListNode slow = head;//is middle point
        while(fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = traversal(head, slow);
        root.right = traversal(slow.next, tail);
        return root;
    }

}
