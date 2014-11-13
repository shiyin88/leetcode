/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.

Hide Tags Array Hash Table Stack Dynamic Programming

reference :
http://www.cnblogs.com/lichen782/p/leetcode_maximal_rectangle.html
http://huntfor.iteye.com/blog/2086892

这道题是通过Largest Rectangle in Histogram而进一步求得解。
想象成有一个和matrix一样的长方体，但是每个格子的数字表示它上面i=0到i中所有的1
通过此，得出每行中的最多的1，放入二维数组中
然后通过Largest Rectangle in Histogram的方法，求出每行中的最大面积 （i行表示从0到第i行中累积的值，
求出的最大面积即为最大的1的长方形。
然后比较每行，求出最大的长方形
**/
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] rectangle = new int[row][col];
        //组建二维数组，使之当前值为上一行同列值 + 1
        //通过二维数组，来求取最大面积
        for (int i = 0 ; i < row; i++){
            for (int j = 0; j < col; j++){
                if (matrix[i][j] == '0'){
                    rectangle[i][j] = 0; //无论上层是0或是1，切断与上层的联系
                }else{
                    //如果此时是1， 如果是row = 0，直接赋值。else 值 = 上层同行的值 + 1
                    rectangle[i][j] = i == 0 ? 1 : rectangle[i - 1][j] + 1;
                }
            }
        }
        //求出数组中的值后，循环数组每行，通过rectangleHeight求出最大面积
        int maxArea = 0;
        for (int i = 0; i < row; i++){
            maxArea = Math.max(maxArea, maxArea(rectangle[i]));//表示每行的数
        }
        return maxArea;
    }
    public int maxArea(int[] height){
        int[] copy = new int[height.length + 1];
        copy = Arrays.copyOf(height, height.length + 1);
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
        while (i < copy.length){
            if (stack.isEmpty() || copy[stack.peek()] < copy[i]){
                stack.push(i++);
            }else{
                int cur = stack.pop();
                maxArea = Math.max(maxArea, copy[cur] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
            }
        }
        return maxArea;
    }

}
