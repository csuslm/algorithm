package scn1.algh.tree;

import com.sun.source.tree.Tree;

import java.util.*;

public class TreeNodeTopics {
    /**
     * 迭代二叉树的前序遍历
     */
    public List<Integer> front(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        stack.push(root);
        return res;
    }
}
