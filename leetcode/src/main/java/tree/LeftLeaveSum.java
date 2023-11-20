package tree;

import java.util.Stack;

/**
 * author: chiou
 * createTime: 2023/11/20
 * description:
 */
public class LeftLeaveSum {
    //左叶子之和
    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return sum;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null && node.left.left == null && node.left.right == null) {
            sum += node.left.val;
        }
        dfs(node.left);
        dfs(node.right);
    }


    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null && node.left.left == null && node.left.right == null) {
                result += node.left.val;
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return result;
    }


}
