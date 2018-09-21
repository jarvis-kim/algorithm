package com.github.jarviskim.algorithm.book.apss_hanbit.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderVisitor<T extends Comparable<T>> extends OrderVisitor<T> {

    public LevelOrderVisitor(Visited<T> action) {
        super(action);
    }

    @Override
    public void visit(TreeNode<T> node) {
        if ( node == null ) {
            return;
        }

        Queue<TreeNode<T>> nodes = new LinkedList<>();

        nodes.add(node);

        TreeNode<T> current = null;
        while ( (current = nodes.poll()) != null ) {
            action.doAction(current.value);
            if ( current.left != null ) {
                nodes.add(current.left);
            }
            if ( current.right != null ) {
                nodes.add(current.right);
            }
        }
    }
}
