package hot100.linkedlist;

import java.util.HashMap;

/**
 * <p>
 * LRU缓存
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * </p>
 *
 * @author red-velvet
 * @since 2024/2/29
 */
public class LRUCache {
    HashMap<Integer, MyNode> map;
    MyDoubleLinkedList cache;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.cache = new MyDoubleLinkedList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // 将该数据提升为最近使用的
        makeRecently(key);
        return map.get(key).val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // 删除旧的数据
            deleteKey(key);
            // 新插入的数据为最近使用的数据
            addRecently(key, value);
            return;
        }

        if (capacity == cache.size()) {
            // 删除最久未使用的元素
            removeLeastRecently();
        }
        // 添加为最近使用的元素
        addRecently(key, value);
    }

    private void makeRecently(int key) {
        MyNode node = map.get(key);
        // 先从链表中删除这个节点
        cache.remove(node);
        // 重新插到队尾
        cache.addLast(node);
    }

    /* 添加最近使用的元素 */
    private void addRecently(int key, int val) {
        MyNode x = new MyNode(key, val);
        // 链表尾部就是最近使用的元素
        cache.addLast(x);
        // 别忘了在 map 中添加 key 的映射
        map.put(key, x);
    }

    /* 删除某一个 key */
    private void deleteKey(int key) {
        MyNode node = map.get(key);
        // 从链表中删除
        cache.remove(node);
        // 从 map 中删除
        map.remove(key);
    }

    /* 删除最久未使用的元素 */
    private void removeLeastRecently() {
        // 链表头部的第一个元素就是最久未使用的
        MyNode deletedNode = cache.removeFirst();
        // 同时别忘了从 map 中删除它的 key
        int deletedKey = deletedNode.key;
        map.remove(deletedKey);
    }


}

class MyNode {
    int key;
    int val;
    MyNode pre;
    MyNode next;

    public MyNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class MyDoubleLinkedList {
    MyNode head;
    MyNode tail;
    int size;

    public MyDoubleLinkedList() {
        this.size = 0;
        head = new MyNode(0, 0);
        tail = new MyNode(0, 0);
        head.next = tail;
        tail.pre = head;
    }

    public void addLast(MyNode node) {
        node.pre = tail.pre;
        node.next = tail;

        tail.pre.next = node;
        tail.pre = node;

        size++;
    }

    public void remove(MyNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        size--;
    }

    // 删除链表中第一个节点，并返回该节点，时间 O(1)
    public MyNode removeFirst() {
        if (head.next == tail) {
            return null;
        }
        MyNode first = head.next;
        remove(first);
        return first;
    }

    // 返回链表长度，时间 O(1)
    public int size() {
        return size;
    }
}
