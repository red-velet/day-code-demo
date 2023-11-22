package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * author: chiou
 * createTime: 2023/11/22
 * description:
 */
public class ConstructTree {
    Map<Integer, Integer> pos = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //记录中序节点的索引位置
        int n = inorder.length;
        for (int i = 0; i < inorder.length; i++) {
            pos.put(inorder[i], i);
        }
        return build(inorder, postorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int il, int ir, int pl, int pr) {
        if (il > ir || pl > pr) {
            return null;
        }
        //通过后序遍历的根节点位置在中序中的位置，分割左右子树
        int k = pos.get(postorder[pr]) - il;
        TreeNode root = new TreeNode(postorder[pr]);
        root.left = build(inorder, postorder, il, il + k - 1, pl, pl + k - 1);
        root.right = build(inorder, postorder, il + k + 1, ir, pl + k, pr - 1);
        return root;
    }

    public static void main(String[] args) {
        ConstructTree constructTree = new ConstructTree();
        TreeNode node = constructTree.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println("node = " + node);
    }

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return build2(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode build2(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if (il > ir || pl > pr) {
            return null;
        }
        //通过后序遍历的根节点位置在中序中的位置，分割左右子树
        int k = map.get(preorder[pl]) - il;
        TreeNode root = new TreeNode(preorder[pl]);
        root.left = build(preorder, inorder, pl + 1, pl + k, il, il + k - 1);
        root.right = build(preorder, inorder, pl + k + 1, pr, il + k + 1, ir);
        return root;
    }
}
