package hot100.linkedlist;

/**
 * <p>
 * 删除倒数第K个节点
 * </p>
 *
 * @author red-velvet
 * @since 2024/2/29
 */
public class RemoveKNodeLinkedList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
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
