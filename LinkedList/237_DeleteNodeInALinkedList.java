/**
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.

Show Tags
Show Similar Problems

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void deleteNode(ListNode node) {
        //把next的值copy到当前待删节点node上，即完成当前节点的删除
        node.val = node.next.val;
        //但是此时node和node.next的值相同，即把node的next的值指向node.next.next
        //skip node.next
        node.next = node.next.next;
    }
}
