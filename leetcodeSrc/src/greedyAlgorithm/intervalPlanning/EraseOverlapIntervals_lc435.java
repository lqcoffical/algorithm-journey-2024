package greedyAlgorithm.intervalPlanning;

import java.util.Arrays;

public class EraseOverlapIntervals_lc435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        // 题目说移除最少的区间，等价于这些区间最多有多少可以没有重叠的，移除的就是区间总数-最多没有重叠的区间
        int n = intervals.length;
        return n - intervalSchedule(intervals);
    }

    public int intervalSchedule(int[][] intvs) {
        if (intvs.length == 0) {
            return 0;
        }
        // 分析：假设最优解是右侧已经有若干区间，我们讨论最左侧的那个。
        // 让这个最左侧的尽量靠左，这样右侧能有更多空间，容纳其他区间。能到最左的就是排序后结束时间最靠左的（最小的）有相同的结束时间随便选一个就行
        // 然后其他的位置依次往下找与这个区间不重合，并且结束时间尽量小的区间就行。因为这个就是除了第一个区间之后怎么找更多的不重合区间，是一个类似的子问题
        Arrays.sort(intvs, (o1, o2) -> o1[1] - o2[1]);
        int ans = 1;
        // 排序后第一个区间就是最左侧的区间，我们讨论它的右端点（结束时间）
        int end = intvs[0][1];
        for (int[] intv : intvs) {
            int start = intv[0];
            if (start >= end) {
                // 又找到了一个区间
                ans++;
                // 更新结束时间为这个新找的区间的结束时间
                end = intv[1];
            }
        }
        return ans;
    }

}
