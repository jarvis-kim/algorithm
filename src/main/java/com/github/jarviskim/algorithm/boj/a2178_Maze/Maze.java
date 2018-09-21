package com.github.jarviskim.algorithm.boj.a2178_Maze;

import java.util.*;

/**
 * 미로 탐색
 * <p>
 * https://www.acmicpc.net/problem/2178
 */
public class Maze {

    private static int VISITED = 2;
    private static int LOAD = 1;

    public static int bfs(int[][] map) {
        int n = map.length;
        int m = map[ 0 ].length;

        boolean[][] visited = new boolean[ n ][ m ];

        int count = 1;
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0));
        visited[ 0 ][ 0 ] = true;

        while ( !queue.isEmpty() && !visited[ n - 1 ][ m - 1 ]) {
            queue = nextBfs(map, visited, queue, m, n);
            count++;
        }

        return count;
    }

    static Queue<Position> nextBfs(int[][] map, boolean[][] visited, Queue<Position> queue, int m, int n) {
        Queue<Position> next = new LinkedList<>();

//        print(map, visited);
        while ( queue.size() > 0 ) {
            Position pos = queue.poll();
            int y = pos.y;
            int x = pos.x;

            if ( y > 0 && map[ y - 1 ][ x ] == LOAD && !visited[ y - 1 ][ x ]) {
                next.add(new Position(y - 1, x));
                visited[ y - 1 ][ x ] = true;
            }
            if ( y < n - 1 && map[ y + 1 ][ x ] == LOAD && !visited[ y + 1 ][ x ]) {
                next.add(new Position(y + 1, x));
                visited[ y + 1 ][ x ] = true;
            }
            if ( x > 0 && map[ y ][ x - 1 ] == LOAD && !visited[ y  ][ x - 1 ]) {
                next.add(new Position(y, x - 1));
                visited[ y ][ x - 1 ] = true;
            }
            if ( x < m - 1 && map[ y ][ x + 1 ] == LOAD && !visited[ y ][ x + 1]) {
                next.add(new Position(y, x + 1));
                visited[ y ][ x + 1 ] = true;
            }

        }

        return next;
    }

    static int COUNT = 1;
    public static void print(int[][] map, boolean[][] visited) {

        System.out.println("============" + COUNT++ + "==============");
        for ( int i = 0; i < visited.length; i++ ) {
            for ( int j = 0; j < visited[ i ].length; j++ ) {
                if ( visited[ i ][ j ] ) {
                    System.out.printf(" *");
                } else {
                    System.out.printf("%2d", map[ i][ j ]);
                }
            }

            System.out.println();
        }

        System.out.println();
    }

    public static int solve(int[][] map, int m, int n) {
        List<Integer> list = new ArrayList<>();
        dfs(map, 0, 0, m, n, 1, list);

        return list.stream().min(Integer::compareTo).get();
    }

    public static void dfs(int[][] map, int x, int y, int m, int n, int count, List<Integer> list) {
        if ( x == m - 1 && y == n - 1 ) {
            list.add(count);
            return;
        }

        map[ y ][ x ] = VISITED;
        if ( y > 0 && map[ y - 1 ][ x ] == LOAD ) {
            dfs(map, x, y - 1, m, n, count + 1, list);
        }
        if ( y < n - 1 && map[ y + 1 ][ x ] == LOAD ) {
            dfs(map, x, y + 1, m, n, count + 1, list);
        }
        if ( x > 0 && map[ y ][ x - 1 ] == LOAD ) {
            dfs(map, x - 1, y, m, n, count + 1, list);
        }
        if ( x < m - 1 && map[ y ][ x + 1 ] == LOAD ) {
            dfs(map, x + 1, y, m, n, count + 1, list);
        }

        map[ y ][ x ] = LOAD;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] map = new int[ n ][ m ];

        scanner.nextLine();
        String line = null;
        for ( int i = 0; i < n; i++ ) {
            line = scanner.nextLine();
            String[] s = line.split("");
            for ( int j = 0; j < s.length; j++ ) {
                map[ i ][ j ] = Integer.parseInt(s[ j ]);
            }
        }
        System.out.println(bfs(map));
    }

    static class Position {
        public int y;
        public int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
