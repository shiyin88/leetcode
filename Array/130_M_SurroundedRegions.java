/**Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Hide Tags Breadth-first Search

 * 这道题用BFS做。思路是，
 * 1.从matrix的最外延的一圈，如果有 0 则要保持，并把其标志位 * ， 而且从当前O向上下左右蔓延，找到和它紧邻的O
 * 由于最外延的O是肯定能从matrix中出去的，它下面没有被包围。同理，由于外延O能出去，和它相邻的O必能出去
 * 2. 在标志了所有和外延O以及能关联的外延O后，并且标志它们为*后，
 * 通过for loop，把剩下的O都标志成X，并且剩下标志成*设置回O
 * reference http://www.cnblogs.com/feiling/p/3304120.html**/
public class Solution {
    Queue<Integer> queue = new LinkedList<Integer>();
    public void solve(char[][] board) {

        if (board.length == 0){
            return;
        }
        if (board[0].length == 0){
            return;
        }
        int col = board[0].length;
        int row = board.length;

        //top row
        for (int i = 0; i < col; i++){
            if (board[0][i] == 'O'){
                bfs(board, 0, i);
            }
        }
        //left
        for (int i = 0; i < row; i++){
            if (board[i][0] == 'O'){
                bfs(board, i, 0);
            }
        }

        //right
        for (int i = 0; i < row; i++){
            if (board[i][col - 1] == 'O'){
                bfs(board, i, col - 1);
            }
        }
        //bottom
        for (int i = 0; i < col; i++){
            if (board[row - 1][i] == 'O'){
                bfs(board, row - 1, i);
            }
        }

        for (int i = 0; i < row; i++){
            for (int k = 0; k < col; k++){
                if (board[i][k] == 'O'){
                    board[i][k] = 'X';
                }

                if (board[i][k] == '#'){
                    board[i][k] = 'O';
                }
            }
        }
    }

    public void bfs(char[][] board, int i, int k){
        int col = board[0].length;
        fill(board, i, k);//fill current index (put to queue and mark it)
        while(!queue.isEmpty()){
            int current = queue.poll();
            int x = current / col;
            int y = current % col;

            fill(board, x + 1, y);
            fill(board, x - 1, y);
            fill(board, x, y + 1);
            fill(board, x, y - 1);

        }
    }
    public void fill(char[][] board, int i, int k){
        int row = board.length;
        int col = board[0].length;
        if (i < 0 || i >= row || k < 0 || k >= col || board[i][k] != 'O'){
            return;
        }
        //convert two dimensional array to one dimensional array, so it will be cur_row * total_col + cur_col
        queue.offer(i * col + k);
        board[i][k] = '#';
    }
}
