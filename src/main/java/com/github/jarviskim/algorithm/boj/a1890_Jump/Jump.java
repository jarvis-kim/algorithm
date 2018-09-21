package com.github.jarviskim.algorithm.boj.a1890_Jump;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 점프
 *
 * https://www.acmicpc.net/problem/1890
 *
 * 점화식
 * 이동가능한 경우의 수 = d[ i - x][ j ] + d[ i ][ j - x ]   ,  (x < i, j  --  x + m[ x ][ j ] == i  | x + m[ i ][ x ] == j)
 */
public class Jump {

    public static BigDecimal solve(int[][] map) {
        int n = map.length;
        int m = n;

        BigDecimal[][] d = new BigDecimal[ n ][ m ];

        for ( int i = 0; i < d.length; i++ ) {
            Arrays.fill(d[ i ], new BigDecimal(0));
        }
        d[ 0 ][ 0 ] = new BigDecimal(1);

        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < m; j++ ) {
                for ( int y = 0; y < i; y++ ) {
                    if ( y + map[ y ][ j ] == i ) {
                        d[ i ][ j ] = d[ i ][ j ].add(d[ y ][ j ]);
                    }
                }

                for ( int x = 0; x < j; x++ ) {
                    if ( x + map[ i ][ x ] == j ) {
                        d[ i ][ j ] = d[ i ][ j ].add(d[ i ][ x ]);
                    }
                }
            }
        }

        return d[ n - 1 ][ m - 1 ];
    }

    /**
     * 두자리 범위의 디버깅요 코드
     * @param map
     * @param d
     */
    public static void print(int[][] map, BigDecimal[][] d) {
        int n = map.length;
        int m = n;

        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < m; j++ ) {
                System.out.printf("%2d |", map[ i ][ j ]);
            }
            System.out.println();
        }

        System.out.println("----------------------");

        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < m; j++ ) {
                System.out.printf("%2d |", d[ i ][ j ].intValue());
            }
            System.out.println();
        }

        System.out.println("===================================");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] map = new int[ n ][ n ];
        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < n; j++ ) {
                map[ i ][ j ] = scanner.nextInt();
            }
        }

        System.out.println(solve(map));
    }

}
