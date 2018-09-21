package com.github.jarviskim.algorithm.boj.a7576_Tomato;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 토마토
 * <p>
 * https://www.acmicpc.net/problem/7576
 */
public class Tomato {

    public static int solve(int[][] tomato) {
        int day = -1;
        int n = tomato.length;
        int m = tomato[ 0 ].length;

        Queue<Position> queue = new LinkedList<>();
        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < m; j++ ) {
                if ( tomato[ i ][ j ] == 1 ) {
                    queue.add(new Position(i, j));
                }
            }
        }

        while ( queue.size() > 0 ) {
            day++;
            queue = next(tomato, queue);
        }

        boolean allRipen = Arrays.stream(tomato).flatMapToInt(x -> Arrays.stream(x)).filter(value -> value == 0).count() == 0;
        
        return allRipen ? day : -1;
    }

    public static Queue<Position> next(int[][] tomato, Queue<Position> queue) {
        int n = tomato.length;
        int m = tomato[ 0 ].length;

        Queue<Position> next = new LinkedList<>();
        while ( queue.size() > 0 ) {
            Position pos = queue.poll();
            if ( pos.y > 0 && tomato[ pos.y - 1 ][ pos.x ] == 0 ) {
                tomato[ pos.y - 1 ][ pos.x ] = 1;
                next.add(new Position(pos.y - 1, pos.x));
            }
            if ( pos.y < n - 1 && tomato[ pos.y + 1 ][ pos.x ] == 0 ) {
                tomato[ pos.y + 1 ][ pos.x ] = 1;
                next.add(new Position(pos.y + 1, pos.x));
            }
            if ( pos.x > 0 && tomato[ pos.y ][ pos.x - 1 ] == 0 ) {
                tomato[ pos.y ][ pos.x - 1 ] = 1;
                next.add(new Position(pos.y, pos.x - 1));
            }
            if ( pos.x < m - 1 && tomato[ pos.y ][ pos.x + 1 ] == 0 ) {
                tomato[ pos.y ][ pos.x + 1 ] = 1;
                next.add(new Position(pos.y, pos.x + 1));
            }
        }

        return next;
    }

    static class Position {
        public int y;
        public int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int[][] tomato = new int[ n ][ m ];
        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < m; j++ ) {
                tomato[ i ][ j ] = scanner.nextInt();
            }
        }

        System.out.println(solve(tomato));
    }
}
