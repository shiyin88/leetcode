/**
Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
*/

public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        List<Integer> path = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(S);//need the sets to be sorted
        helper(path, result, S , 0);
        return result;
    }
    public void helper(List<Integer> path,List<List<Integer>> result, int[] S, int pos){

        result.add(new ArrayList<Integer>(path));//assign the value to a new arraylist object
                                                //won't change result's value if path changed
        for (int i = pos; i < S.length; i++){
            path.add(S[i]);
            helper(path, result, S, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
