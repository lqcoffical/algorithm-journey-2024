package binaryTree;

public class LowestCommonAncestor_lc236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null || root == p || root == q) {
            return root;
        }
        // 分别向左子树和右子树搜寻
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l != null && r != null) {
            // 左树也搜到、右树也搜到，返回root
            return root;
        }
        if (l == null && r == null) {
            // 都没搜到返回空，也就是从底层一层层往上返回
            // 代码会一直递归，到最底层叶子节点，再往下一层到第6行判断叶子.left是null，就返回null，10行l=null，说明没找到，
            // 同理叶子.right是null，11行r=null，就是两边都没找到，就再向上返回null。
            return null;
        }
        // 最后一种是一边搜到了，先搜到的肯定是包含关系，所以直接返回不空的
        return l != null ? l : r;
    }
}
