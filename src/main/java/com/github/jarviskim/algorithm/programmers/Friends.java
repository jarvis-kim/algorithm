package com.github.jarviskim.algorithm.programmers;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * 카카오 프렌즈 컬러링북
 *
 * https://programmers.co.kr/learn/courses/30/lessons/1829?language=java
 */
public class Friends {

    static class Solution {

        public int[] solution(int m, int n, int[][] picture) {
            Node[][] nodeMap = new Node[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (picture[i][j] != 0) {
                        int value = picture[i][j];
                        Node currentNode = new Node();
                        nodeMap[i][j] = currentNode;

                        Optional<Node> aboveNode = (i - 1 >= 0 && picture[i - 1][j] == value)
                                        ? Optional.ofNullable(nodeMap[i - 1][j])
                                        : Optional.empty();
                        Optional<Node> leftNode = (j - 1 >= 0 && picture[i][j - 1] == value)
                                        ? Optional.ofNullable(nodeMap[i][j - 1])
                                        : Optional.empty();

                        Optional<Node> targetNode;
                        if (aboveNode.isPresent() && leftNode.isPresent()) {
                            targetNode = aboveNode
                                    .map(above -> leftNode.map(above::sameRoot).get())
                                    .map(isSameRoot -> isSameRoot
                                         ? aboveNode.map(Node::find).orElseThrow(RuntimeException::new)
                                        : aboveNode.map(node -> node.merge(leftNode.get())).orElseThrow(RuntimeException::new)
                                    );
                        } else if (aboveNode.isPresent()) {
                            targetNode = aboveNode;
                        } else {
                            targetNode = leftNode;
                        }

                        targetNode.ifPresent(node -> node.merge(currentNode));
                    }
                }
            }

            Set<Node> parentNodes = rootNodes(m, n, nodeMap);
            int[] answer = new int[2];
            answer[0] = parentNodes.size();
            answer[1] = parentNodes.stream()
                    .mapToInt(Node::getCount)
                    .max()
                    .orElse(0);

            return answer;
        }

        private Set<Node> rootNodes(int m, int n, Node[][] nodeMap) {
            Set<Node> parentNodes = new HashSet<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    Optional.ofNullable(nodeMap[i][j])
                            .ifPresent(node -> parentNodes.add(node.find()));
                }
            }
            return parentNodes;
        }

        static class Node {
            private Node parent;
            private int rank;
            private int count;

            public Node() {
                this.parent = this;
                this.count = 1;
                this.rank = 1;
            }

            public boolean sameRoot(Node other) {
                Node root = this.find();
                Node otherRoot = other.find();
                return root == otherRoot;
            }

            public Node find() {
                return this == parent ? this : parent.find();
            }

            public Node merge(Node other) {
                Node root = this.find();
                Node otherRoot = other.find();

                Node parent = root.rank > otherRoot.rank ? root : otherRoot;
                Node child = root.rank > otherRoot.rank ? otherRoot : root;

                child.parent = parent;
                parent.count += child.count;
                if (parent.rank == child.rank) {
                    parent.rank++;
                }

                return parent;
            }

            public int getCount() {
                return count;
            }
        }
    }
}
