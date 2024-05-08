package binaryTree;

public class WidthOfBinaryTree_lc662 {

    // 还是bfs每次处理一层的节点，然后用给节点编号的思想，因为可以视为满二叉树，左孩子是2*n，右孩子是2*n+1，这样可以不用管本来要补位置的null的节点
    // 一个数组维护节点，一个数组维护编号
    public static int MAXN = 3001;
    public static TreeNode[] nq = new TreeNode[MAXN];
    public static int[] iq = new int[MAXN];
    public static int l, r;

    public int widthOfBinaryTree(TreeNode root) {
        // 至少有一个头
        int ans = 1;
        l = r = 0;
        // 因为共用一个l、r，所以左神代码一个写了r，一个是r++
        nq[r] = root;
        iq[r] = 1;
        r++;
        while (l < r) {
            int size = r - l;
            ans = Math.max(ans, iq[r - 1] - iq[l] + 1);
            for (int i = 0; i < size; i++) {
                TreeNode node = nq[l];
                int id = iq[l];
                l++;
                if (node.left != null) {
                    nq[r] = node.left;
                    iq[r] = id * 2;
                    r++;
                }
                if (node.right != null) {
                    nq[r] = node.right;
                    iq[r] = id * 2 + 1;
                    r++;
                }
            }
        }
        return ans;
    }
}
