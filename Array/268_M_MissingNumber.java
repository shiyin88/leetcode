public class Solution {
    public int missingNumber(int[] nums) {
        //sum of array
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        //the last number n
        //there are (n + 1) total numbers
        int n = nums.length;
        //sum from 0 to n
        return (int)((n + 1) * n * 0.5 - sum);
        
    }
    
}
/**这题还有一种解法，使用位操作Bit Manipulation来解的，用到了异或操作的特性，相似的题目有Single Number 单独的数字, Single Number II 单独的数字之二和Single Number III 单独的数字之三。那么思路是既然0到n之间少了一个数，我们将这个少了一个数的数组合0到n之间完整的数组异或一下，那么相同的数字都变为0了，剩下的就是少了的那个数字了，参加代码如下：
 * 
 * 在CareerCup中有一道类似的题，5.7 Find Missing Integer 查找丢失的数，但是那道题不让我们直接访问整个int数字，而是只能访问其二进制表示数中的某一位，强行让我们使用位操作Bit Manipulation来解题，也是蛮有意思的一道
class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int res = 0;
        for (int i = 0; i < nums.size(); ++i) {
            res ^= (i + 1) ^ nums[i];
        }
        return res;
    }
};**/
