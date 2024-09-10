package scn1.algh.tree.redblacktree;

/**
 * 红黑树节点
 */
public class Node {
    int data;
    Node left;
    Node right;
    Node parent;
    boolean color;//红色false 黑色true

    public Node(int data) {
        this.data = data;
    }
}
