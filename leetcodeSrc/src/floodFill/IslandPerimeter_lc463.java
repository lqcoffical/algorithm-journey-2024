package floodFill;

public class IslandPerimeter_lc463 {

    public int islandPerimeter(int[][] grid) {
        int result = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    result += dfs(grid, n, m, i, j);
                }
            }
        }
        return result;
    }

    // 值传递不会修改值，也就是result传进来，函数操作之后不会修改值，所以dfs函数要返回int类型值
    // public static void dfs这么写不对
    public static int dfs(int[][] grid, int n, int m, int i, int j) {
        // base case
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0) {
            return 1;
        }
        if (grid[i][j] == 2) {
            return 0;
        }
        // 注意岛屿问题都得标记遍历后的格子，因为要和水区分，所以标记成2
        grid[i][j] = 2;
        return dfs(grid, n, m, i - 1, j) +
                dfs(grid, n, m, i + 1, j) +
                dfs(grid, n, m, i, j - 1) +
                dfs(grid, n, m, i, j + 1);
    }
}
