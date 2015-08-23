/**
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.

Hide Tags Greedy

 * maxIndex 表示gas station的index，代表从maxIndex出发可以travel一个circuit
 * 初始化为0，代表第一个index
 * 分别初始化两个variable ： sum & total
 * sum : 记录当前gas[i] - cost[i] 是否< 0. < 0则表示为从之前的index走到当前i时： 损耗大于收入。则需要重新赋值为0
 *       重新记录新的点开始走。此时，由于当i时，不能走circuit，所以把maxIndex 赋值为 i + 1。假设下一个点可以走circuit
 * total : 记录整个旅程中总的支出和收入。total的意义在于：如果> 0，则表示gas有剩余，肯定能走一圈。但是我们不知道从哪个点走可以走一圈。
 *          所以，我们用sum来记录某点开始后的盛或是负于的情况。其从某点（即index来记录）开始，sum一直>0，可以断定index表示其可以走一圈
 *          的点。
 *          如果<0 走都无法走circuit
 * */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int maxIndex = 0;
        int sum = 0;
        int total = 0;
        for (int i = 0; i < gas.length; i++){
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0){
                sum = 0;
                maxIndex = i + 1;
            }
        }
        return total >= 0 ? maxIndex : -1;
    }
}
