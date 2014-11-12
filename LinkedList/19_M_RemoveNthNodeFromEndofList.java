/**Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.

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
 * 思路：
 * 两个指针：一个是从头指到null
 *           另一个开始在第一个指针和现在指针差n步的时候开始移动
 * 保持两个指针始终是以差n步开始移动，指到nex指向了null
 * 此时，prev指向的为要删除的nth个node的前一个
 * 最后在while loop外面，删去prev下一个node，重组linkedlist
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;

        ListNode nex = head;
        ListNode prev = head;
        int counter = 0;
        while (nex.next != null){
            if (counter >= n){
                prev = prev.next;
            }
            nex = nex.next;
            counter++;
        }

        prev.next = prev.next.next;//当从while出去的时候，prev指向n的前一个node，所以跳过n，指向下一个

        return head.next;
    }
}
