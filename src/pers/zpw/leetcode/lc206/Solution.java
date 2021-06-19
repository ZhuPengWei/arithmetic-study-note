package pers.zpw.leetcode.lc206;

import java.util.Stack;

class ListNode {
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


public class Solution {

    public static void main(String[] args) {
        ListNode position = new ListNode();
        ListNode head = position;
        for (int i = 1; i <= 5; i++) {
            position.next = new ListNode(i);
            position = position.next;
        }
        ListNode listNode = reverseList(head.next);
        System.out.println(listNode);
    }

    public static ListNode reverseList(ListNode head) {

        // 边界条件
        if (head == null || head.next == null) {
            return head;
        }

        // 定义尾部条件
        Stack<Integer> stack = new Stack<>();

        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        ListNode position = new ListNode();
        head = position;

        while (!stack.empty()) {
            position.next = new ListNode(stack.pop());
            position = position.next;
        }

        return head.next;
    }
}