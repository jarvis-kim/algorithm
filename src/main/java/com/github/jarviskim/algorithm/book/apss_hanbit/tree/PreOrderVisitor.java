package com.github.jarviskim.algorithm.book.apss_hanbit.tree;

public class PreOrderVisitor<T extends Comparable<T>> extends OrderVisitor<T> {

    public PreOrderVisitor(Visited<T> action) {
        super(action);
    }

    @Override
    public void visit(TreeNode<T> node) {
        if ( node != null ) {
            action.doAction(node.value);
            if ( node.left != null ) {
                visit(node.left);
            }
            if ( node.right != null ) {
                visit(node.right);
            }
        }
    }
}
