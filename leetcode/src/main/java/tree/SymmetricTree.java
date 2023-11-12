package tree;

/**
 * author: chiou
 * createTime: 2023/11/12
 * description:
 */
public class SymmetricTree {
    //对称二叉树
    public boolean isSymmetric(TreeNode root) {
        //思路：检测根节点的左右子树是不是互为镜像的
        return check(root.left, root.right);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return check(p.left, q.right) && check(p.right, q.left);
    }
}
