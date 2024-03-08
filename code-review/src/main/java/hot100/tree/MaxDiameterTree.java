package hot100.tree;

/**
 * <p>
 * 二叉树的直径
 * </p>
 *
 * @author red-velvet
 * @since 2024/3/5
 */
public class MaxDiameterTree {
    int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return result;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftLen = dfs(node.left);
        int rightLen = dfs(node.right);
        result = Math.max(result, leftLen + rightLen);
        return Math.max(leftLen, result) + 1;
    }
}
