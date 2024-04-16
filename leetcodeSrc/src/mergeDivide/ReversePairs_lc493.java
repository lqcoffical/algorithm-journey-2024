package mergeDivide;

public class ReversePairs_lc493 {

    public static int MAX_SIZE = 50001;

    public static int[] help = new int[MAX_SIZE];

    // leetcode主方法名写错也不行，后台会不认识这个方法，导致创建不出来
    public int reversePairs(int[] nums) {
        return counts(nums, 0, nums.length - 1);
    }

    public static int counts(int[] nums, int l, int r) {
        // 特判
        if (l == r) {
            return 0;
        }
        int m = l + (r - l) / 2;
        // 左侧+右侧+左跨右的
        return counts(nums, l, m) + counts(nums, m + 1, r) + merge(nums, l, m, r);
    }

    public static int merge(int[] nums, int l, int m, int r) {
        // 统计部分，为什么要先做，因为这个统计是在有序情况下做的，也就是上一次递归返回的得是有序的。
        // 最后一次调用递归，剩一个值不用merge，所以要先做统计
        int ans = 0;
        for (int i = l, j = m + 1; i <= m; i++) {
            //以左测指针为基准去校验右侧是否符合
            while (j <= r && (long) nums[i] > (long) nums[j] * 2) {
                j++;
            }
            // 因为计算的是跨左右的结果，也就是每一个i（在左侧），要找右侧有几个值符合条件，而右侧是m+1开始的
            ans += j - m - 1;
        }
        // 正常的merge
        int i = l;
        int a = l;
        int b = m + 1;
        while (a <= m && b <= r) {
            help[i++] = nums[a] <= nums[b] ? nums[a++] : nums[b++];
        }
        // 两侧数组比大小复制，肯定有一边是先用完的，把另一边的复制过来
        while (a <= m) {
            help[i++] = nums[a++];
        }
        while (b <= r) {
            help[i++] = nums[b++];
        }
        // 把辅助数组的值刷回到原数组达到有序
        for (i = l; i <= r; i++) {
            nums[i] = help[i];
        }
        return ans;
    }

}
