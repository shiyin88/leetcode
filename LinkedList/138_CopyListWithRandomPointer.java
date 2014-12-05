/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
reference : http://blog.csdn.net/linhuanmars/article/details/22463599

Hide Tags Hash Table Linked List

 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 * 1. clone一个LinkedList，但是只copy了ListNode和next指针
 * 2. clone它的random指针
 *      2-1 在copylistNode的时候，新建一个hashMap，key为老的node，value为新的node
 *      2-2 在copy完newList后，循环head和copiedHead，通过head.random得出老的node的random node指针
 *      2-3 通过map.get(head.random) 得出其random指针所对应的copied node
 *      2-4 把copiedNewHead.random指向 copied random node
 *      2-5 如此同时循环head和copiedHead，对照head的random指针，分别给copiedHead赋random指针
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null){
            return head;
        }
        RandomListNode newHead = new RandomListNode(head.label);
        HashMap<RandomListNode, RandomListNode> table =
                new HashMap<RandomListNode, RandomListNode>();
        table.put(head,newHead);

        RandomListNode prev = newHead;//points to new copy
        RandomListNode node = head.next;//points to orinal node
       //通过head 新建copiedHead，并且完成copiedHead的next指向
       //同时，分别把node和copiedNode放入map中
        while (node != null){
            RandomListNode next = new RandomListNode(node.label);
            table.put(node, next);
            prev.next = next;
            prev = next;
            node = node.next;
        }
        //再次循环head，通过map调出node的random指针，赋给copiedNode
        RandomListNode copyNewHead = newHead;//save newHead pointer
        while (head != null){
            //链接新的node的random指针。新node存在table的value栏中
            //通过head.random得出random的value,通过table.get找到它对应的value值
            copyNewHead.random = table.get(head.random);
            head = head.next;
            copyNewHead = copyNewHead.next;
        }
        return newHead;

    }
}
