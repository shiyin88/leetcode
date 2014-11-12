/**
Sort a linked list using insertion sort.

Hide Tags Linked List Sort

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * Insertion Sort：
 * In a group of numbers from a0 ... aN, if a0 to aK-1 is sorted, and aK to aN is unsorted,
 * then we compare aK with every number from a0 to aJ (aJ is the last number smaller than aK),
 * and put it in after aJ.
 * Do the same thing for the rest of numbers from aN+1 to aN.
 *
 * start : compare a1 with a0. if a1 < a0, swap (a1, a0). So a0 to a1 is a sorted list.
 * And then keep checking from a2 to aN.
 *
 * 思路：
 * 处理两个LinkedList来完成。
 * 首先，生成一个dummynode，并且用此代表一个sorted list
 * 另外，已知的LinkedList为unsorted
 * 任务为，把unsorted list的每一个node a1和sorted list中的每个node做比较。在sortedlist中找到比它大的node a2
 * 就把这个要sort的node a1放到比它大的node a2前面。并且，把已知的node排序，使之顺序为ascending order
 *
 * 这里需要三个指针。
 * prev : 指向sortedlist中的node (每次比较的时候从dummy开始指向tail)
 * cur : 指向unsortedList中待比较的node
 * next: 指向unsortedList中cur.next用来保存数值。由于当把cur放入sortedList中时，会切断cur和unsortedList中的联系。
 * 这时需要保留next，便于下次比较。
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {

       ListNode dummy = new ListNode(-1);
       ListNode prev = dummy;
       ListNode cur = head;
       while (cur != null){
           prev = dummy;
           ListNode next = cur.next;//reserve cur.next 以免丢失指针
           //compare the value of current node with sorted list (prev is the head) sequencially
           //用prev.next而不是prev方便操作。在需要变换的时候，直接把把prev.next放到cur后面。然后把cur放到prev后面
           while (prev.next != null && prev.next.val <= cur.val){
               prev = prev.next;
           }
           //由于prev.next > cur所以我们需要把prev.next放到cur后面。然后让prev.next链接cur
           cur.next = prev.next;
           prev.next = cur;
           //update cur
           cur = next;
       }
       return dummy.next;

    }
}
