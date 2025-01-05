package twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_lc018 {

    // 三数之和、四数之和的模型，都是找到一个确定值，然后另外两个值用双指针确定，时间复杂度可以降低n的一次幂
    // 找到一个确定值用for循环搞定，三数一个for，四数两层for
    // 注意数组先排序、去重的逻辑
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 四数之和的和是任意值，不像三数是0，所以不用剪枝判断
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int l = j + 1, r = n - 1;
                while (r > l) {
                    // 为了防止越界用long类型相加
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        // 去重逻辑，找到了一组答案之后再去去重
                        while (r > l && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (r > l && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        // 继续寻找下一组
                        l++;
                        r--;
                    } else if (sum < target) {
                        l++;
                    } else if (sum > target) {
                        r--;
                    }
                }
            }
        }
        return ans;
    }
}
