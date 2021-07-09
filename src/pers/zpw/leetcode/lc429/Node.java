package pers.zpw.leetcode.lc429;

import java.util.List;

/**
 * @author ZhuPengWei
 * @email pengwei@mgtv.com
 * @date 2021-07-09 21:53
 */
public class Node {

    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
