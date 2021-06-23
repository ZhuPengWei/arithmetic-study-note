package pers.zpw.leetcode.lc25;

/**
 * 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
 * k是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 进阶：
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/tu-jie-kge-yi-zu-fan-zhuan-lian-biao-by-user7208t/
 */

public class Solution {

    // head = [1,2,3,4,5], k = 2
    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode listNode = reverseKGroup(node1, 3);

        System.out.println("操作成功" + listNode);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {

            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }

            ListNode start = pre.next;
            ListNode next = end.next;
            // 断开连接
            end.next = null;

            // 翻转链表
            pre.next = reverseNodeList(start);

            start.next = next;
            pre = start;
            end = start;
        }
        return dummy.next;

    }

    /**
     *  链表翻转 1->2->3->4  ===>  4->3->2>1
     */
    private static ListNode reverseNodeList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode preNode = null;
        ListNode curNode = head;
        ListNode nextNode;

        while (curNode != null) {

            // 暂存后继节点
            nextNode = curNode.next;

            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }
}
