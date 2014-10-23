/**
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
思路：
每行的第一个index必为1
当i > 0 时，最后一位也必为1
            两个1之间的数字是上一排中 它的index 和 index + 1 即result.get(i - 1).get(k) + result.get(i - 1).get(k + 1)
**/
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int i = 0; i < numRows; i++){
            List<Integer> path = new ArrayList<Integer>();
            path.add(1);
            if (i > 0){
                for (int k = 0; k < result.get(i - 1).size() - 1; k++){
                    path.add(result.get(i - 1).get(k) + result.get(i - 1).get(k + 1));
                }
                path.add(1);
            }
            result.add(path);
        }
        return result;
    }
}
