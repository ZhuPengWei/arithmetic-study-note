package pers.zpw.leetcode.lc23;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(7);
        l12.next = new ListNode(8);
        l11.next = l12;
        l1.next = l11;

        ListNode l2 = new ListNode(2);
        ListNode l21 = new ListNode(4);
        ListNode l22 = new ListNode(8);
        l22.next = new ListNode(9);
        l21.next = l22;
        l2.next = l21;

        ListNode l3 = new ListNode(1);
        ListNode l31 = new ListNode(9);
        ListNode l32 = new ListNode(10);
        l32.next = new ListNode(15);
        l31.next = l32;
        l3.next = l31;

        ListNode[] lists =new ListNode[]{l1,l2,l3};

        ListNode listNode = mergeKLists(lists);
        System.out.println(listNode);

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) return -1;
                else if (o1.val == o2.val) return 0;
                else return 1;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }
        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
            if (p.next != null) queue.add(p.next);
        }
        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

