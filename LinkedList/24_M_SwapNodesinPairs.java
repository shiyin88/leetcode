/**
 * Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

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
 * 1. 新建一个dummy node来保存head node，防止丢失
 * 2. 通过count的值来判断是否需要置换。
 * 3. 常规置换只是一步步往下走
 * 4. 如果count % 2 == 0 表明需要把pre和cur置换
 *      1) 首先prev 和 cur的指针需要变化，由 prev - > cur 变换成 cur - > prev
 *      2) 置换后，cur变为这两个node的头，prev为尾，把这一串指针和剩下的linkedlist连起来。
 *          2-1 ： 链接尾部： prev.next = next;
 *          2-2 :  reservedPre 保留了上一步的prev，即为prev的前一个node
 *                 链接头部： reservedPre.next = cur
 *      3) 分别把prev，cur，和reservedPre移动到下一个node
 *         由于在做变换的时候，三个node的顺序发生了变换，cur变成了头，prev变成了尾。
 *         reservedPre移到下一个node即为cur: reservedPre = cur;
 *         pre指向的为尾，即不用移动
 *         cur指向next的值
 */
public class Solution {
    public static ListNode swapPairs(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;

        ListNode prev = dummy;
        ListNode cur = dummy.next;
        ListNode reservedPre = prev;
        int count = 1;
        while (cur != null){
            ListNode nex = cur.next;
            if (count % 2 == 0){
                cur.next = prev;
                prev.next = nex;
                reservedPre.next = cur;

                reservedPre = cur;
                cur = nex;

            }else{
            	reservedPre = prev;
                prev = cur;
                cur = nex;
            }
            count++;
        }
        return dummy.next;
    }
}
