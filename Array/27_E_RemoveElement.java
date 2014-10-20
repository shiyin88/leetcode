/**
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/

/**
第一个解法思路为取一个pointer 其pointer所经过的元素都不等于elem
遍历数组A， 当A[i] != elem时，我们把A[i] 赋给 A[pointer]并且pointer++指向下一个index
          当A[i] == elem时，我们没有动作，只是i++,直到下一个数不是elem
public int removeElement(int[] A, int elem) {

        int pointer = 0;
        for (int i = 0; i < A.length; i++){
            if (A[i] != elem){
                A[pointer] = A[i];
                pointer++;
            }
        }
        return pointer;
}
/**
Analysis:
Idea is to use two pointers (i and j )
i scans all the elements in the array and j only passes not elem and
stores the final result. e.g.

A = 1 2 3 4 5 3 6 7;
i j are set to start position.
i goes from 1 to 7, if this element is not the element requested,A[j]=A[i]
(no change at start because i and j are same.), then i ++, j++, otherwise, i++, means to skip this element,but j stays, from next element, continue the above step, when set A[j]=A[i], which means A[j] was originally stored the removed element but now stores the next one.
A = 1 2 3 4 5 3 6 7,  elem=3
       i   i  i
       j   j  j

then
A = 1 2 3 4 5 3 6 7
        i i      i
        j j  j

and A = 1 2 4 4 5 3 6 7
                          i
                      j
finally, A= 1 2 4 5 6 7
**/
public class Solution {
    public int removeElement(int[] A, int elem) {
        int i = 0;//pointer loop the array from start to end
        int j = 0;//matches the index of elements after removel
        //if find elem, then move the latter elements forward
        while (i < A.length){
            if (A[i] != elem){
                A[j] = A[i];
                j++;
            }
            i++;
        }
        return j;
    }
}
