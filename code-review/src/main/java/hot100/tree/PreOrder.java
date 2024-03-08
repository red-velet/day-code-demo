package hot100.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 * 前序遍历
 * </p>
 *
 * @author red-velvet
 * @since 2024/3/5
 */
public class PreOrder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    public void dfs(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        } else {
            result.add(node.val);
            if (node.left != null) {
                dfs(node.left, result);
            }
            if (node.right != null) {
                dfs(node.right, result);
            }
        }
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                result.add(root.val);
                root = root.left;
            }
            TreeNode node = stack.pop();
            root = node.right;
        }
        return result;
    }
}
