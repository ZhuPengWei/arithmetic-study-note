package pers.zpw.leetcode.lc146;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/lru-cache/solution/146-lru-huan-cun-ji-zhi-ha-xi-biao-shuan-l3um/
 * <p>
 * 哈希表 + 双向链表
 * <p>
 * 哈希表用于满足题目时间复杂度O(1)的要求，双向链表用于存储顺序
 * 哈希表键值类型：<Integer, ListNode>，哈希表的键用于存储输入的key，哈希表的值用于存储双向链表的节点
 * 双向链表的节点中除了value外还需要包含key，因为在删除最久未使用的数据时，需要通过链表来定位hashmap中应当删除的键值对
 * 一些操作：双向链表中，在后面的节点表示被最近访问
 * i. 新加入的节点放在链表末尾，addNodeToLast(node)
 * ii. 若容量达到上限，去除最久未使用的数据，removeNode(head.next)
 * iii. 若数据新被访问过，比如被get了或被put了新值，把该节点挪到链表末尾，moveNodeToLast(node)
 * 为了操作的方便，在双向链表头和尾分别定义一个head和tail节点。
 * <p>
 * 作者：edelweisskoko
 * 链接：https://leetcode-cn.com/problems/lru-cache/solution/146-lru-huan-cun-ji-zhi-ha-xi-biao-shuan-l3um/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }


    int capacity;

    ListNode head = new ListNode(0, 0);
    ListNode tail = new ListNode(0, 0);

    Map<Integer, ListNode> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        ListNode listNode = map.get(key);
        moveNodeToLast(listNode);
        return listNode.value;
    }

    public void put(int key, int value) {
        if (capacity == map.size() && !map.containsKey(key)) {
            // 容量达到上限,去除去除最久未使用的数据
            removeNode();
        }
        ListNode node = new ListNode(key, value);

        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
        } else {
            map.put(key, node);
        }
        // 移动新的值去尾部
        moveNodeToLast(node);

    }

    /**
     * 直接删除头部的链表数据
     */
    private void removeNode() {
        ListNode temp = head.next;
        int key = temp.key;

        temp.next.pre = head;
        head.next = temp.next;

        map.remove(key);
    }

    /**
     * 把节点移动去节点尾部
     */
    private void moveNodeToLast(ListNode listNode) {

        // 说明是旧值 断开原来的连接 在挪去尾部
        if (listNode.next != null || listNode.pre != null) {
            listNode.pre.next = listNode.next;
            listNode.next.pre = listNode.pre;
        }

        // 直接挪去尾部
        ListNode temp = tail.pre;
        tail.pre = listNode;
        listNode.next = tail;
        listNode.pre = temp;
        temp.next = listNode;


    }
}




