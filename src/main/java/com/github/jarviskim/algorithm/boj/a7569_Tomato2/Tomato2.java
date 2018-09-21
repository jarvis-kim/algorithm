package com.github.jarviskim.algorithm.boj.a7569_Tomato2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 토마토 2
 * <p>
 * https://www.acmicpc.net/problem/7569
 */
public class Tomato2 {

    public static int solve(int[][][] tomato) {
        int day = -1;
        int h = tomato.length;
        int n = tomato[ 0 ].length;
        int m = tomato[ 0 ][ 0 ].length;

        Queue<Position> queue = new LinkedList<>();

        for ( int z = 0; z < h; z++ ) {
            for ( int i = 0; i < n; i++ ) {
                for ( int j = 0; j < m; j++ ) {
                    if ( tomato[ z ][ i ][ j ] == 1 ) {
                        queue.add(new Position(z, i, j));
                    }
                }
            }
        }


        while ( queue.size() > 0 ) {
            day++;
            queue = next(tomato, queue);
        }

        boolean allRipen = true;
        ripenLoop:
        for ( int z = 0; z < h; z++ ) {
            for ( int i = 0; i < n; i++ ) {
                for ( int j = 0; j < m; j++ ) {
                    if ( tomato[ z ][ i ][ j ] == 0 ) {
                        allRipen = false;
                        break ripenLoop;
                    }
                }
            }
        }

        return allRipen ? day : -1;
    }

    public static Queue<Position> next(int[][][] tomato, Queue<Position> queue) {
        int h = tomato.length;
        int n = tomato[ 0 ].length;
        int m = tomato[ 0 ][ 0 ].length;

        Queue<Position> next = new LinkedList<>();
        while ( queue.size() > 0 ) {
            Position pos = queue.poll();
            if ( pos.h > 0 && tomato[ pos.h - 1 ][ pos.y ][ pos.x ] == 0 ) {
                tomato[ pos.h - 1 ][ pos.y ][ pos.x ] = 1;
                next.add(new Position(pos.h - 1, pos.y, pos.x));
            }
            if ( pos.h < h - 1 && tomato[ pos.h + 1 ][ pos.y ][ pos.x ] == 0 ) {
                tomato[ pos.h + 1 ][ pos.y ][ pos.x ] = 1;
                next.add(new Position(pos.h + 1, pos.y, pos.x));
            }
            if ( pos.y > 0 && tomato[ pos.h ][ pos.y - 1 ][ pos.x ] == 0 ) {
                tomato[ pos.h ][ pos.y - 1 ][ pos.x ] = 1;
                next.add(new Position(pos.h, pos.y - 1, pos.x));
            }
            if ( pos.y < n - 1 && tomato[ pos.h ][ pos.y + 1 ][ pos.x ] == 0 ) {
                tomato[ pos.h ][ pos.y + 1 ][ pos.x ] = 1;
                next.add(new Position(pos.h, pos.y + 1, pos.x));
            }
            if ( pos.x > 0 && tomato[ pos.h ][ pos.y ][ pos.x - 1 ] == 0 ) {
                tomato[ pos.h ][ pos.y ][ pos.x - 1 ] = 1;
                next.add(new Position(pos.h, pos.y, pos.x - 1));
            }
            if ( pos.x < m - 1 && tomato[ pos.h ][ pos.y ][ pos.x + 1 ] == 0 ) {
                tomato[ pos.h ][ pos.y ][ pos.x + 1 ] = 1;
                next.add(new Position(pos.h, pos.y, pos.x + 1));
            }
        }

        return next;
    }

    static class Position {
        public int y;
        public int x;
        public int h;

        public Position(int h, int y, int x) {
            this.y = y;
            this.x = x;
            this.h = h;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int h = scanner.nextInt();

        int[][][] tomato = new int[ h ][ n ][ m ];
        for ( int z = 0; z < h; z++ ) {
            for ( int i = 0; i < n; i++ ) {
                for ( int j = 0; j < m; j++ ) {
                    tomato[ z ][ i ][ j ] = scanner.nextInt();
                }
            }
        }

        System.out.println(solve(tomato));
    }

}
