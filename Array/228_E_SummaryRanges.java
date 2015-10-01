/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
设置两个pointer s和e
s表示一个range的起点，e表示终点。
当loop nums数组的时候，如果e + 1 和 nums[e + 1] 相同，则说明是连续数，终点point则为e + 1,把e++;
                       如果不相等， 要判断s和d的值
                            如果s=e 则说明s和e指向同一位数，下一个数不能和当前数连成range，则把当前数加入数组
                            如果s和e不等，则找到了一个数的range，把s和e的范围加入。
**/
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if (nums == null || nums.length == 0) return result;
        int s = 0;
        int e = 0;
        
        while (e < nums.length) {
            if (e + 1 < nums.length && nums[e] + 1 == nums[e + 1]) {
                e++;
            }else{
                if (s == e) {
                    result.add(Integer.toString(nums[s]));
                }else{
                    result.add(nums[s] + "->" + nums[e]);
                }
                e++;
                s = e;
            }
        }
        return result;
    }
}
