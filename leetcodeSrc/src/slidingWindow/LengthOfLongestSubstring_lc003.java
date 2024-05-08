package slidingWindow;

public class LengthOfLongestSubstring_lc003 {

    public int lengthOfLongestSubstring(String s) {
        // 欠债表还是用256的数组来表示，滑动窗口
        int[] debt = new int[256];
        int l = 0, r = 0;
        int ans = 0;
        char[] chars = s.toCharArray();
        while (r < chars.length) {
            // 也可以r++在后面单独写一句
            char c = chars[r++];
            debt[c]++;
            while (debt[c] > 1) {
                char d = chars[l++];
                debt[d]--;
            }
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}
