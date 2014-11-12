/**
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.

Hide Tags Linked List

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * 分三步走
1. 找到m节点的前一个指针pre（加个safe guard可避免头指针的问题）
2. 从m节点开始往后reverse N个节点（双指针，cur，post）
3. 合并pre链表，cur链表及post链表。

这题难就难在繁琐上，要考虑各种边界条件，比如
{1,2,3}, 3,3
{1,2,3}, 1,1
{1,2,3}, 1,3
 */
public class Solution {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null){
            return null;
        }
        /**
         * create a dummy node for the edege cases
         **/
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;

        //找到m的前一个节点的node prev
        int count = 1;
        ListNode pre = dummy;
        while (count < m && pre.next != null){
            pre = pre.next;
            count++;
        }
        //cur为要置换的m node
        ListNode cur = pre.next;
        ListNode reservedCur = cur;//保存cur node为了置换位置用
        ListNode p1 = cur.next;//p1 is the node next to cur
        ListNode p2 = null;//p2 is the node next to p1
        while (count < n){
             p2 = p1.next;//keep p2
             p1.next = cur;//points p1.next backwards to cur
             cur = p1;//move to next node
             p1 = p2;//move to next node
             count++;
        }
        /**
         * 置换顺序**/
        pre.next = cur;//pre.next指向n节点，即cur指向的节点。
        reservedCur.next = p1;//reservedCur 指向的为m节点。指向p1
        return dummy.next;

    }

}
