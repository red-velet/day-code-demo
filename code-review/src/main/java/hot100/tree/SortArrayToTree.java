package hot100.tree;

/**
 * <p>
 * 将有序数组/链表转化为二叉搜索树
 * </p>
 *
 * @author red-velvet
 * @since 2024/3/5
 */
public class SortArrayToTree {
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

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode mid = getMidNode(head);
        TreeNode node = new TreeNode(mid.val);
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(mid.next);
        return node;
    }

    private ListNode getMidNode(ListNode head) {
        ListNode pre = null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        if (pre != null) {
            pre.next = null;
        }
        return slow;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
