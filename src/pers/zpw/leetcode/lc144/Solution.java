
package pers.zpw.leetcode.lc144;

import pers.zpw.util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 前序遍历
 */
public class Solution {

    public static void main(String[] args) {
       TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        List<Integer> res = preorderTraversal(root);
        System.out.println(ArrayUtil.toString(res));

    }
    /**
     * @param root 树的根节点
     * @return 借助系统栈来实现
     */
    public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            result.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return result;
    }
}
