package greedyAlgorithm.naturalIdeas;

import java.util.Arrays;

public class FindContentChildren_lc455 {
    public int findContentChildren(int[] g, int[] s) {
        // 贪心，先排序，之后小孩和饼干依次对应
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length; ) {
            if (g[i] <= s[j]) {
                i++;
                j++;
                result++;
            } else {
                j++;
            }
        }
        return result;
    }
}
