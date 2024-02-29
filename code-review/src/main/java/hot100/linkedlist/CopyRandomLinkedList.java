package hot100.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 复制随机链表
 * </p>
 *
 * @author red-velvet
 * @since 2024/2/29
 */
public class CopyRandomLinkedList {
    public Node copyRandomList(Node head) {
        Node p = head;
        Map<Node, Node> map = new HashMap<>();
        while (p != null) {
            map.put(p, new Node(p.val));
            p = p.next;
        }
        p = head;
        while (p != null) {
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}