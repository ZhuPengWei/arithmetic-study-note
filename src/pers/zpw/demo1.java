package pers.zpw;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *
 * @author ZhuPengWei
 * @email pengwei@mgtv.com
 * @date 2020-06-23 15:20
 */
public class demo1 {

    class Node {
        int value;
        Node left;
        Node right;
    }

    public static void aaa(Node node) {
        Queue<Node> queue = new ArrayDeque<>();

        queue.add(node);

        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.value + " ");

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
}
