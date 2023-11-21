package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * author: chiou
 * createTime: 2023/11/21
 * description:
 */
public class PathSum {
    //路径总和1
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //通过求和转换为求targetSum-val
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum - root.val == 0;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    //路径总和2
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, result, new ArrayList<>(), targetSum);
        return result;
    }

    private void dfs(TreeNode node, List<List<Integer>> result, List<Integer> paths, int targetSum) {
        paths.add(node.val);
        targetSum -= node.val;
        if (node.left == null && node.right == null && targetSum == 0) {
            result.add(new ArrayList<>(paths));
        }
        if (node.left != null) {
            dfs(node.left, result, paths, targetSum);
        }
        if (node.right != null) {
            dfs(node.right, result, paths, targetSum);
        }
        paths.remove(paths.size() - 1);
    }

}
