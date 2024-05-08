package greedyAlgorithm.intervalPlanning;

import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShots_lc452 {

    public int findMinArrowShots(int[][] points) {
        // 每一只箭都是在某个气球的右边界，因为这样既可以保证气球炸爆，右尽量往右移了争取能挂到更多的气球
        // 所以根据右边界进行排序，找到右边界最靠左的那个气球，就是第一支箭。然后把这支箭射到的气球移除，再找下一个
        // 开始位置要小于射箭位置的就能被射到，第一个不满足的，就用它的结束位置来作为下一次射箭位置
        if (points.length == 0) {
            return 0;
        }
        // 要用这种写法，lambda表达式那种相减的，在比较负数时会有问题，测试用例有负数的情况
        Arrays.sort(points, (Comparator.comparingInt(o -> o[1])));
        // 第一个射箭位置
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon : points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                ans++;
            }
        }
        return ans;
    }

}
