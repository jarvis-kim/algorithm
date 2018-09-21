package com.github.jarviskim.algorithm.boj.a1005_AcmCraft;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AcmCraft2 {

    public static int solve(Node[] nodes, int w) {
        int max = 0;
        if ( nodes[ w ].childs != null ) {
            for ( Node child : nodes[ w ].childs ) {
                max = Math.max(max, solve(nodes, child.nodeNumber));
            }
        }

        return max + nodes[ w ].time;
    }


    public static class Node {
        private final int nodeNumber;

        private final int time;
        private List<Node> childs;

        public Node(int nodeNumber, int time) {
            this.nodeNumber = nodeNumber;
            this.time = time;
        }

        public void addNode(Node node) {
            if ( childs == null ) {
                childs = new ArrayList<>();
            }

            childs.add(node);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCount = scanner.nextInt();

        for ( int i = 0; i < testCount; i++ ) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            Node[] nodes = new Node[ n ];

            for ( int index = 0; index < nodes.length; index++ ) {
                nodes[ index ] = new Node(index, scanner.nextInt());
            }

            int a, b;
            for ( int kIndex = 0; kIndex < k; kIndex++ ) {
                a = scanner.nextInt();
                b = scanner.nextInt();
                nodes[ b - 1 ].addNode(nodes[ a - 1]);
            }
            int w = scanner.nextInt() - 1;
            System.out.println(solve(nodes, w));
        }
    }
}
