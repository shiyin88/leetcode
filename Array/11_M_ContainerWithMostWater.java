/**
Given n non-negative integers a1, a2, ..., an, where each represents a point at
coordinate (i, ai).
n vertical lines are drawn such that the two endpoints of line i is at (i, ai)
and (i, 0). Find two lines, which together with x-axis forms a container,
such that the container contains the most water.

Note: You may not slant the container.
Hide Tags Array Two Pointers

O(n)方法，思路是从两头到中间扫描，设i,j分别指向height数组的首尾。
那么当前的area是min(height[i],height[j]) * (j-i)。
当height[i] < height[j]的时候，我们把i往后移，否则把j往前移，直到两者相遇。

**/
public class Solution {
    public int maxArea(int[] height) {
        if (height.length < 2){
            return 0;
        }
        int head = 0;
        int tail = height.length - 1;
        int area = 0;
        int maxArea = 0;
        while (head < tail){
            if(height[head] < height[tail]){
                area = height[head]*(tail - head);
                //因为i是短板，所以如果无论j往前移动到什么位置，都不可能产生比area更大的面积
                //换句话所，i能形成的最大面积已经找到了，所以可以将i向前移。
                head++;
            }else{
                area = height[tail]*(tail - head);
                tail--; //同理
            }
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
