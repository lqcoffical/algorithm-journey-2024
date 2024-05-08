package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class ZigzagLevelOrder_lc103 {
    // 这道题小米面试考过原题，用左神的方法写，用一个开关控制从左向右还是从右向左收集答案
    // 也不用讨论什么怎么入队列。用deque写得话，首先弹出队列和新节点入队列不能同时搞，不然就会污染队列，导致乱了
    // 再者收集每层的答案后还得讨论入队列的顺序，从左往右还是从右往左，很麻烦还错
    // l~r范围的数组是队列，始终是[l,r)区间
    public static int MAXN = 2001;
    public static TreeNode[] queue = new TreeNode[MAXN];
    public static int l, r;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            // 清空队列
            l = r = 0;
            queue[r++] = root;
            // false从左往右，true从右往左
            boolean flag = false;
            while (l < r) {
                int size = r - l;
                List<Integer> level = new ArrayList<>();
                for (int i = flag ? r - 1 : l, j = flag ? -1 : 1, k = 0; k < size; i += j, k++) {
                    TreeNode cur = queue[i];
                    level.add(cur.val);
                }
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue[l++];
                    if (cur.left != null) {
                        queue[r++] = cur.left;
                    }
                    if (cur.right != null) {
                        queue[r++] = cur.right;
                    }
                }
                ans.add(level);
                flag = !flag;
            }
        }
        return ans;
    }
}
