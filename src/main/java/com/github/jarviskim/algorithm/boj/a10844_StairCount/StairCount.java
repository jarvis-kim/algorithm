package com.github.jarviskim.algorithm.boj.a10844_StairCount;

import java.util.Scanner;
import java.util.stream.LongStream;

/**
 * 쉬운 계단 수
 * https://www.acmicpc.net/problem/10844
 */
public class StairCount {

    private final static int MOD = 1000000000;

    public static long solve(int n) {
        long[][] s = new long[ n + 1 ][ 9 + 1 ];
        for ( int number = 1; number <= 9; number++ ) {
            s[ 1 ][ number ] = 1;
        }

        for ( int i = 2; i <= n; i++ ) {
            for ( int j = 0; j <= 9; j++ ) {
                if ( j - 1 >= 0 ) {
                    s[ i ][ j ] += s[ i - 1][ j - 1];
                }
                if ( j + 1 <= 9 ) {
                    s[ i ][ j ] += s[ i - 1][ j + 1];
                }
                s[ i ][ j ] %= MOD;
            }
        }

        return LongStream.of(s[ n ]).sum() % MOD;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(solve(n));
        for ( int num = 1; num <= 100; num++ ) {
            if ( solve(num) < 0 ) {
                System.out.println(num);
            }
        }
    }
}
