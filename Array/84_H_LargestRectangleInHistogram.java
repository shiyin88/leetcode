/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given height = [2,1,5,6,2,3],
return 10.

Hide Tags Array Stack

参考： http://www.tuicool.com/articles/7zUvmy
http://www.cnblogs.com/lichen782/tag/leetcode/
**/
public class Solution {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
        int[] h = new int[height.length + 1];
        //int[] java.util.Arrays.copyOf(int[] original, int newLength)
        h = Arrays.copyOf(height, height.length + 1);
        while (i < h.length){
            //升序
            if (stack.isEmpty() || h[i] > h[stack.peek()]){
                stack.push(i++);
            }else{
                //由于在push后，我们把i++使得i比实际大1.这里如果要求真实的宽度，需要把i - 1
                //i表示当前递增数列中最大的数所在的index + 1。ex i = 4 index = 2 (注，4为+1后的index)
                //h[index] = 5 area = 5 * （4 - 1 - 2）
                int index = stack.pop();//表示当前pop的index
                maxArea = Math.max(maxArea,
                          h[index] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
            }
        }
        return maxArea;

    }
}
