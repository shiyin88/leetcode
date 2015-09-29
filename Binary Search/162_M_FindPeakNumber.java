/**
 * https://siddontang.gitbooks.io/leetcode-solution/content/array/find_peak_element.html
 * http://shanjiaxin.blogspot.com/2015/01/find-peak-element-leetcode.html
 * A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

click to show spoilers.

Note:
Your solution should be in logarithmic complexity.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Hide Tags Array Binary Search
**/
public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null) return 0;
        
        int start = 0;
        int end = nums.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }else if (mid > 0 && nums[mid - 1] > nums[mid]) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return nums[start] > nums[end] ? start : end;
    }
}
