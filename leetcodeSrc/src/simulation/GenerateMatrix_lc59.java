package simulation;

public class GenerateMatrix_lc59 {

    public int[][] generateMatrix(int n) {
        // 模拟：占位法
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int[][] result = new int[n][n];
        int num = 1, target = n * n;
        while (num <= target) {
            for (int i = left; i <= right; i++) {
                result[top][i] = num++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result[i][right] = num++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                result[bottom][i] = num++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                result[i][left] = num++;
            }
            left++;
        }
        return result;
    }
}
