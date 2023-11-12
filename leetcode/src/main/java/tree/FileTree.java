package tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * author: chiou
 * createTime: 2023/11/12
 * description:
 */
public class FileTree {
    //反转二叉树
    public TreeNode invertTree(TreeNode root) {
        //思路：交换每一个节点的孩子节点
        //    1
        // 2     3
        //4 5    6 7
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        swap(root);
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        //思路：交换每一个节点的孩子节点
        //    1
        // 2     3
        //4 5    6 7
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                swap(node);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    public void swap(TreeNode treeNode) {
        TreeNode tmp = treeNode.left;
        treeNode.left = treeNode.right;
        treeNode.right = tmp;
    }


}
