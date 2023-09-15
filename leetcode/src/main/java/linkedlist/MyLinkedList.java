package linkedlist;

/**
 * author: chiou
 * createTime: 2023/9/15
 * description: 设计链表
 */
public class MyLinkedList {
    int size = 0;

    ListNode head = null;

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public MyLinkedList() {
        head = new ListNode(0, null);
    }

    public int get(int index) {
        ListNode p = head.next;
        if (index >= 0 && index < size) {
            for (int i = 0; i < index; i++) {
                if (p == null) {
                    return -1;
                }
                p = p.next;
            }
            if (p == null) {
                return -1;
            }
            return p.val;
        } else {
            return -1;
        }
    }

    public void addAtHead(int val) {
        ListNode listNode = new ListNode(val, null);
        listNode.next = head.next;
        head.next = listNode;
        size++;
    }

    public void addAtTail(int val) {
        ListNode listNode = new ListNode(val, null);
        ListNode p = head.next;
        while (p.next != null) {
            p = p.next;
        }
        p.next = listNode;
        size++;
    }

    public void addAtIndex(int index, int val) {
        ListNode listNode = new ListNode(val, null);
        ListNode pre = head;
        if (index >= 0 && index <= size - 1) {
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            listNode.next = pre.next;
            pre.next = listNode;
        }
        size++;
    }

    public void deleteAtIndex(int index) {
        ListNode pre = head;
        if (index >= 0 && index <= size - 1) {
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            pre.next = pre.next.next;
        }
        size--;
    }
}
