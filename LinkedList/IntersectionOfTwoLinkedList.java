/**
* Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
↘
c1 → c2 → c3
↗
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
Credits:
Special thanks to @stellari for adding this problem and creating all test cases.

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
* reference http://www.tuicool.com/articles/m2Mnuev
* 首先得到两个list的长度，
* 如果list1和list2不等，但是由于他们后面终会有相交点，
* 比如 1->2->3->4->5  len1 = 5
*         6->3->4->5  len2 = 4
* 交点必在较短的list的上面。所以较长的list要多走几步，
* 直到指针所指向的node为head到tail的长度和另一个list
* 长度相等。这里，n = 5 - 4 = 1
* list1要走一步到2，list2的head指向6
* 两个指针同步走，直到两个指针相等（由于两个list最后面的nodes是
* 一个node，所以这里我们要compare是否node1 和 node2 相等，
* 而非value)
*
*/
public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

    if (headA == null || headB == null){
      return null;
    }

    ListNode runnerA = headA;
    ListNode runnerB = headB;
    int lenA = 0, lenB = 0;
    while(runnerA != null){
      runnerA = runnerA.next;
      lenA++;
    }
    while(runnerB != null){
      runnerB = runnerB.next;
      lenB++;
    }
    if (lenA >= lenB){
      int n = lenA - lenB;
      runnerA = headA;
      runnerB = headB;
      while ((n--) > 0){
        runnerA = runnerA.next;
      }
    }else{
      int n = lenB - lenA;
      runnerA = headA;
      runnerB = headB;
      while ((n--) > 0){
        runnerB = runnerB.next;
      }
    }
    while (runnerA != runnerB){
      runnerA = runnerA.next;
      runnerB = runnerB.next;
    }
    return runnerA;
  }
}
