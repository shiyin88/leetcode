/**Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].

 * To have time complexity O(Log n), it must use binary search
 * What we need here is to find:
 * 1) first occurrence of index (one while loop but if A[mid] == target) end = mid: we search from start to mid)
 * 2) last occurrence of index (one while loop but if A[mid] == target) start = mid: we search from mid to start)
 *
 if question is asking how many times the target value occurs?
      Answer: after we find the starting and ending pos of a given target value, e.x [3, 4]
              ans = 4 - 3 + 1 = 2

 此题是通过两个while loop 搜索target在数组中的范围。
 在两个while loop 中都用到了二分法，但是当target = mid时，while loop分别搜索了
 从[start, target] 和 [target, end] 两个range

 在第一个while loop： 当target = A[mid]
 把 end = mid 这样做目的是重复搜索起点到发现的第一个target中的值
 当跳出while loop时， 首先查找是否A[start] 是否等于target 这样做的目的是保证找到的是range的起点

 第二个while loop： 当target = A[mid]
 把 start = mid 这样做目的是重复搜索第一个target到终点的值
 当跳出while loop时， 首先查找是否A[end] 是否等于target 这样做的目的是保证找到的是range的终点

 */
 public class Solution {
    public int[] searchRange(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        int mid = 0;
        int[] bound = new int[2];
        //left bound
        while (start + 1 < end){
            mid = start + (end - start)/2;
            if (A[mid] == target){
                end = mid;//ensure this find target is the end of the index. if we find occurrence index in the left,
                //then keep moving
            }else if (A[mid] > target){
                end = mid;
            }else if (A[mid] < target){
                start = mid;
            }
        }
        if (A[start] == target){
            bound[0] = start;
        }else if (A[end] == target){
            bound[0] = end;
        }else{
            bound[0] = bound[1] = -1;
        }

        start = 0;
        mid = 0;
        end = A.length - 1;
        //right bound
        while (start + 1 < end){
            mid = start + (end - start)/2;
            if (A[mid] == target){
                start = mid;//ensure this find target is the end of the index. if we find occurrence index in the left,
                //then keep moving
            }else if (A[mid] > target){
                end = mid;
            }else if (A[mid] < target){
                start = mid;
            }
        }
        if (A[end] == target){
            bound[1] = end;
        }else if (A[start] == target){
            bound[1] = start;
        }else{
            bound[0] = bound[1] = -1;
        }
        return bound;

    }
}
