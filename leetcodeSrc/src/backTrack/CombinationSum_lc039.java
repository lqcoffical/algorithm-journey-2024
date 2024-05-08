package backTrack;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_lc039 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(candidates, target, 0, 0, result, path);
        return result;
    }

    public static void backtrack(int[] candidates, int target, int sum, int startIndex, List<List<Integer>> result, List<Integer> path) {
        // base case
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(path));
        }
        for (int i = startIndex; i < candidates.length; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            // 向下调用递归，每个数可以用多次，所以这个i没变
            backtrack(candidates, target, sum, i, result, path);
            // 恢复现场
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
