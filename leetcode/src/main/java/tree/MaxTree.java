package tree;

/**
 * author: chiou
 * createTime: 2023/11/27
 * description: 最大二叉树
 */
public class MaxTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length);
    }

    private TreeNode build(int[] nums, int l, int r) {
        if (l > r - 1) {
            return null;
        }
        int maxIndex = l;
        int maxVal = nums[maxIndex];
        for (int i = maxIndex + 1; i < r; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        TreeNode node = new TreeNode(maxVal);
        node.left = build(nums, l, maxIndex);
        node.right = build(nums, maxIndex + 1, r);
        return node;
    }
}
