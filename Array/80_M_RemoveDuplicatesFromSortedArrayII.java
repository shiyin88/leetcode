/**
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].
这道题是用two pointer 来做。
pointer指向的index为最多两个重复的元素。pointer + 1表示所以重复或是没有被check的元素
counter 用来记录遍历当前元素的次数

**/

public class Solution {
    public static int removeDuplicates(int[] A) {
      if (A.length == 0) return 0;

      int pointer = 0;
      int counter = 1;
      for (int i = 1; i < A.length; i++){
          if (A[i] == A[pointer]){
              if (counter < 2){
                 counter++;
                 pointer++; //由于counter<2表示可以容纳A[i]在数组中。所以pointer多容纳一个数
              }
              A[pointer] = A[i]; //无论counter结果怎样，都要把A[i]赋值给A[pointer]
              //但是不同的是当counter>2的时候，pointer多容纳了一位
          }else{
              counter = 1;//表示与pointer的数不同，counter的数为当前的number出现的次数
              A[++pointer] = A[i];//pointer多容纳一个空间，把A[i]赋值给此空间
          }
      }

      return pointer + 1; //return the length of new array
    }
}
