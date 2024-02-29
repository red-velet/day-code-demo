package hot100.linkedlist;

/**
 * <p>
 * k个一组反转链表
 * </p>
 *
 * @author red-velvet
 * @since 2024/2/29
 */
public class ReverseKGroupLinkedList {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode start = dummy;
        ListNode end = dummy;
        while (true) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            //断开前记录后面再连接
            ListNode startNext = start.next;
            ListNode endNext = end.next;
            end.next = null;
            start.next = reverse(start.next);
            startNext.next = endNext;

            start = startNext;
            end = startNext;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
