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
 * 1->2->3->3->4->4->5, return 1->2->5.
 * 1->1->1->2->3, return 2->3.
 *
 Note. To handle the first is duplicate element, we put another node ahead the head.
 Use three pointers. node points to first node which doesn't duplicate with other nodes
 Runner and Runner.next nodes to run through the list and find duplicates.
 If there is duplicates, then remove the duplicates and let node.next = runner.next;
 If there isn't; then we move node and runenr to their next nodes.
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode pre = new ListNode(0);
        pre.next = head;
        head = pre; //Note. To handle the first is duplicate element, we put another node ahead the head.
        boolean flag = false;

        ListNode node = head;// points to new ListNode(0), keep it there and not move. if we find the next nonduplicate node
        //then we can have node.next to point to next node
        ListNode runner = node.next;//points to next node, it is head node
        while (node.next != null){
            while (runner.next != null && runner.next.val == runner.val){//if node == prev, loop node until its value != prev
                runner = runner.next;
                flag = true;
            }
            if (flag){
                node.next = runner.next;
                runner = runner.next;
                flag = false;
            }else{
                node = node.next;
                runner = runner.next;
            }
        }
        return head.next;

    }
}
