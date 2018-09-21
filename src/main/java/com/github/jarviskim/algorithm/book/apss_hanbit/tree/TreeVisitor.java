package com.github.jarviskim.algorithm.book.apss_hanbit.tree;

public interface TreeVisitor<T extends Comparable<T>> {

    void visit(TreeNode<T> node);
}
