package binaryTree;

public class IsSymmetric_lc101 {
    public boolean isSymmetric(TreeNode root) {
        // 讨论得所有的节点都是对称的
        // base case
        if (root == null) return true;
        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null) return false;
        else if (left != null && right == null) return false;
        else if (left == null && right == null) return true;
        else if (left.val != right.val) return false;
        // 外侧
        boolean outside = compare(left.left, right.right);
        // 内侧
        boolean inside = compare(left.right, right.left);
        return outside && inside;

    }
}
