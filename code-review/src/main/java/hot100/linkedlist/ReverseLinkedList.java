package hot100.linkedlist;

/**
 * <p>
 * 反转链表
 * </p>
 *
 * @author red-velvet
 * @since 2024/2/29
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
