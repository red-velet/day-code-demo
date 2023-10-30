package linkedlist;

/**
 * author: chiou
 * createTime: 2023/10/30
 * description:
 */
public class ExchangeNode {
    public ListNode swapPairs(ListNode head) {
        //特殊情况
        if (head == null || head.next == null) {
            return head;
        }
        //两个节点及其以上进行交换
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = pre.next;
        while (cur != null && cur.next != null) {
            ListNode tmp = cur.next.next;
            pre.next = cur.next;
            cur.next.next = cur;
            cur.next = tmp;
            pre = cur;
            cur = tmp;
        }
        return dummy.next;
    }
}
