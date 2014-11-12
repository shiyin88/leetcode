/**
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
Hide Tags Array Backtracking

 * 通过dfs来求解。
 * find方法中的board[i][j] = word.charAt(start)即为dfs的模板最后一行list.remove(list.size() - 1);即复原上一步，接着走
 * 当我们都走完了后，start = word.length 即返回结果
 * 其中有一些 条件是return false ： 应及时制止
 *      1）在做dfs的时候，要把 i 和 j +1/-1
 *          保证i >= 0 & j >= 0
 *      2) i >= board.length || j >= board[0].length (i代表row， j代表col)
 *      3) board[i][j] != word.charAt(start) 即返回false
 *         否则，进入下一步，去mark下当前的value**/
public class Solution {
    public boolean exist(char[][] board, String word) {
        if (word.length() <= 0){
            return true;
        }
        if (board == null || board.length == 0){
            return false;
        }
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == word.charAt(0)){
                    if (find(board, word, i, j, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean find(char[][] board, String word, int i, int j, int start){
        if (start == word.length()){
            return true;
        }
        if (i < 0 || j < 0 ||
            i >= board.length || j >= board[0].length||
            board[i][j] != word.charAt(start)){
            return false;
        }

        board[i][j] = '*';
        boolean result = find(board, word, i - 1, j, start + 1)||
        find(board, word, i + 1, j, start + 1)||
        find(board, word, i, j - 1, start + 1)||
        find(board, word, i, j + 1, start + 1);
        board[i][j] = word.charAt(start);
        return result;
    }
}
