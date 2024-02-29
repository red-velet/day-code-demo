package hot100.linkedlist;

/**
 * <p>
 * 相交链表：走过的路径相同，遍历其走过的路径
 * </p>
 *
 * @author red-velvet
 * @since 2024/2/29
 */
public class IntersectingLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;
        while (q != p) {
            p = p != null ? p.next : headB;
            q = q != null ? q.next : headA;
        }
        return p;
    }
}
