/**
*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7,
A solution set is:
[7]
[2, 2, 3]
设定pos， 防止出现重复数列
如果没有pos这个数值，则出现数列为：
Output:
[[1,1,1],[1,2],[2,1]]

Input:
[1,2], 3
Expected:
[[1,1,1],[1,2]]
*/

public class Solution {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        helper(candidates, result, path, target, 0);
        return result;
    }

    public static void helper(int[] candidates, List<List<Integer>> result, List<Integer> path, int target, int pos){
        int sum = 0;
        for (int i : path){
            sum = sum + i;
        }
        if (sum == target){
            result.add(new ArrayList<Integer>(path));
            return;
        }

        if (sum < target){
            for (int i = pos; i < candidates.length; i++){
                path.add(candidates[i]);
                helper(candidates, result, path, target, i);
                path.remove(path.size() - 1);
            }
        }
    }
}
