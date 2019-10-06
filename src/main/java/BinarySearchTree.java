/***
 *
 * @author zhengchunguang
 * @date 2019-10-05 21:02
 * 二叉查找树
 */
public class BinarySearchTree {
    private Node root;
    public BinarySearchTree(Node root) {
        this.root = root;
    }

    private class Node{
        private int value;
        private Node left;
        private Node right;
    }
}
