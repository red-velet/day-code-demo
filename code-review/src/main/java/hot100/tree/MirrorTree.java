package hot100.tree;

/**
 * <p>
 * 镜像二叉树
 * </p>
 *
 * @author red-velvet
 * @since 2024/3/5
 */
public class MirrorTree {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    public boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null || right != null || (left.val != right.val)) {
            return false;
        }
        return check(left.left, right.right) && check(left.right, right.left);
    }
}
