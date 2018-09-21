package com.github.jarviskim.algorithm.boj.a1149_RGBStreet;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * RGB 거리
 * https://www.acmicpc.net/problem/1149
 * <p>
 * 최소 비용 = min(rgb)
 * rgb[ i ] = min(rgb[ i - 1]),  i != i - 1
 */
public class RGBStreet {

    public static int solve(int[][] rgbCost) {
        int n = rgbCost.length;
        int[][] rgb = new int[ n ][ 3 ];
        rgb[ 0 ] = rgbCost[ 0 ];

        for ( int i = 1; i < n; i++ ) {
            rgb[ i ][ 0 ] = rgbCost[ i ][ 0 ] + Math.min(rgb[ i - 1 ][ 1 ], rgb[ i - 1 ][ 2 ]);
            rgb[ i ][ 1 ] = rgbCost[ i ][ 1 ] + Math.min(rgb[ i - 1 ][ 0 ], rgb[ i - 1 ][ 2 ]);
            rgb[ i ][ 2 ] = rgbCost[ i ][ 2 ] + Math.min(rgb[ i - 1 ][ 0 ], rgb[ i - 1 ][ 1 ]);
        }

        return IntStream.of(rgb[ n - 1 ]).min().getAsInt();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] cost = new int[ n ][ 3 ];
        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < 3; j++ ) {
                cost[ i ][ j ] = scanner.nextInt();
            }
        }

        System.out.println(solve(cost));
    }
}
