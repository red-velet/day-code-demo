package hot100.tree;

/**
 * <p>
 * 二叉搜索树最k小元素
 * </p>
 *
 * @author red-velvet
 * @since 2024/3/5
 */
public class MinElementInTree {
    int count;
    int result;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return result;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        count--;
        if (count == 0) {
            result = node.val;
            return;
        }
        dfs(node.right);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = build(nums, l, mid - 1);
        node.right = build(nums, mid + 1, r);
        return node;
    }

    public static void main(String[] args) {
        MinElementInTree main = new MinElementInTree();

        TreeNode node = main.sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7});
        int i = main.kthSmallest(node, 3);
        System.out.println(i);
    }
}
