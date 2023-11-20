package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * author: chiou
 * createTime: 2023/11/20
 * description:
 */
public class TreePath {
    //二叉树的所有路径
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        traverse(root, new ArrayList<Integer>(), result);
        return result;
    }

    public void traverse(TreeNode node, List<Integer> paths, List<String> result) {
        paths.add(node.val);
        //递归终止条件
        if (node.left == null && node.right == null) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                builder.append(paths.get(i)).append("->");
            }
            builder.append(paths.get(paths.size() - 1));
            result.add(builder.toString());
            return;
        }
        //递归和回溯
        if (node.left != null) {
            traverse(node.left, paths, result);
            paths.remove(paths.size() - 1);
        }
        if (node.right != null) {
            traverse(node.right, paths, result);
            paths.remove(paths.size() - 1);
        }
    }
}
