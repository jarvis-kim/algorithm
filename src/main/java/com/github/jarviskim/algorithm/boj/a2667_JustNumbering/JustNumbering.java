package com.github.jarviskim.algorithm.boj.a2667_JustNumbering;

import java.util.*;

/**
 * 단지 번호 붙이기
 * <p>
 * https://www.acmicpc.net/problem/2667
 *
 * 좀더 속도를 올리수 있을거같은...
 * TODO : 속도 개선 방법
 */
public class JustNumbering {

    public static int[] solve(int[][] map) {
        Numbering numbering = new Numbering(map);
        numbering.start();

        return numbering.getResults().stream().sorted(Integer::compareTo).mapToInt(value -> value).toArray();
    }

    static class Numbering {
        int n;
        int m;
        int[][] map;
        int[][] numbering;
        int number = 1;

        List<Integer> results = new ArrayList<>();

        public Numbering(int[][] map) {
            this.map = map;
            this.n = map.length;
            this.m = map[ 0 ].length;

            this.numbering = new int[ n ][ m ];
        }

        public void start() {
            for ( int i = 0; i < n; i++ ) {
                for ( int j = 0; j < m; j++ ) {
                    if ( map[ i ][ j ] == 1 && numbering[ i ][ j ] == 0 ) {
                        numbering(new Position(i, j));
                        number++;
                    }
                }
            }
        }

        private void numbering(Position first) {
            Queue<Position> queue = new LinkedList<>();
            queue.add(first);
            numbering[ first.y ][ first.x ] = number;

            int count = 0;
            while ( !queue.isEmpty() ) {
                Position position = queue.poll();
                int y = position.y;
                int x = position.x;

                count++;
                if ( y - 1 >= 0 && map[ y - 1 ][ x ] == 1 && numbering[ y - 1 ][ x ] == 0 ) {
                    queue.add(new Position(y - 1, x));
                    numbering[ y - 1 ][ x ] = number;
                }
                if ( y + 1 < n && map[ y + 1 ][ x ] == 1 && numbering[ y + 1 ][ x ] == 0 ) {
                    queue.add(new Position(y + 1, x));
                    numbering[ y +1 ][ x ] = number;
                }
                if ( x - 1 >= 0 && map[ y ][ x - 1 ] == 1 && numbering[ y ][ x - 1 ] == 0 ) {
                    queue.add(new Position(y, x - 1));
                    numbering[ y ][ x - 1 ] = number;
                }
                if ( x + 1 < m && map[ y ][ x + 1 ] == 1 && numbering[ y ][ x + 1 ] == 0 ) {
                    queue.add(new Position(y, x + 1));
                    numbering[ y ][ x + 1 ] = number;
                }
            }

            results.add(count);
        }

        public List<Integer> getResults() {
            return results;
        }
    }

    public static class Position {
        int y;
        int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        int[][] map = new int[ n ][ ];
        for ( int i = 0; i < n; i++ ) {
            String line = scanner.nextLine();
            map[ i ] = Arrays.stream(line.split("")).mapToInt(Integer::parseInt).toArray();
        }

        int[] result = solve(map);
        System.out.println(result.length);
        for ( int num : result ) {
            System.out.println(num);
        }
    }
}
