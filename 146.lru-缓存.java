import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 */

// @lc code=start
class LRUCache {
    private final int capacity;
    private final Node head = new Node();
    private final Node tail = new Node();

    private final Map<Integer, Node> cache = new HashMap<>();

    protected static class Node {
        int key;
        int val;
        Node next;
        Node pre;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        Node n = cache.get(key);
        if (n == null) {
            return -1;
        }
        Node pre = n.pre;
        Node next = n.next;
        pre.next = next;
        next.pre = pre;
        
        n.pre = head;
        n.next = head.next;
        head.next = n;
        n.next.pre = n;
        return n.val;
    }
    
    public void put(int key, int value) {
        Node n = cache.get(key);
        if (n == null) {
            n = new Node();
            n.key = key;
            n.val = value;
        } else {
            n.val = value;
            Node pre = n.pre;
            Node next = n.next;
            pre.next = next;
            next.pre = pre;
        }
        n.pre = head;
        n.next = head.next;
        head.next = n;
        n.next.pre = n;
        cache.put(key, n);
        if (cache.size() > capacity) {
            Node removalNode = tail.pre;
            tail.pre = removalNode.pre;
            removalNode.pre.next = tail;
            cache.remove(removalNode.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

