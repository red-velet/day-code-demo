package hot100.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * <p>
 * 二叉树的右视图
 * </p>
 *
 * @author red-velvet
 * @since 2024/3/5
 */
public class RightViewTree {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode node = queue.poll();
            for (int i = 0; i < size; i++) {
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (i == size - 1) {
                    result.add(node.val);
                }
            }
        }
        return result;
    }


    List<Integer> result = new ArrayList<>();
    int depth;

    public List<Integer> rightSideView2(TreeNode root) {
        depth = 0;
        dfs(root, depth);
        return result;
    }

    public void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (depth == result.size()) {
            result.add(node.val);
        }
        depth++;
        dfs(node.right, depth);
        dfs(node.left, depth);
    }
}
