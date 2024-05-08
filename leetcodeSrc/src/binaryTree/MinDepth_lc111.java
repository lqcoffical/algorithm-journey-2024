package binaryTree;

public class MinDepth_lc111 {

    // 和二叉树最大深度不一样，这个要判断是不是叶子节点
    public int minDepth(TreeNode root) {
        // base case
        if (root == null) {
            // 当前的树是空树
            return 0;
        }
        if (root.left == null && root.right == null) {
            // 当前来到了叶子节点，节点数量1
            return 1;
        }
        int ldepth = Integer.MAX_VALUE;
        int rdepth = Integer.MAX_VALUE;
        // 这里要判断是不是空，如果是空传进来返回0，但不一定是叶子节点，所以会混淆答案，比如只有右孩子的树，想链表一样
        if (root.left != null) {
            ldepth = minDepth(root.left);
        }
        if (root.right != null) {
            rdepth = minDepth(root.right);
        }
        return Math.min(ldepth, rdepth) + 1;
    }
}
