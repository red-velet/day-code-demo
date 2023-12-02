package tree;

import java.util.*;

/**
 * author: chiou
 * createTime: 2023/11/28
 * description:
 */
public class BSTSearch {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        TreeNode treeNode = null;
        if (root.val > val) {
            treeNode = searchBST(root.right, val);
        }
        if (root.val < val) {
            treeNode = searchBST(root.left, val);
        }
        return treeNode;
    }

    long preNodeVal = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= preNodeVal) {
            return false;
        }
        preNodeVal = root.val;
        return isValidBST(root.right);
    }

    //二叉搜索树的最小绝对差
    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return result;
    }

    TreeNode pre = null;
    int result = Integer.MAX_VALUE;

    public void traversal(TreeNode curr) {
        if (curr == null) {
            return;
        }
        //左
        traversal(curr.left);
        //根
        if (pre != null) {
            result = Math.min(result, curr.val - pre.val);
        }
        pre = curr;
        //右
        traversal(curr.right);
    }

    //二叉搜索树的众数
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        ArrayList<Integer> modes = new ArrayList<>();
        //中序遍历获取递增数组
        list(root, modes);
        //记录每个元素的次数
        int maxFrequency = 0;
        for (Integer val : modes) {
            frequencyMap.put(
                    val,
                    frequencyMap.getOrDefault(val, 0) + 1
            );
            maxFrequency = Math.max(maxFrequency, frequencyMap.get(val));
        }
        //记录最大次数的元素
        ArrayList<Integer> result = new ArrayList<>();
        Iterator<Map.Entry<Integer, Integer>> iterator = frequencyMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            Integer val = entry.getKey();
            Integer count = entry.getValue();
            if (count == maxFrequency) {
                result.add(val);
            }
        }
        //返回结果
        int[] zs = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            zs[i] = result.get(i);
        }
        return zs;
    }

    private void list(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        //左
        list(root.left, result);
        //根
        result.add(root.val);

        //右
        list(root.right, result);
    }

    public int[] findMode2(TreeNode root) {
        //中序遍历获取递增数组
        list2(root);
        //返回结果
        int[] zs = new int[result2.size()];
        for (int i = 0; i < result2.size(); i++) {
            zs[i] = result2.get(i);
        }
        return zs;
    }

    ArrayList<Integer> result2 = new ArrayList<>();
    int count = 0;
    int maxCount = 0;
    TreeNode pre2 = null;

    private void list2(TreeNode curr) {
        if (curr == null) {
            return;
        }
        //左
        list2(curr.left);

        //根
        //记录前一个节点和当前节点
        //初始化众数
        if (pre2 == null) {
            count = 1;
        } else if (pre2.val == curr.val) {
            count++;
        } else {
            count = 1;
        }
        pre2 = curr;
        //记录最新的众数，清除原来的内容
        if (count == maxCount) {
            result2.add(curr.val);
        }
        if (count > maxCount) {
            maxCount = count;
            result2.clear();
            result2.add(curr.val);
        }
        //右
        list2(curr.right);
    }
}
