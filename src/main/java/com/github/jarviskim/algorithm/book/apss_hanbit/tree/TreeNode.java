package com.github.jarviskim.algorithm.book.apss_hanbit.tree;

public class TreeNode<T extends Comparable<T>> {

    T value;

    TreeNode<T> left;

    TreeNode<T> right;

    public TreeNode(T value) {
        this.value = value;
    }

    public TreeNode(T value, TreeNode<T> left, TreeNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int childSize() {
        return left != null && right != null
                ? 2
                : left == null && right == null
                    ? 0
                    : 1;
    }
}
