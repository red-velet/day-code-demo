package linkedlist;

/**
 * author: chiou
 * createTime: 2023/9/15
 * description: 移除链表元素
 */
public class RemoveLinkedListNode {
    /**
     * 给你一个链表的头节点 head 和一个整数 val ，
     * 请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        //头节点命中，删除头节点
        while (head != null && head.val == val) {
            head = head.next;
        }
        // 已经为null，提前退出
        if (head == null) {
            return head;
        }
        //遍历中删除，待删除节点的前牵手他的后
        ListNode front = head;
        ListNode curr = front.next;

        while (curr != null) {
            if (curr.val == val) {
                front.next = curr.next;
            } else {
                front = curr;
            }
            curr = curr.next;
        }
        return head;
    }

    public ListNode removeElements2(ListNode head, int val) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode curr = pre.next;
        while (curr != null) {
            if (curr.val == val) {
                pre.next = curr.next;
            } else {
                pre = curr;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveLinkedListNode main = new RemoveLinkedListNode();
        ListNode listNode = new ListNode(1, null);
        listNode.next = new ListNode(2, null);
        listNode.next.next = new ListNode(3, null);
        listNode.next.next.next = new ListNode(4, null);
        ListNode newHead = main.removeElements2(listNode, 3);
        ListNode p = newHead;
        while (p != null) {
            System.out.print("->" + p.val);
            p = p.next;
        }
    }
}


