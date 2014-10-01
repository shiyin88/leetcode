public class Solution {
  public void merge(int A[], int m, int B[], int n) {

        int a = 0;
        int b = 0;
        int c = 0;
        int C[] = new int C[m + n];
        //Need to have both a and b less than m and n
        while (a < m && b < n){
            if (A[a] < B[b]){

                C[c++] = A[a++];

            }else{

                C[c++] = B[b++];

            }
        }
        //when one array has put everything into C[], the other still
        //has elements
        while (a < m){//index a < m.length
          C[c++] = A[a++];
        }

        while (b >= n){
          C[c++] = B[b++];
        }

  }
}
