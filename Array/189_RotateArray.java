/**
 * Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]

Hint:
Could you do it in-place with O(1) extra space?
Related problem: Reverse Words in a String II

Credits:
Special thanks to @Freezen for adding this problem and creating all test cases.

Show Tags
Show Similar Problems


 *
 * **/
 //Solution 1  space : O(1) time: O(n)
 //http://www.programcreek.com/2015/03/rotate-array-in-java/
public class Solution {
    public void rotate(int[] nums, int k) {
        
        k = k % nums.length;
        k = nums.length - k;
        swap(nums, 0, k - 1);
        swap(nums, k, nums.length - 1);
        swap(nums, 0, nums.length - 1);
        
    }
    
    public void swap(int[] nums, int s, int e) {
        while (s < e) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }
}
//通过把末尾的前移移到首尾，从len-1 -> 0一直从后到前移，移动k位
//bubble sort  However, the time is O(n*k).
public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Illegal argument!");
        }
        
        //use bubble sort to swap in place
        for (int i = 0; i < k; i++) {
            for (int j = nums.length - 1; j > 0; j--) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
            }
        }
    }
}
