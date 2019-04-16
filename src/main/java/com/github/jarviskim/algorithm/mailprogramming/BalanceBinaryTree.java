package com.github.jarviskim.algorithm.mailprogramming;

public class BalanceBinaryTree {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 8, 9, 10, 12, 16};
        Node root = convertBalancedBinaryTree(arr, 0, arr.length - 1);
        System.out.println(assertBalancedTree(root));
        printTreeSort(root);

        Node node = new Node(1);
        node.left = new Node(2);
        node.left.left = new Node(3);
        node.left.left.left = new Node(4);
        System.out.println();
        System.out.println(assertBalancedTree(node));
    }

    static boolean assertBalancedTree(Node node) {
        if (node != null) {
            boolean leftResult = assertBalancedTree(node.left);
            boolean rightResult = assertBalancedTree(node.right);

            int left = nodeLevel(node.left, 0);
            int right = nodeLevel(node.right, 0);
            return Math.abs(left - right) <= 1 && leftResult && rightResult;
        }

        return true;
    }

    private static int nodeLevel(Node node, int level) {
        if (node == null) {
            return level;
        }

        return Math.max(nodeLevel(node.left, level + 1), nodeLevel(node.right, level + 1));
    }

    private static void printTreeSort(Node node) {
        if (node == null) {
            return;
        }
        printTreeSort(node.left);
        System.out.print(node.value + " ");
        printTreeSort(node.right);
    }

    static Node convertBalancedBinaryTree(int[] arr, int left, int right) {
        if (left > right) {
            return null;
        }

        if (left == right) {
            return new Node(arr[left], null, null);
        }
        int mid = (left + right) / 2;
        Node leftNode = convertBalancedBinaryTree(arr, left, mid - 1);
        Node rightNode = convertBalancedBinaryTree(arr, mid + 1, right);
        return new Node(arr[mid], leftNode, rightNode);
    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
