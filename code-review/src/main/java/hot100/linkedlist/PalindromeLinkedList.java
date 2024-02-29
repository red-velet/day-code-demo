package hot100.linkedlist;

import java.util.Stack;

/**
 * <p>
 * 回文链表：找到中点，反转后断链表，进行遍历比较
 * </p>
 *
 * @author red-velvet
 * @since 2024/2/29
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        slow = reverseList(slow);
        fast = head;
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }

    public boolean isPalindrome2(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        int len = 0;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
            len++;
        }
        p = head;
        len = len >> 1;
        while (len > 0) {
            if (p.val != stack.pop()) {
                return false;
            }
            p = p.next;
            len--;
        }
        return true;
    }
}
