package binaryTree;

public class MaxDepth_lc104 {

    // 可以把细节写出来好理解
    // 递归出口是最后一层，叶子节点左右深度都是0，取最大是0，+1加自己的层数，所以叶子节点深度是1
    public int maxDepth(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
