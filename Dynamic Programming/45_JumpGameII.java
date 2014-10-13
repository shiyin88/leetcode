/**
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

此题和jump game I的不同是 新生成的数组是int型，并且每个index记录了0 到 当前点的最小step**/

public class Solution {
    public int jump(int[] A) {
        int[] minSteps = new int[A.length];
        minSteps[0] = 0;

        for (int i = 1; i < A.length; i++){
            for (int k = 0; k < i; k++){
                //是否从0到k点 + k的跳跃数 > 从0到i点的步数
                if (k + A[k] >= i){
                    //记录当前到i点的最小步数： 即为k点的步数（即从0到k点的最小步数） + 1 （即从k点一跃可以调到i）
                    minSteps[i] = minSteps[k] + 1;
                    break;
                }
            }
        }
        return minSteps[A.length - 1];
    }
}
