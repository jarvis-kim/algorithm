package com.github.jarviskim.algorithm.boj.a10216_CountCircleGroups;

import java.util.*;

/**
 * Count Circle Groups
 *
 * https://www.acmicpc.net/problem/10216
 *
 * 1차 틀림 : 레이더망이 사각형인줄 알고 사각형 겹침으로 검사했는데, 질문 보니 원으로..(하긴,,, 제목이 Circle인데;;)
 */
public class CountCircleGroups {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();
        for ( int c = 0; c < testCase; c++ ) {
            int n = scanner.nextInt();
            Station[] stations = new Station[ n ];
            for ( int i = 0; i < n; i++ ) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int r = scanner.nextInt();
                stations[ i ] = new Station(i, x, y, r);
            }

            System.out.println(solve(stations));
        }
    }

    public static int solve(Station[] stations) {
        DisjointSet<Station> disjointSet = new DisjointSet<>(stations);

        for ( int i = 1; i < stations.length; i++ ) {
            for ( int j = 0; j < i; j++ ) {
                if ( stations[ j ].overlap(stations[ i ]) ) {
                    disjointSet.merge(stations[ i ], stations[ j ]);
                }
            }
        }

        Set<DisjointSet.Node> set = new HashSet<>();
        for ( Station station : stations ) {
            DisjointSet.Node node = disjointSet.find(station);
            set.add(node);
        }

        return set.size();
    }

    public static class Station {
        private final int name;
        private final int x;
        private final int y;
        private final int r;

        private Circle circle;

        public Station(int name, int x, int y, int r) {
            this.name = name;
            this.x = x;
            this.y = y;
            this.r = r;
            circle = new Circle(x, y, r);
        }

        public boolean overlap(Station s2) {
            Station s1 = this;
            return s1.circle.overlap(s2.circle);
        }

        @Override
        public boolean equals(Object o) {
            if ( this == o ) return true;
            if ( !(o instanceof Station) ) return false;
            Station station = (Station) o;
            return name == station.name &&
                    x == station.x &&
                    y == station.y &&
                    r == station.r;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, x, y, r);
        }
    }

    public static class Circle {
        int x, y;
        int radius;

        public Circle(int x, int y, int radius) {
            this.x = x;
            this.y = y;
            this.radius = radius;
        }

        public boolean overlap(Circle circle2) {
            Circle circle1 = this;
            double tmp = Math.sqrt(Math.pow(circle1.x - circle2.x, 2) + Math.pow(circle1.y - circle2.y, 2));

            return tmp <= circle1.radius + circle2.radius;
        }
    }

    public static class DisjointSet<T> {

        private Map<T, Node> nodeMap;

        public DisjointSet(T[] objs) {
            int capacity = (int) (objs.length + objs.length * 0.25f) + 1;
            nodeMap = new HashMap<>(capacity);
            for ( T obj : objs ) {
                Node<T> node = new Node<>(obj);
                nodeMap.put(obj, node);
            }
        }

        private Node getNode(T t) {
            return nodeMap.get(t);
        }

        public Node find(T t) {
            Node node = getNode(t);
            Node root = node;

            while ( root != root.parent ) {
                root = root.parent;
            }

            /* path compression */
            Node next;
            while ( root != node.parent ) {
                next = node.parent;
                node.parent = root;
                node = next;
            }

            return root;
        }

        public Node merge(T t1, T t2) {
            Node node1 = find(t1);
            Node node2 = find(t2);

            /* union-by-rank */
            if ( node1.hight == node2.hight ) {
                node2.parent = node1;
                node1.hight++;
                return node1;
            } else if ( node1.hight > node2.hight) {
                node2.parent = node1;
                return node1;
            } else {
                node1.parent = node2;
                return node2;
            }
        }

        public static class Node<T> {

            private int hight = 0;

            private T t;

            private Node<T> parent;

            public Node(T t) {
                this.t = t;
                this.parent = this;
            }
        }

    }

}
