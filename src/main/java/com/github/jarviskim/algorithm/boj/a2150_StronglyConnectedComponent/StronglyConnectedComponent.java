package com.github.jarviskim.algorithm.boj.a2150_StronglyConnectedComponent;

import java.util.*;

/**
 * Strongly Connected Component
 * <p>
 * https://www.acmicpc.net/problem/2150
 * <p>
 * SCC - 타잔 알고리즘
 * <p>
 * 참고 :
 * - 알고리즘 문제 해결 전략
 * - http://jason9319.tistory.com/98
 * - https://m.blog.naver.com/PostView.nhn?blogId=kks227&logNo=220802519976&categoryNo=299&proxyReferer=https%3A%2F%2Fwww.google.co.kr%2F
 */
public class StronglyConnectedComponent {

    public static class Scc {
        private List<Integer>[] graph;

        private int[] discover;

        private boolean[] visited;

        private boolean[] finished;

        private int sequence = 1;

        private Deque<Integer> stack = new ArrayDeque<>();

        private List<List<Integer>> scc = new ArrayList<>();

        public Scc(int n) {
            visited = new boolean[ n + 1 ];
            finished = new boolean[ n + 1 ];
            discover = new int[ n + 1 ];
            graph = new List[ n + 1 ];
            for ( int i = 1; i < graph.length; i++ ) {
                graph[ i ] = new ArrayList<>();
            }
        }

        public Scc edge(int from, int to) {
            graph[ from ].add(to);

            return this;
        }

        private int dfs(int vertex) {
            stack.push(vertex);
            int ret = discover[ vertex ] = sequence++;
            visited[ vertex ] = true;

            for ( Integer u : graph[ vertex ] ) {
                if ( !visited[ u ] ) {
                    ret = Math.min(ret, dfs(u));
                } else if ( !finished[ u ] ) {
                    ret = Math.min(ret, discover[ u ]);
                }
            }

            if ( ret == discover[ vertex ] ) {
                List<Integer> list = new ArrayList<>();
                int v;
                do {
                    v = stack.pop();
                    list.add(v);
                    finished[ v ] = true;
                } while ( v != vertex );
                scc.add(list);
            }

            return ret;
        }

        public int[][] solve() {

            for ( int vertex = 1; vertex < graph.length; vertex++ ) {
                if ( !visited[ vertex ] ) {
                    dfs(vertex);
                }
            }
            scc.stream().forEach(list -> list.sort(Integer::compareTo));
            int[][] result = scc.stream()
                    .map(list -> list.stream().mapToInt(value -> value).toArray())
                    .sorted(Comparator.comparingInt(o -> o[ 0 ]))
                    .toArray(value -> new int[ value ][]);

            return result;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int count = scanner.nextInt();

        Scc scc = new Scc(n);

        int from, to;
        for ( int i = 0; i < count; i++ ) {
            from = scanner.nextInt();
            to = scanner.nextInt();
            scc.edge(from, to);
        }

        int[][] result = scc.solve();

        for ( int i = 0; i < result.length; i++ ) {
            for ( int j = 0; j < result[ i ].length; j++ ) {
                System.out.print(result[ i ][ j ] + " ");
            }
            System.out.println("-1");
        }
    }

}
