package floodFill;

public class Exist_lc079 {

    public boolean exist(char[][] board, String word) {
        // 洪水填充dfs+恢复现场的回溯
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    // 来到的位置等于单词开头才往下洪水填充
                    if (dfs(board, word, n, m, i, j, 0)) return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int n, int m, int i, int j, int k) {
        // k是单词中第几个位置的字母，位置k
        // base case
        if (k == word.length()) {
            return true;
        }
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return false;
        }
        // 不等于直接返回
        if (word.charAt(k) != board[i][j]) {
            return false;
        }
        char t = board[i][j];
        board[i][j] = '0';
        // 左右上下洪水填充
        boolean ans = dfs(board, word, n, m, i - 1, j, k + 1) ||
                dfs(board, word, n, m, i + 1, j, k + 1) ||
                dfs(board, word, n, m, i, j - 1, k + 1) ||
                dfs(board, word, n, m, i, j + 1, k + 1);
        // 因为和岛屿每块地只数一次不一样，字母有可能其他开头位置的dfs遍历还要用到，前面设置为‘0’是自己这轮dfs不用到重复的字母
        // 但是还要给人恢复过来
        board[i][j] = t;
        return ans;
    }

}
