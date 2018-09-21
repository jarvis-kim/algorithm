package com.github.jarviskim.algorithm.book.apss_hanbit.tree;

public class BinaryTree<T extends Comparable<T>> {

    private TreeNode<T> root;

    public void add(T value) {
        root = add(root, value);
    }

    protected TreeNode<T> add(TreeNode node, T value) {
        if ( node == null ) {
            return new TreeNode<>(value);
        }
        if ( node.value.compareTo(value) > 0 ) {
            node.left = add(node.left, value);
        } else {
            node.right = add(node.right, value);
        }

        return node;
    }

    public int size() {
        return count(root);
    }

    protected int count(TreeNode<T> node) {
        int count = 0;
        if ( node == null ) {
            return 0;
        }
        count++;
        count += count(node.left);
        count += count(node.right);

        return count;
    }

    public void remove(T value) {
        if ( root == null ) {
            return;
        }

        TreeNode<T> parent = null;
        TreeNode<T> target = root;
        while ( target != null && !target.value.equals(value) ) {
            parent = target;
            if ( target.value.compareTo(value) < 0 ) {
                target = target.left;
            } else {
                target = target.right;
            }
        }

        if ( target != null ) {
            cutNode(parent, target);
        }
    }

    protected void cutNode(TreeNode<T> parent, TreeNode<T> target) {
        if ( target.childSize() == 0 ) {
            if ( parent != null ) {
                parent.left = null;
                parent.right = null;
            } else {
                root = target;
            }
        } else if ( target.childSize() == 1 ) {
            TreeNode<T> childOfTarget = target.left != null
                    ? target.left
                    : target.right;

            if ( target != root ) {
                if ( parent.left == target ) {
                    parent.left = childOfTarget;
                } else {
                    parent.right = childOfTarget;
                }
            } else {
                root.left = root.right = null;
                root = target;
            }
        } else {
            TreeNode<T> maxNode = target.left;
            TreeNode<T> parentOfMaxNode = maxNode;
            while ( maxNode.right != null ) {
                parentOfMaxNode = maxNode;
                maxNode = maxNode.right;
            }

            parentOfMaxNode.right = maxNode.left;

            maxNode.left = target.left;
            maxNode.right = target.right;
            if ( parent != null ) {
                parent.left = maxNode;
            } else {
                root = maxNode;
            }
        }
    }

    protected TreeNode<T> findParent(T value) {
        if ( root == null ) {
            return null;
        }

        TreeNode<T> target = null;
        TreeNode<T> node = root;
        while ( node != null && !node.value.equals(value) ) {
            if ( node.value.compareTo(value) > 0 ) {
                node = node.left;
            } else {
                node = node.right;
            }
        }


        return node;
    }

    public void order(TreeVisitor<T> visitor) {
        visitor.visit(root);
    }

}
