package hot100.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 后序遍历
 * </p>
 *
 * @author red-velvet
 * @since 2024/3/5
 */
public class BackOrder {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    public void dfs(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        } else {
            if (node.left != null) {
                dfs(node.left, result);
            }
            if (node.right != null) {
                dfs(node.right, result);
            }
            result.add(node.val);
        }
    }
}
