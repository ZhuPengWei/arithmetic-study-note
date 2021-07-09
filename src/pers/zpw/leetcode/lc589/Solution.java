package pers.zpw.leetcode.lc589;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个 N 叉树，返回其节点值的 前序遍历 。
 * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * @author ZhuPengWei
 * @email pengwei@mgtv.com
 * @date 2021-07-09 23:05
 */
public class Solution {

    /**
     * @param root 根节点
     * @return 递归的方式层序遍历
     */
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;

    }

    /**
     * @param root 根节点
     * @return 非递归的方式层序遍历
     */
    public List<Integer> preorderNR(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();

        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            result.add(cur.val);

            if (cur.children != null && cur.children.size() > 0) {
                List<Node> children = cur.children;

                for (int i = children.size() - 1; i >= 0; i--) {
                    Node node = children.get(i);
                    stack.add(node);
                }
            }
        }
        return result;
    }

    public void preorder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        if (node.children != null && node.children.size() > 0) {
            for (Node child : node.children) {
                preorder(child, list);
            }
        }
    }
}
