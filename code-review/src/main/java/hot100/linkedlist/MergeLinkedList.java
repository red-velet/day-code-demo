package hot100.linkedlist;

import java.util.PriorityQueue;

/**
 * <p>
 * 合并有序链表
 * </p>
 *
 * @author red-velvet
 * @since 2024/2/29
 */
public class MergeLinkedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                p.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                p.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            p = p.next;
        }
        p.next = list1 == null ? list1 : list2;
        return dummy.next;
    }


    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) {
                heap.offer(list);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (!heap.isEmpty()) {
            ListNode minNode = heap.poll();
            p.next = minNode;
            p = p.next;
            if (minNode.next != null) {
                heap.offer(minNode.next);
            }
        }
        return dummy.next;
    }
}
