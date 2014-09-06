public class Solution {
      public String longestPalindrome(String s) {

        char[][] table = new char[s.length()+1][s.length()+1];
        drawTable(s,table);
        int[] indice = fillTable(table);
        int row = indice[0];
        int col = indice[1];
        String longPalindrome = "";

        if (row >= col){
          for (int i = col; i >= 1; i--){
            longPalindrome = longPalindrome + table[0][col--];
          }
        }else{
           for (int i = row; i >= 1; i--){
             longPalindrome = longPalindrome + table[row--][0];
           }
        }
        return longPalindrome;

    }
    //draw a table with n+1 rows and columns
    public static void drawTable (String s, char[][] table){
      int length = s.length();
      for (int i = 1; i <= length; i++){
        table[0][i] = s.charAt(i-1);
      }//row

      int shrink = s.length() - 1;
      for (int i = 1; i <= length; i++){
        table[i][0] = s.charAt(shrink--);
      }
    }
    //fill the number of occurrence of each index to the table
    public static int[] fillTable(char[][] table){
        int longLength = 0;
        int longRow = 0;
        int longCol = 0;
        int[] indice = new int[2];
        //start with row and col 1
        for (int i = 1; i < table[0].length; i++){
          for (int k = 1; k < table[i].length; k++){
            if (table[0][k] == table[i][0]){
              if(k == 1 || i == 1){
                table[i][k] = '1';
              }else{
                table[i][k] = (char) (Character.getNumericValue('0' + table[i-1][k-1]) + 1);
              }
              if (table[i][k] > longLength){
                  longRow = i;
                  longCol = k;
              }
            }
          }
        }
        indice[0] = longRow; //convert char to int
        indice[1] = longCol;
        return indice;
    }
}
