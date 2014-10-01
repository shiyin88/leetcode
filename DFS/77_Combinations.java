/**
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        helper(n, k, path, result, 1);
        return result;
    }

    public void helper(int n, int k, List<Integer> path, List<List<Integer>> result,int pos){
        if (path.size() == k){
            result.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = pos; i <= n; i++){
            path.add(i);
            helper(n, k, path, result, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
