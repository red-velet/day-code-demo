package linkedlist;

/**
 * author: chiou
 * createTime: 2023/10/26
 * description:反转链表
 */
public class ReverseList {
    //双指针
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    //递归
    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return head;
        }
        //1 -> 2 -> 3 ->4
        if (head.next == null) {
            return head.next;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public ListNode test2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        //1 -> 2 -> 3 ->4
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }


}
