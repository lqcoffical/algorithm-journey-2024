package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class PathSum_lc113 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            List<Integer> path = new ArrayList<>();
            f(root, targetSum, 0, path, ans);
        }
        return ans;
    }

    public static void f(TreeNode cur, int targetSum, int sum, List<Integer> path, List<List<Integer>> ans) {
        if (cur.left == null && cur.right == null) {
            // 叶节点
            if (cur.val + sum == targetSum) {
                path.add(cur.val);
                copy(path, ans);
                // 还有一个是收集答案之后
                path.remove(path.size() - 1);
            }
        } else {
            // 不是叶节点
            path.add(cur.val);
            if (cur.left != null) {
                f(cur.left, targetSum, sum + cur.val, path, ans);
            }
            if (cur.right != null) {
                f(cur.right, targetSum, sum + cur.val, path, ans);
            }
            // 注意两个地方要回退恢复现场，一个是左右都走过了之后
            path.remove(path.size() - 1);
        }
    }

    public static void copy(List<Integer> path, List<List<Integer>> ans) {
        List<Integer> copy = new ArrayList<>();
        for (Integer num : path) {
            copy.add(num);
        }
        ans.add(copy);
    }

}
