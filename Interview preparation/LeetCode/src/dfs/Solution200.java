package dfs;

// 200. Number of Island
public class Solution200 {
    private boolean[][] visited;
    private char[][] grid;
    private int m;
    private int n;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.visited = new boolean[m][n];

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    res++;
                    dfs(i, j);
                }
            }
        }

        return res;
    }

    private void dfs(int i, int j) {
        if (i < 0 || i == m || j < 0 || j == n) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;

        dfs(i - 1, j);
        dfs(i + 1, j);
        dfs(i, j - 1);
        dfs(i, j + 1);
    }
}
