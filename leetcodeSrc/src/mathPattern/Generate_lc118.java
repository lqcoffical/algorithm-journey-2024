package mathPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generate_lc118 {
    // dp填表的杨辉三角
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resList = new ArrayList<>();
        // 二维数组可以只初始化行或者列
        Integer[][] dp = new Integer[numRows][];
        for (int i = 0; i < numRows; i++) {
            // 每行新建出数组
            dp[i] = new Integer[i + 1];
            dp[i][0] = 1;
            dp[i][i] = 1;
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
            resList.add(Arrays.asList(dp[i]));
        }
        return resList;
    }

}
