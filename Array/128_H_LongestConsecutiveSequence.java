/**Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.

Hide Tags Array
通过Array.sort() 需要O(nlogn) time
通过Set来找连续数
在数组中的一个数，通过两个while循环，分别找它的左边和右边递增和递减的数
然后count累积,count是当下的最大连续数,max是求得最大连续数。
当找到它以及它的连续数后，从set中删除，以免重复查找
当求出后，每次count和max比较，求出最大值
**/
public class Solution {
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : num){
            set.add(i);
        }
        int max = 0;
        for (int i : num){
            //already contains i, set count to 1
            int count = 1;
            int left = i - 1;
            int right = i + 1;
            set.remove(i);

            while (set.contains(left)){
                set.remove(left);//需要remove from set。否则时间超时
                count++;
                left--;
            }
            while (set.contains(right)){
                set.remove(right);
                count++;
                right++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
