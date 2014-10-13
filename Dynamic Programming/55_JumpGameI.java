/**
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
**/
public class Solution {
    public boolean canJump(int[] A) {
        boolean[] steps = new boolean[A.length];
        steps[0] = true;

        //i represents if you are able to reach index i from 0
        /**
         *
        用两个loop，外层为每个index i，内层为从0到i
        内层找从0到i是否有paht可以reach 在position i
        如果是的话，即设为true**/
        for (int i = 1; i < steps.length; i++){
            for (int k = 0; k < i; k++){
                /**
                 * 如果想要从k 跳到 i
                 *      首先要保证从0到k点是可以jump的，即steps[k] = true;
                 *      其次， 从0到k点的步骤 + k点能走过的步骤 >= 跳到i点的步骤
                 *             设steps[i] = true; 即可以调到steps[i]**/
                if (steps[k] && k + A[k] >= i){
                    steps[i] = true;
                    break;//memoirization: 简化步骤。即我们已经知道可以从0走到i就不用再重复走到i点了
                }
            }
        }
        //return 是否能调到尾部，即last index
        return steps[A.length - 1];
    }
}
