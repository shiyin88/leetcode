/**
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

Hide Tags Linked List Two Pointers

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 *
 * 1. 把头和尾连起来，形成一个cyclist，并且记录有几个listNode
 * 2. 通过 n = length - n % length 记录剩余待走不走
 * 3. 走n步，确定头和尾，并且break cyclist
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || n == 0){
            return head;
        }
        ListNode p = head;
        int length = 1;
        while (p.next != null){
            p = p.next;
            length++;
        }
        p.next = head;
        n = length - n % length;
        while (n-- > 0){
            p = p.next;
        }
        head = p.next;
        p.next = null;
        return head;
    }
}
