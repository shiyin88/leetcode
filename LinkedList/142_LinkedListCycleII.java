/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Follow up:
Can you solve it without using extra space?
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                break; //break the loop when they are in collision
            }
        }
        //after jumps out the first loop
        //we need to check if the loop ends is because of the null pointer exception (NO CYCLE) or because of collision
        //ERROR CHECK-if no meeting point, and therefore no loop
        //the condiditon is an opposite condition of the above while loop condition
        if (fast == null || fast.next == null){
            return null;
        }
        /**
         * Move slow to Head(or discard fast, just let head and slow run K steps). Keep fast at Meeting point.
         * Each are k steps from the loop start. If they move at the same pace, they must meet at loop start*/
        //slow = head;
        while(head != slow){//fast != slow
            head = head.next; //fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
