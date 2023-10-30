package linkedlist;

/**
 * author: chiou
 * createTime: 2023/10/30
 * description: 删除倒数第n个节点
 */
public class DeleteNNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //特殊情况
        if (head == null) {
            return head;
        }
        //找到待删除节点的前一个节点
        ListNode dummy = new ListNode(-1, head);
        //先找到链表长度
        int len = 0;
        ListNode pre = dummy;
        ListNode cur = pre.next;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        cur = pre.next;
        for (int i = 0; i < len - n; i++) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = cur.next;
        cur.next = null;
        return dummy.next;
    }

    //进阶-一次扫描
    public ListNode removeNthFromEndPlus(ListNode head, int n) {
        //找到待删除节点的前一个节点
        ListNode dummy = new ListNode(-1, head);
        //先找到链表长度
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
