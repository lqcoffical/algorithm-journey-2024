package backTrack;

import java.util.ArrayList;
import java.util.List;

public class Combine_lc077 {

    // leetcode用全局静态变量，不同的测试用例之间会一直加，加上一次的结果，所以组合这类题目还是不要用静态的，都写局部的
    // 然后当传家宝往下传
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k <= 0 || n <= 0) {
            return result;
        }
        List<Integer> path = new ArrayList<>();
        backtrack(n, k, 1, result, path);
        return result;
    }

    // 这道题也是讨论的从哪个位置开始做的组合
    public void backtrack(int n, int k, int startIndex, List<List<Integer>> result, List<Integer> path) {
        // base case 因为是固定长度组合，用长度来看
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        // 这个递归树的模型是到了每层多次调用，比如f(2)的时候调用f(3)、f(4)、f(5)
        // f(1)的时候还会调用f(3)、f(4)、f(5)，因为for循环和递归都控制i
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backtrack(n, k, i + 1, result, path);
            path.remove(path.size() - 1);
        }
    }
}
