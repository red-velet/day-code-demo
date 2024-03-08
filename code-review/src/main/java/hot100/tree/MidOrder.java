package hot100.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 * 中序遍历
 * </p>
 *
 * @author red-velvet
 * @since 2024/3/5
 */
public class MidOrder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    public void dfs(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        } else {
            if (root.left != null) {
                dfs(root.left, result);
            }
            result.add(root.val);
            if (root.right != null) {
                dfs(root.right, result);
            }
        }
    }


    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                if (root.left != null) {
                    root = root.left;
                }
                stack.add(root);
            }
            TreeNode node = stack.pop();
            result.add(node.val);
            root = node.right;
        }
        return result;
    }

    public void backing() {

    }
}
