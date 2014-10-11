/**
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?

 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * Use slow and fast runners. fast runner runs 2x faster than slow runner. When fast == slow, we can conclude the list has cycle
 * when the fast runner catches up the slow runner/
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }
}
