package binaryTree;

public class InvertTree_lc226 {
    public TreeNode invertTree(TreeNode root) {
        // 先序遍历解决问题，递归到叶子节点再下一层null，交换之后往上返回
        // base case
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
