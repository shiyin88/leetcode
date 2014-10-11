/**
Sort a linked list in O(n log n) time using constant space complexity.

 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        /**
         * Below MERGE-SORT is for a linkedlist with at least two elements
         * */
        //1. find middle
        ListNode middle = findMiddle(head);
        //2.cut into half, and recursively sort two lists
        ListNode right = sortList(middle.next);
        middle.next = null;//ensure the first half list ends in the middle
        ListNode left = sortList(head);
        //3. merge two lists
        return merge(left, right);
    }
    //merge two sorted lists to one list
    public ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(0);
        ListNode runner = dummy;
        while(head1 != null && head2 != null){
            if (head1.val <= head2.val){
                runner.next = head1;
                head1 = head1.next;
            }else{
                runner.next = head2;
                head2 = head2.next;
            }
            runner = runner.next;
        }
        if (head1 != null){

            runner.next = head1;
        }
        if (head2 != null){

            runner.next = head2;
        }
        return dummy.next;
    }
    public ListNode findMiddle(ListNode head){

        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
