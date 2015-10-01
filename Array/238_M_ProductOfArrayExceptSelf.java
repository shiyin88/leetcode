/**
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)

我们以一个4个元素的数组为例，nums=[a1, a2, a3, a4]。 
想在O(n)时间复杂度完成最终的数组输出，res=[a2*a3*a4, a1*a3*a4, a1*a2*a4, a2*a3*a4]。

比较好的解决方法是构造两个数组相乘：

[1, a1, a1*a2, a1*a2*a3]
[a2*a3*a4, a3*a4, a4, 1]
这样思路是不是清楚了很多，而且这两个数组我们是比较好构造的。

http://blog.csdn.net/wzy_1988/article/details/46916179
**/
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] anum = new int[nums.length];
        int[] bnum = new int[nums.length];
        
        anum[0] = 1;
        
        for (int i = 1; i < nums.length; i++) {
            anum[i] = anum[i - 1] * nums[i - 1];
        }
        
        bnum[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            bnum[i] = bnum[i + 1] * nums[i + 1];
        }
        
        for (int i = 0; i < nums.length; i++) {
            anum[i] *= bnum[i];
        }
        return anum;
    }
}
