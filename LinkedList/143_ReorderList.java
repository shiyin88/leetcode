/**
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.

 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * 1. find middle
 * 2. reverse the 2nd half of the linkedlist [middle + 1, end]
              *** two lists: 1) [head, mid]
                             2) [mid.next, head];
 * 3. merge : combine two lists into one
              use counter % 2 = (1 || 0)
              add the node to a new dummy node
 */
public class Solution {
    public static void reorderList(ListNode head) {
      //in the findMiddle method: fast != null && fast.next != null
      //so here we need to exclude conditions : head == null || head.next == null
        if (head == null || head.next == null){
            return;
        }
        ListNode middle = findMiddle(head);
        ListNode reversedHead = reverse(middle.next);
        middle.next = null;
        merge(head, reversedHead);
    }
    public static void merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(0);
        ListNode runner = dummy;
        int counter = 1;
        while(head1 != null && head2 != null){
            if (counter % 2 == 1){
            	runner.next = head1;
              head1 = head1.next;
            }else{
            	runner.next = head2;
              head2 = head2.next;
            }
            runner = runner.next;
            counter++;
        }
        //there are occasions like head1 & head2 don't heave equal nodes
        //e.x. five nodes in total head1: (1->2->3) head2: (4->5)
        if (head1 != null){
        	runner.next = head1;
        }
        if (head2 != null){
        	runner.next = head2;
        }
        dummy = dummy.next;
    }
    public static ListNode reverse(ListNode head){
        ListNode prev, cur, next;
        cur = head;
        prev = null;
        next = null;
        while (cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
        return head;
    }
    public static ListNode findMiddle(ListNode head){
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
