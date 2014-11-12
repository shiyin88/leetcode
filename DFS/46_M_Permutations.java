/**
Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

Hide Tags Backtracking
此题是典型的dfs
有两点需要注意 ： 1） 在把数加入list中，为防止加入重复数，如 1，1 所以判断用path.contains(num[i])
                  2） for loop 的启示是 i = 0. 如果helper(num, result, path,i) 并且for i = pos, 则在backtracking的时候，
                  ex.num = {0, 1}
                  个位为1， 由于i = 1 十位也是1. 无法回复到0的情况。
**/
public class Solution {
    public static List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();

        if (num == null){
            return result;
        }
        helper(num, result, path);
        return result;
    }
    public static void helper(int[] num, List<List<Integer>> result, List<Integer> path){

        if (path.size() == num.length){
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i < num.length; i++){
        	  if (path.contains(num[i])){
        		  continue;
        	  }
              path.add(num[i]);
              helper(num, result, path);
              path.remove(path.size() - 1);
          }
    }

}
