/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode pre = head;
        ListNode node = pre.next;
        while (node != null){

            if (pre.val == node.val){
                pre.next = node.next;
                node = pre.next;
            }else{
                pre = pre.next;
                node = node.next;
            }
        }
        return head;
    }
}
