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
1)追赶问题：slow 追上fast 和LinkedListCycle I 做法一样
2）判断跳出的原因：cycle 或是 nullpointerException
3）追赶：找到collision point
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        //通过fast追上slow来找到第一个相遇点
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                break; //break the loop when they are in collision
            }
        }
        //after jumps out the first loop 这里我们需要检查第一个while loop终止是因为
        //没有cycle的list， 即fast指向了null 还是是因为fast追赶上了slow
        //如果是不是cycle的list我们只要check fast && fast.next是否为null
        //e.x 1->2 (fast.next.next == null) 1->2->3 (fast.next == null)
        //ERROR CHECK-if no meeting point, and therefore no loop
        //the condiditon is an opposite condition of the above while loop condition
        if (fast == null || fast.next == null){
            return null;
        }
        /**如果是个cyclist，即相差k我们只要匀速前进直到相遇就是第一个collision 点
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
