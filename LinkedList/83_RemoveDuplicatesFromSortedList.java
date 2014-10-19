/**
Given a sorted linked list, delete all duplicates such that each element appear
only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
       ListNode runner = head;
        while (runner != null && runner.next != null){
            if (runner.val == runner.next.val){
                runner.next = runner.next.next;
            }else{
                runner = runner.next;
            }
        }
        return head;
    }
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode runner = head;
        while(runner!= null && runner.next != null){
            ListNode next = runner.next;
            if (runner.val == next.val){
                next = next.next;
                runner.next = next;
            }else{
                runner.next = next;
                runner = next;
                next = next.next;
            }
        }
        return head;
    }
}
