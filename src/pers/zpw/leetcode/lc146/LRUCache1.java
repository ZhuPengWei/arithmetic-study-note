package pers.zpw.leetcode.lc146;

import java.util.HashMap;
import java.util.Map;

/**
 * 这个demo 超时了
 */
public class LRUCache1 {


    public static void main(String[] args) {
        LRUCache1 cache = new LRUCache1(2);
        System.out.println(cache.get(1));
        cache.put(2, 1);
        System.out.println(cache.get(2));
    }

    int capacity;

    ListNode head = new ListNode(0, 0);

    Map<Integer, ListNode> map = new HashMap<>();

    public LRUCache1(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        ListNode node = map.get(key);
        int value = node.value;

        ListNode temp = head.next;

        // 断开双向链表的链接
        node.pre.next = node.next;
        if (node.next != null) {
            node.next.pre = node.pre;
        } else {
            node.pre = null;
        }

        head.next = node;
        node.pre = head;
        node.next = temp;
        temp.pre = node;

        return value;
    }

    public void put(int key, int value) {
        if (capacity == map.size()) {
            deleteNodes();
        }

        if (map.size() < capacity) {

            // 如果map中存在这个的值 则更新
            if (map.containsKey(key)) {
                ListNode listNode = map.get(key);
                listNode.value = value;
                return;
            }

            ListNode listNode = new ListNode(key, value);

            // map为空值
            if (map.size() == 0) {
                head.next = listNode;
                listNode.pre = head;
            }
            // map中有值
            else {

                ListNode temp = head.next;
                head.next = listNode;
                listNode.pre = head;
                temp.pre = listNode;
                listNode.next = temp;
            }
            map.put(key, listNode);
        }
    }

    private void deleteNodes() {
        // 找到最后一个元素
        ListNode temp = head.next;
        if (temp == null) {
            return;
        }
        while (true) {
            if (temp.next == null) {
                map.remove(temp.key);
                temp.pre.next = null;
                temp.pre = null;
                break;
            }
            temp = temp.next;
        }
    }
}



