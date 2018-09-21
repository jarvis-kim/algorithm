package com.github.jarviskim.algorithm.boj.a2606_Virus;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 바이러스
 *
 * https://www.acmicpc.net/problem/2606
 */
public class Virus {

    public static class NodeFactory {

        private Map<Integer, Node> nodes = new HashMap<>();

        public Node createNode(int name) {
            Node node = nodes.get(name);
            if ( node == null ) {
                node = new Node(name);
                nodes.put(name, node);
            }

            return node;
        }

        public Node createNodeAndAddChild(int parent, int child) {
            Node parentNode = createNode(parent);
            Node childNode = createNode(child);
            parentNode.add(childNode);

            return parentNode;
        }
    }
    
    public static class Node {
        private int name;

        private List<Node> childs;

        private boolean visited = false;

        public Node(int name) {
            this.name = name;
        }

        public void add(Node node) {
            addChild(node);
            node.addChild(this);
        }

        private void addChild(Node node) {
            if ( childs == null ) {
                childs = new ArrayList<>();
            }

            childs.add(node);
        }
    }

    public static int count(Node node) {
        AtomicInteger count = new AtomicInteger(1);
        if ( node.childs != null ) {
            node.childs.forEach(c -> {
                if ( c.visited == false ) {
                    c.visited = true;
                    int cnt = count(c);
                    count.addAndGet(cnt);
                }
            });
        }

        return count.get();
    }

    public static int solve(Node node) {
        node.visited = true;
        return count(node) - 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        scanner.nextInt();
        int pairCount = scanner.nextInt();
        NodeFactory nodeFactory = new NodeFactory();
        for ( int i = 0; i < pairCount; i++ ) {
            int p = scanner.nextInt();
            int c = scanner.nextInt();
            nodeFactory.createNodeAndAddChild(p, c);
        }

        Node node = nodeFactory.createNode(1);
        System.out.println(solve(node));
    }
}
