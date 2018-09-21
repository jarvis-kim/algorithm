package com.github.jarviskim.algorithm.boj.a11053_LongSubset;

import java.util.Scanner;

/**
 * 가장 긴 증가하는 부분 수열
 * https://www.acmicpc.net/problem/11053
 *
 * DP로 품
 *
 * d[ i ] = i번째 가장 긴 증가 수열
 * d[ i ] = max(d[ j ] +1, d[ i ]) , j = i - 1 to 1
 */
public class LongSubset {

    public static int solve(int... a) {
        int n = a.length;
        int[] d = new int[ n + 1 ];
        int[] sub = new int[ n + 1];

        for ( int i = 1; i <= n; i++ ) {
            sub[ i ] = 1;
        }

        for ( int i = 1; i <= n; i++ ) {
            for ( int j = i - 1; j > 0; j-- ) {
                if ( a[ i - 1 ] > a[ j - 1 ] ) {
                    sub[ i ] = Math.max(sub[ j ] + 1, sub[ i ]);
                }
            }
            
            d[ i ] = Math.max(d[ i - 1 ], sub[ i ]);
        }

        return d[ n ];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[ n ];
        for ( int i = 0; i < n; i++ ) {
            a[ i ] = scanner.nextInt();
        }

        System.out.println(solve(a));
    }
}
