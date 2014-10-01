/**
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8,
A solution set is:
[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6]
*/
public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(num);
        helper(num, target, result, path, 0);
        return result;
    }

    public void helper(int[] num, int target, List<List<Integer>> result, List<Integer> path, int pos){
        int sum = 0;
        for (int i : path){
            sum += i;
        }
        if (sum == target){
            result.add(new ArrayList<Integer>(path));
            return;
        }

        if (sum < target){
            for (int i = pos; i < num.length; i++){
               if (i != pos && num[i] == num[i - 1]){
                   continue;
               }
               path.add(num[i]);
               helper(num, target, result, path, i + 1);
               path.remove(path.size() - 1);
            }
        }

    }
}
