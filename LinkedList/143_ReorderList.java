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
 * 1. find middle
 * 2. reverse the 2nd half of the linkedlist [middle + 1, end]
 * 3. merge : combine two lists into one
              use counter % 2 = (1 || 0)
              add the node to a new dummy node
 */
public class Solution {
    public static void reorderList(ListNode head) {
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
