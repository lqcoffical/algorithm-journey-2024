package floodFill;

public class NumIslands_lc200 {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int islands = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 来到每一个位置，如果是陆地1就岛屿+1，然后去感染
                if (grid[i][j] == '1') {
                    // 在外边计数，也就是来到第一个1的时候就开始数岛屿
                    islands++;
                    dfs(grid, n, m, i, j);
                }
            }
        }
        return islands;
    }

    public static void dfs(char[][] grid, int n, int m, int i, int j) {
        // base case
        // 此时来到越界的位置或者已经不是陆地就直接返回
        if (i < 0 || i == n || j < 0 || j == m || grid[i][j] != '1') {
            return;
        }
        // gird[i][j] = '1' 把感染过的陆地标志成0
        grid[i][j] = '0';
        // 左右上下感染
        dfs(grid, n, m, i - 1, j);
        dfs(grid, n, m, i + 1, j);
        dfs(grid, n, m, i, j - 1);
        dfs(grid, n, m, i, j + 1);
    }
}
