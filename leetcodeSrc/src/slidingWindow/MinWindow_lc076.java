package slidingWindow;

public class MinWindow_lc076 {

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        char[] str = s.toCharArray();
        char[] tar = t.toCharArray();
        // 256的数组能放下所有字符，用来统计词频
        int[] cnts = new int[256];
        // 构造一个欠债表，负数是还需要的，正数是多出来的
        for (char cha : tar) {
            cnts[cha]--;
        }
        int len = Integer.MAX_VALUE;
        // 研究从哪个位置开头
        int start = 0;
        // 这里注意用r右边界做控制条件，r不越界
        for (int l = 0, r = 0, debt = tar.length; r < str.length; r++) {
            // 这里其实还是先引用再++，就是说判断小于0说明还欠，账单debt可以--。然后都是要++的，所以如果分开写不能写在if里面，要写在外面
            if (cnts[str[r]]++ < 0) {
                debt--;
            }
            // 说明都还完了，是其中一个解，看覆盖子串能不能尽量短
            if (debt == 0) {
                while (cnts[str[l]] > 0) {
                    cnts[str[l++]]--;
                }
                // 跳出while循环后收集答案，注意这个if是在if(debt == 0)里面的
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    start = l;
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
