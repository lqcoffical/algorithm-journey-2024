package binaryTree;

public class PreOrderCodec_lc297 {

    // 还是遵循先序的逻辑，怎么序列化就怎么反序列化，就是翻译
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder builder = new StringBuilder();
            ser(root, builder);
            return builder.toString();
        }

        public void ser(TreeNode root, StringBuilder builder) {
            if (root == null) {
                // 这个null换成什么符号都可以，只要是可以正向、反向解析出来就行
                builder.append("null,");
            } else {
                builder.append(root.val + ",");
                ser(root.left, builder);
                ser(root.right, builder);
            }
        }

        // 记录当前数组消费到哪里了。因为要在递归里存这个值，所以写成全局变量
        public static int cnt;

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] vals = data.split(",");
            cnt = 0;
            return des(vals);
        }

        public TreeNode des(String[] vals) {
            String cur = vals[cnt++];
            if (cur.equals("null")) {
                return null;
            } else {
                TreeNode node = new TreeNode(Integer.valueOf(cur));
                node.left = des(vals);
                node.right = des(vals);
                return node;
            }
        }
    }

}
