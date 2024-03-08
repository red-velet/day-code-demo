package hot100.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <p>
 * 二叉树最大深度
 * </p>
 *
 * @author red-velvet
 * @since 2024/3/5
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        int maxLen = 0;
        if (root == null) {
            return maxLen;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            maxLen++;
            int followSize = queue.size();
            while (followSize-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return maxLen;
    }
}
