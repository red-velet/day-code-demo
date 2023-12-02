package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * author: chiou
 * createTime: 2023/12/2
 * description:
 */
public class TreeSearchCRUD {
    //二叉树的插入
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 如果根节点为空，直接将新值作为根节点返回
        if (root == null) {
            return new TreeNode(val);
        }

        // 获取当前节点的值
        int currVal = root.val;

        // 如果要插入的值小于当前节点的值，向左子树插入
        if (val < currVal) {
            // 递归调用 insertIntoBST，更新左子树
            root.left = insertIntoBST(root.left, val);
        }

        // 如果要插入的值大于当前节点的值，向右子树插入
        if (val > currVal) {
            // 递归调用 insertIntoBST，更新右子树
            root.right = insertIntoBST(root.right, val);
        }

        // 返回根节点（包含新插入值的树）
        return root;
    }

    //删除二叉搜索树节点
    public TreeNode deleteNode(TreeNode root, int key) {
        // 如果树为空，直接返回 null
        if (root == null) {
            return null;
        }

        // 先获取树的中序遍历结果
        List<Integer> list = new ArrayList<>();
        getList(root, list);

        // 根据中序遍历的结果删除对应值的节点
        List<Integer> updatedList = new ArrayList<>();
        for (int val : list) {
            if (val != key) {
                updatedList.add(val);
            }
        }

        // 将更新后的值重新构建成二叉搜索树
        int[] updatedArray = new int[updatedList.size()];
        for (int i = 0; i < updatedList.size(); i++) {
            updatedArray[i] = updatedList.get(i);
        }

        return constructBST(updatedArray, 0, updatedArray.length - 1);
    }

    public void getList(TreeNode root, List<Integer> result) {
        if (root != null) {
            if (root.left != null) {
                getList(root.left, result);
            }
            result.add(root.val);
            if (root.right != null) {
                getList(root.right, result);
            }
        }
    }

    private TreeNode constructBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        // 找到中间元素作为当前子树的根节点
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        // 递归构建左子树和右子树
        root.left = constructBST(nums, start, mid - 1);
        root.right = constructBST(nums, mid + 1, end);
        return root;
    }

    public TreeNode deleteNodeMethod2(TreeNode root, int key) {
        // 如果树为空，直接返回 null
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null && root.right != null) {
                return root.right;
            } else if (root.right == null && root.left != null) {
                return root.left;
            } else {
                //二叉搜索树是中序遍历是一个有序数组，删除元素要保证有序性
                //找到比当前要删除节点元素稍大的节点即位
                TreeNode curr = root.right;
                while (curr.left != null) {
                    curr = curr.left;
                }
                curr.left = root.left;
                return root.right;
            }
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    //修剪二叉搜索树：区间内的才留存
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        // 如果根节点的值小于 low，则整个左子树都不在范围内，返回修剪后的右子树
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }

        // 如果根节点的值大于 high，则整个右子树都不在范围内，返回修剪后的左子树
        else if (root.val > high) {
            return trimBST(root.left, low, high);
        } else {
            // 根节点在范围内，则递归修剪左右子树
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }

        return root;
    }

    int sum = 0;

    //二叉搜索树的累加数
    public TreeNode convertBST(TreeNode root) {
        getSum(root);
        return root;
    }

    public TreeNode convertBST2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        getList(root, list);
        for (int i = 0; i < list.size(); i++) {
            int nums = 0;
            for (int j = i; j < list.size(); j++) {
                nums += list.get(i);
            }
            list.set(i, nums);
        }
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return constructBST(ints, 0, ints.length - 1);
    }

    public void getSum(TreeNode curr) {
        if (curr == null) {
            return;
        }
        getSum(curr.right);
        sum += curr.val;
        curr.val = sum;
        getSum(curr.left);
    }
}
