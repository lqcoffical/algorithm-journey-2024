package binarySearch;

public class FindPeakElement_lc162 {

    public int findPeakElement(int[] nums) {
        int length = nums.length;
        // 先检查两端
        if (length == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[length - 1] > nums[length - 2]) {
            return length - 1;
        }
        int l = 1, r = length - 2, m, ans = -1;
        // 要牢记两端都是无穷小，这样中间必有峰值
        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] < nums[m - 1]) {
                r = m - 1;
            } else if (nums[m] < nums[m + 1]) {
                l = m + 1;
            } else {
                // 这个else分支就是 m-1<m>m+1 的情况，m就是峰值
                ans = m;
                break;
            }
        }
        return ans;
    }

}
