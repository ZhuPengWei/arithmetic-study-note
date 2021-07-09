package pers.zpw.leetcode.lc94;

import pers.zpw.util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author ZhuPengWei
 * @email pengwei@mgtv.com
 * @date 2021-07-09 15:46
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        List<Integer> res = inorderTraversal2(root);
        System.out.println(ArrayUtil.toString(res));

    }


    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

    /**
     * @return 递归写法
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    public static void inorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, list);
        list.add(node.val);
        inorderTraversal(node.right, list);
    }

}
