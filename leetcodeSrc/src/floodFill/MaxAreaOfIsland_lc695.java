package floodFill;

public class MaxAreaOfIsland_lc695 {

    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    result = Math.max(result, dfs(grid, n, m, i, j));
                }
            }
        }
        return result;
    }

    public static int dfs(int[][] grid, int n, int m, int i, int j) {
        // base case
        // 这个判断不是1返回0别忘了
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 2;
        // 这个地方第一次遇到地面1，第一次调用dfs别忘了加开头的1
        // 这个1是本块的面积，别忘了加
        return 1 + dfs(grid, n, m, i - 1, j) +
                dfs(grid, n, m, i + 1, j) +
                dfs(grid, n, m, i, j - 1) +
                dfs(grid, n, m, i, j + 1);
    }
}
