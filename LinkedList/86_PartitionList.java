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
 * create two listNodes representing linkedlist that small and equal and greater than x
 * The example gives 2 -> 4 -> 3 so we can assume one node is smaller than the target, and the other is greater than target
 * As the question requires to preserve the original order of the list and in the example 3 is after 4
 * so the second node represents >= target
 *
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null){
            return null;
        }
        //create two dummy nodes
        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode left = leftDummy;
        ListNode right = rightDummy;

        while (head != null){
            if (head.val < x){
                left.next = head;
                left = left.next;
            }else{
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }

        //combine two linked-list to one
        right.next = null; // cuz right.next = head we append all the nodes in the list to right linkedlist
        left.next = rightDummy.next;
        return leftDummy.next;

    }
}
