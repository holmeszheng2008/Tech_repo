package dfs;

// 130. Surrounded Regions
public class Solution130 {
    private boolean visited[][];
    private char[][] graph;
    private int m;
    private int n;
    public void solve(char[][] board) {
        graph = board;
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            traverse(i, 0);
            traverse(i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            traverse(0, i);
            traverse(m - 1, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void traverse(int x, int y) {
        if (x < 0 || x == m || y < 0 || y == n) {
            return;
        }
        if (graph[x][y] == 'X') {
            return;
        }
        if (visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        traverse(x - 1, y);
        traverse(x + 1, y);
        traverse(x, y - 1);
        traverse(x, y + 1);
    }
}
