/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

space: O(n)
**/
public class Solution {
    public static int minimumTotal(List<List<Integer>> triangle) {

        int[] result = new int[triangle.get(triangle.size() - 1).size()];
        int length = triangle.size() - 1;
        //initialize the array and fill the array with all the elements in the bottom triangle
        /**
         * 取三角形bottom的长度n，并且设array的长度为n。遍历三角形bottom的row，并且赋值给array
         * 作为初始值。其目的是以bottom row 为单位，当从倒数第二个row向上遍历的时候，比较底部其相邻的
         * 两个值，即第二个for loop 里面的result【k】 和 result【k + 1】的最小值并且加上当前的value
         * 重复赋给array[k]，最后我们取array[0]的值。即赋给的第一个值
         * */
        for (int i = 0; i < triangle.get(length).size(); i++){
            result[i] = triangle.get(length).get(i);
        }

        //start with length - 1 row
        for (int i = triangle.size() - 2; i >= 0; i--){
            int col = triangle.get(i).size();
            /**
             * 一下表示为，比较当前值下一行相邻的两个值，取小指，然后加上当前值
             *  2
             * 3 4
             * ex 当前值为2， 比较上一次记录的2下一排的3和4.取小值即3然后加上2 放在index k上面**/
            for (int k = 0; k < col; k++){
                result[k] = Math.min(result[k], result[k + 1]) + triangle.get(i).get(k);
            }
        }
        return result[0];//层层迭代覆盖，和在index 0上面
    }
}
