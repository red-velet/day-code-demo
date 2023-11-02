package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * author: chiou
 * createTime: 2023/11/2
 * description: 二叉树的前中后序遍历
 */
public class TreeErgodic {
    //前序
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        recursion(list, root);
        return list;
    }

    public void recursion(List<Integer> list, TreeNode root) {
        if (root != null) {
            list.add(root.val);
            if (root.left != null) {
                recursion(list, root.left);
            }
            if (root.right != null) {
                recursion(list, root.right);
            }
        }

    }

    //中序
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        recursionInorder(list, root);
        return list;
    }


    public void recursionInorder(List<Integer> list, TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                recursionInorder(list, root.left);
            }
            list.add(root.val);
            if (root.right != null) {
                recursionInorder(list, root.right);
            }
        }
    }

    //后序
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        recursionPostorder(list, root);
        return list;
    }

    public void recursionPostorder(List<Integer> list, TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                recursionPostorder(list, root.left);
            }
            if (root.right != null) {
                recursionPostorder(list, root.right);
            }
            list.add(root.val);
        }
    }

    //回溯-前序
    public List<Integer> preorderTraversalStack(TreeNode root) {
        //根左右
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            root = node.right;
        }
        return list;
    }

    //回溯-中序
    public List<Integer> inorderTraversalStack(TreeNode root) {
        //左根右
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            root = node.right;
        }
        return list;
    }

    //回溯-后序
    public List<Integer> postorderTraversalStack(TreeNode root) {
        //左右根 - 根右左
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.right;
            }
            TreeNode node = stack.pop();
            root = node.left;
        }
        Collections.reverse(list);
        return list;
    }
}
