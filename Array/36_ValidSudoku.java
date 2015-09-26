/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
**/
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null) return true;
        int row = board.length;
        int col = board[0].length;
        
        
        //row
        for (int i = 0; i < row; i++) {
            Set<Character> set = new HashSet<Character>();
            for (int k = 0; k < col; k++) {
                if (board[i][k] != '.'){
                    if (!set.contains(board[i][k])){
                        set.add(board[i][k]);
                    }else{
                        return false;
                    }
                }
            }
        }
        
        for (int i = 0; i < col; i++) {
            Set<Character> set = new HashSet<Character>();
            for (int k = 0; k < row; k++) {
                if (board[k][i] != '.'){
                    if (!set.contains(board[k][i])){
                        set.add(board[k][i]);
                    }else{
                        return false;
                    }
                }
            }
        }
        /**
         * i and k 限定扫描的col和row是3*3
         * 内部两个for loop来限定扫描的起始点
         * 即从0-3, 3-6, 6-9的九宫格**/
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                Set<Character> set = new HashSet<Character>();
                row = 3*i;
                col = 3*k;
                for (int m = row; m < row + 3; m++) {
                    for (int n = col; n < col + 3; n++) {
                        if (board[m][n] != '.') {
                            if (!set.contains(board[m][n])){
                                set.add(board[m][n]);
                            }else{
                                return false;
                            }
                        }
                    }
                }
                
            }
        }
        
        return true;
    }
}
