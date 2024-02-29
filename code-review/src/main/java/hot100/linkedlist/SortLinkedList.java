package hot100.linkedlist;

/**
 * <p>
 * 排序链表
 * </p>
 *
 * @author red-velvet
 * @since 2024/2/29
 */
public class SortLinkedList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //拆分
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        // 快指针的速度是慢指针的两倍，所以当快指针到达链表尾部时，慢指针正好走过了链表的一半。
        // 因此，慢指针所在的位置就是链表的中间节点。
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //部分排序
        // 分割链表
        pre.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        //合并
        return merge(l1, l2);
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                p.next = head1;
                head1 = head1.next;
            } else {
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }
        p.next = head1 == null ? head2 : head1;
        return dummy.next;
    }

}
