package hot100.tree;

/**
 * <p>
 * 验证二叉搜索树：中序遍历
 * </p>
 *
 * @author red-velvet
 * @since 2024/3/5
 */
public class CheckSearchTree {
    long val = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= val) {
            return false;
        }
        val = root.val;
        return isValidBST(root.right);
    }
}
