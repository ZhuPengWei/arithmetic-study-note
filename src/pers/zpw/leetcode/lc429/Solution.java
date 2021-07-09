package pers.zpw.leetcode.lc429;

import pers.zpw.util.ArrayUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    public static void main(String[] args) {
        Node root = new Node(1);
        List<Node> child = new ArrayList<>();
        Node node2 = new Node(2);
        child.add(new Node(3));
        child.add(new Node(4));
        child.add(new Node(5));
        child.add(node2);
        root.children = child;

        List<Node> child2 = new ArrayList<>();
        Node node21 = new Node(6);
        Node node22 = new Node(7);
        child2.add(node21);
        child2.add(node22);
        node2.children = child2;

        List<Node> child22 = new ArrayList<>();
        child22.add(new Node(11));
        node22.children = child22;

        List<Node> child21 = new ArrayList<>();
        Node node211 = new Node(8);
        child21.add(node211);
        node21.children = child21;

        List<Node> child211 = new ArrayList<>();
        child211.add(new Node(9));
        child211.add(new Node(10));
        node211.children = child211;

        List<List<Integer>> lists = levelOrder(root);
        System.out.println(ArrayUtil.toString(lists));
    }


    public static List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // 当队列不为空
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            // 当前队列的长度
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (cur != null) {
                    level.add(cur.val);
                }
                if (cur != null && cur.children != null) {
                    queue.addAll(cur.children);
                }
            }
            result.add(level);
        }
        return result;
    }
}
