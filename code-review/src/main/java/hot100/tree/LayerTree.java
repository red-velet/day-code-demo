package hot100.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * <p>
 * 二叉树的层次遍历
 * </p>
 *
 * @author red-velvet
 * @since 2024/3/5
 */
public class LayerTree {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> path = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                path.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(path);
        }
        return result;
    }
}
