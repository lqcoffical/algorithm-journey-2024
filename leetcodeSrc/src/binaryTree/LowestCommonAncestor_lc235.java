package binaryTree;

public class LowestCommonAncestor_lc235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 从root开始出发，要直到遇到一个值、或者处于两者之间停止
        while (root.val != p.val && root.val != q.val) {
            if (Math.min(p.val, q.val) < root.val && root.val < Math.max(p.val, q.val)) {
                break;
            }
            root = root.val < Math.min(p.val, q.val) ? root.right : root.left;
        }
        return root;
    }
}
