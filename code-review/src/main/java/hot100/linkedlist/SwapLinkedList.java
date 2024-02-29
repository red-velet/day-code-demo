package hot100.linkedlist;

/**
 * <p>
 * 两两交换链表节点值，但是不修改节点值
 * </p>
 *
 * @author red-velvet
 * @since 2024/2/29
 */
public class SwapLinkedList {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = pre.next;
        while (cur != null && cur.next != null) {
            ListNode tmp = cur.next;
            pre.next = tmp;
            cur.next = tmp.next;
            tmp.next = cur;

            //更新位置
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
