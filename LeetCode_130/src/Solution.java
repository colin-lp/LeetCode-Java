import java.io.InterruptedIOException;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solve(new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}});
        //不想改成变量了，AC完复制的
    }

    public void solve(char[][] board) {
        if (board.length == 0) return;
        for (int y = 0; y < board.length; y++) {
            dfs(board, y, 0);
            dfs(board, y, board[0].length - 1);
        }
        for (int x = 0; x < board[0].length; x++) {
            dfs(board, 0, x);
            dfs(board, board.length - 1, x);
        }
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (board[y][x] == 'A') {
                    board[y][x] = 'O';
                } else if (board[y][x] == 'O') {
                    board[y][x] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int y, int x) {
        if (y < 0 || y >= board.length || x < 0 || x >= board[0].length || board[y][x] != 'O') {
            return;
        }
        board[y][x] = 'A';
        dfs(board, y, x + 1);
        dfs(board, y, x - 1);
        dfs(board, y + 1, x);
        dfs(board, y - 1, x);
    }
}
