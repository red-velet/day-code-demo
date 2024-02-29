package hot100.linkedlist;

/**
 * <p>
 * 两数相加
 * </p>
 *
 * @author red-velvet
 * @since 2024/2/29
 */
public class AddTwoNumberLinkedList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int sum = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            sum = sum / 10;
        }
        return dummy.next;
    }
}
