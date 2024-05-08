package greedyAlgorithm.extremeValue;

public class WiggleMaxLength_lc376 {
    public int wiggleMaxLength(int[] nums) {
        // 经过分析后：这时一个找峰值的问题，因为差值在>0、<0摆动，一旦某一段是单调的，那么这个差值也不会改变正负
        // 为什么这样想就是【最长子序列】因为为了保证差值正负摆动，在单调的那一段，取任何一个值就行，取那个不会影响最终结果
        if (nums.length <= 1) {
            return nums.length;
        }
        // 当前一对的差值和前面一对的差值
        int curDiff = 0, preDiff = 0;
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i - 1];
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                ans++;
                preDiff = curDiff;
            }
        }
        return ans;
    }
}
