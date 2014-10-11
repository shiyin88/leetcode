/**
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * 利用分治的思想把合并k个链表分成两个合并k/2个链表的任务，一直划分，知道任务中只剩一个链表或者两个链表。可以很简单的用递归来实现。因此算法复杂度为T(k) = 2T(k/2) + O(nk),很简单可以推导得到算法复杂度为O（nklogk）
递归的代码就不贴了。下面是非递归的代码非递归的思想是（以四个链表为例）：
1、3合并，合并结果放到1的位置
2、4合并，合并结果放到2的位置
再把1、2合并（相当于原来的13 和 24合并）
http://www.cnblogs.com/TenosDoIt/p/3673188.html

即不停地把k个链表合并成 k/2...直到 K = 1
1) combine two sorted linkedList to one sorted list
2) repeat the above steps until k = 1
 */
public class Solution {
    public static ListNode mergeKLists(List<ListNode> lists) {
        int size = lists.size();
        if (size == 0){
            return null;
        }
        /**
             * The reason why we use mid = (size + 1) / 2 instead of mid = size / 2
             * is that if the size is odd number
             * e.x size = 3
             * in the for loop we merge the index i, i + mid in the list together.
             * and i < size / 2
             * if size = 3 then mid = 1,
             * in the for loop (i = 0; i < 1; i++){
                 we merge 0 and 1
               because i < 1, we didn't merge the 3rd ListNode
               So we need to use (size + 1) / 2 to
                1) allocate one more space for another listNode in the List
                2) Loop this list
             }
             * */
        while (size > 1){//merge two lists to one repeatly until size = 1

            int mid = (size + 1) / 2;//split the list in half, and mid represents the start point of the other half

            for (int i = 0; i < size / 2; i++){
                ListNode mergedList = merge(lists.get(i), lists.get(i + mid));
                lists.set(i, mergedList);//replace the merged list to the original list at index i
            }
            size = mid;//discard another half of the list as we merged n lists to n/2 in the List
        }
        return lists.get(0);//in the end we merged them to one list, the first one in the List
    }

    private static ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(0);
        ListNode runner = dummy;
        while(head1 != null && head2 != null){
            if (head1.val <= head2.val){
                runner.next = head1;
                head1 = head1.next;
            }else{
                runner.next = head2;
                head2 = head2.next;
            }
            runner = runner.next;
        }
        if (head1 != null){
            runner.next = head1;
        }
        if (head2 != null){
            runner.next = head2;
        }
        return dummy.next;
    }

}
