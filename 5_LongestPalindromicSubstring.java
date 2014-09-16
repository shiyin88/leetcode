public class Solution {

	      public static String longestPalindrome(String s) {

	        String[][] table = new String[s.length()+1][s.length()+1];
	        drawTable(s,table);
	        int[] indice = fillTable(table);
	        int row = indice[0];
	        int col = indice[1];
	        String longPalindrome = "";

	          for (int i = Integer.parseInt(table[row][col]); i >= 1; i--){
	            longPalindrome = longPalindrome + table[0][col--];
	          }
	        return longPalindrome;

	      }
	    //draw a table with n+1 rows and columns
	    public static void drawTable (String s, String[][] table){
	      int length = s.length();
	      for (int i = 1; i <= length; i++){
	        table[0][i] = Character.toString(s.charAt(i-1));
	      }//row

	      int shrink = s.length() - 1;
	      for (int i = 1; i <= length; i++){
	        table[i][0] = Character.toString(s.charAt(shrink--));
	      }

	      for (int i = 1; i < table[0].length; i++){
	          for (int k = 1; k < table[i].length; k++){
	        	  table[i][k] = "0";
	          }
	      }
	    }
	    //fill the number of occurrence of each index to the table
	    public static int[] fillTable(String[][] table){
	        int longLength = 0;
	        int longRow = 0;
	        int longCol = 0;
	        int[] indice = new int[2];
	        //start with row and col 1
	        for (int i = 1; i < table[0].length; i++){
	          for (int k = 1; k < table[i].length; k++){
	            if (table[0][k].equals(table[i][0])){
	              if(k == 1 || i == 1){
	                table[i][k] = "1";
	              }else{
	            	int temp =Integer.parseInt(table[i-1][k-1]) +1;
	                table[i][k] = Integer.toString(temp);
	              }
	              if (Integer.parseInt(table[i][k]) > longLength){
	            	  longLength = Integer.parseInt(table[i][k]);
	                  longRow = i;
	                  longCol = k;
	              }
	            }
	          }
	        }
	        indice[0] = longRow;
	        indice[1] = longCol;
	        return indice;
	    }
}
