/**
 * Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 只要用prev解决不了NPE的话
 * 就用next和cur配合去解决，这样需要保证runner.next ！= null
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        
        ListNode runner = head;
        while (runner.next != null){
            if (runner.next.val == val){
                ListNode next = runner.next;
                runner.next = next.next;
            }else{
                runner = runner.next;
            }
        }
        return dummy.next;
    }
}
