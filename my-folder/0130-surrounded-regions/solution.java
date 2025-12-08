class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        //top;
        for (int i = 0; i < m; i += 1) {
            if (board[0][i] == 'O' && !visited[0][i]) {
                dfs(board, visited, 0, i);
            }
        }
        //right;
        for (int i = 1; i < n; i += 1) {
            if (board[i][m - 1] == 'O' && !visited[i][m - 1]) {
                dfs(board, visited, i, m - 1);
            }
        }
        //bottom;
        for (int i = m - 2; i >= 0; i -= 1) {
            if (board[n - 1][i] == 'O' && !visited[n - 1][i]) {
                dfs(board, visited, n - 1, i);
            }
        }
        //legt;
        for (int i = n - 2; i > 0; i -= 1) {
            if (board[i][0] == 'O' && !visited[i][0]) {
                dfs(board, visited, i, 0);
            }
        }

        for (int i = 0; i < n; i += 1) {
            for (int j = 0; j < m; j += 1) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }

        return;
    }

    public void dfs(char[][] board, boolean[][] visited, int i, int j) {
        visited[i][j] = true;

        int n = board.length;
        int m = board[0].length;
        int[][] xy = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        for (int ind = 0; ind < 4; ind += 1) {
            int x = i + xy[ind][0];
            int y = j + xy[ind][1];
            if (x >= 0 && x < n && y >= 0 && y < m && board[x][y] == 'O' && !visited[x][y]) {
                dfs(board, visited, x, y);
            }
        }
    }
}
