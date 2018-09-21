package com.github.jarviskim.algorithm.boj.a1325_Hacking;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 효율적인 해킹
 *
 * https://www.acmicpc.net/problem/1325
 */
public class Hacking {

    public static final int[] solve(List<Node> leafNodes) {
        Queue<Node> queue = new LinkedList<>(leafNodes);

        Collection<Node> result = null;

        while ( !queue.isEmpty() ) {
            result = new ArrayList<>(queue);
            Queue<Node> nextQueue = new LinkedList<>();
            while ( !queue.isEmpty() ) {
                Node node = queue.poll();
                Iterator<Node> iterator = node.nodeIterator();
                while ( iterator.hasNext() ) {
                    Node nextNode = iterator.next();
                    nextNode.removed();
                    if ( nextNode.getIntoDegree() == 0 ) {
                        nextQueue.add(nextNode);
                    }
                }
            }

            queue = nextQueue;
        }

        if ( result == null ) {
            result = Collections.EMPTY_LIST;
        }

        return result.stream().mapToInt(node -> node.getNumber()).sorted().toArray();
    }


    public static class Node {
        private int number;

        private int intoDegree = 0;

        Set<Node> nextNodes;

        public Node(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }

        public int getIntoDegree() {
            return intoDegree;
        }

        public Node addNextNode(Node node) {
            if ( nextNodes == null ) {
                nextNodes = new HashSet<>();
            }

            nextNodes.add(node);
            node.added();
            return this;
        }

        public Iterator<Node> nodeIterator() {
            if ( nextNodes == null ) {
                return Collections.EMPTY_LIST.iterator();
            }
            return nextNodes.iterator();
        }

        public Node removeNextNode(Node node) {
            if ( nextNodes != null ) {
                nextNodes.remove(node);
                node.removed();
            }

            return this;
        }

        protected void added() {
            intoDegree++;
        }

        protected void removed() {
            intoDegree--;
        }

        @Override
        public boolean equals(Object o) {
            if ( this == o ) return true;
            if ( o == null || getClass() != o.getClass() ) return false;

            Node node = (Node) o;

            return number == node.number;
        }

        @Override
        public int hashCode() {
            return number;
        }
    }

    public static class NodeFactory {
        private Node[] nodes;

        public NodeFactory(int size) {
            this.nodes = new Node[ size + 1];
            for ( int i = 1; i < size; i++ ) {
                nodes[ i ] = new Node(i);
            }
        }

        public Node getNode(int number) {
            if ( nodes[ number ] == null ) {
                nodes[ number ] = new Node(number);
            }
            return nodes[ number ];
        }

        public NodeFactory pair(int num1, int num2) {
            Node node2 = getNode(num2);
            getNode(num1).addNextNode(node2);

            return this;
        }

        public List<Node> toLeafNodes() {
            return Arrays.stream(nodes).skip(1).filter(node -> node.getIntoDegree() == 0).collect(Collectors.toList());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        NodeFactory nodeFactory = new NodeFactory(n);

        int a, b;
        for ( int i = 0; i < m; i++ ) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            nodeFactory.pair(a, b);
        }

        List<Node> leafNodes = nodeFactory.toLeafNodes();
        int[] result = solve(leafNodes);
        for ( int rt : result ) {
            System.out.print(rt + " ");
        }

        System.out.println();

    }

}
