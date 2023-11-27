package tree;

/**
 * author: chiou
 * createTime: 2023/11/27
 * description: 合并二叉树
 */
public class MergeTree {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return build(root1, root2);
    }

    private TreeNode build(TreeNode root1, TreeNode root2) {
        int val = 0;
        if (root1 == null) {
            return root2;
        } else {
            val += root1.val;
        }
        if (root2 == null) {
            return root1;
        } else {
            val += root2.val;
        }
        TreeNode node = new TreeNode(val);
        node.left = build(root1.left, root2.left);
        node.right = build(root1.right, root2.right);
        return node;
    }
}
