package linkedlist;

/**
 * author: chiou
 * createTime: 2023/10/31
 * description: 两个链表的相交节点
 */
public class IntersectNode {
    //本质就是一个数学问题，让他两的长度相等
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;
        while (p != q) {
            if (p == null) {
                p = headB;
            } else {
                p = p.next;
            }
            if (q == null) {
                q = headA;
            } else {
                q = q.next;
            }
        }
        return p;
    }
}
