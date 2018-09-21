package com.github.jarviskim.algorithm.boj.a2225_SumCount;

import java.util.Scanner;

/**
 * 합분해
 * https://www.acmicpc.net/problem/2225
 */
public class SumCount {

    public static final long MOD = 1000000000;

    public static long solve(int n, int k) {

        long d[][] = new long[ k + 1 ][ n + 1 ];

        long sum;
        for ( int i = 1; i <= n; i++ ) {
            for ( int ka = 1; ka <= k; ka++ ) {
                sum = 0;
                for ( int j = 0; j <= i; j++ ) {
                    sum += d[ ka - 1  ][ i - j ] % MOD;
                }
                d[ ka ][ i ] = (sum + 1) % MOD ;
            }
        }

        return d[ k ][ n ];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(solve(n, k));
    }

}
