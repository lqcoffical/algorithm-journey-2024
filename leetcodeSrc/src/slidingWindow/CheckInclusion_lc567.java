package slidingWindow;

public class CheckInclusion_lc567 {

    public static boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        char[] tar = s1.toCharArray();
        char[] str = s2.toCharArray();
        // 还是构造欠债表的思路，然后滑动窗口
        int[] cnts = new int[256];
        for (char cha : tar) {
            cnts[cha]--;
        }
        for (int l = 0, r = 0, debt = tar.length; r < str.length; r++) {
            // 先引用再++，先小于0说明还欠，账单--。本来就大于等于0的，本来就是不需要的
            if (cnts[str[r]]++ < 0) {
                debt--;
            }
            // 子串要长度相等，所以此时收缩左边界
            while (r - l + 1 > tar.length) {
                // 把左边界字符移除窗口，维护欠债表
                // 这里注意是<= 因为出窗口的时候不一定是正好不欠，也可能是已经欠账了
                if (cnts[str[l]] <= 0) {
                    debt++;
                }
                cnts[str[l++]]--;
            }
            if (debt == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1= "qff";
        String s2= "ifisnoskikfqzrmzlv";
        boolean ans = checkInclusion(s1, s2);
        System.out.println(ans);
    }
}
