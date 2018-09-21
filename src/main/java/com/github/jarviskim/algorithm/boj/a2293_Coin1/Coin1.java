package com.github.jarviskim.algorithm.boj.a2293_Coin1;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 동전 1
 * https://www.acmicpc.net/problem/2293
 *
 * DP
 * w = 코인의 값으로
 * d = k 가 되어야하는..
 *
 * Σ d[ k ][ w ] = 동전의 합이 k가 되는 경우의 수 (0 < w)
 * Σ d[ k - Wi ][ w ] = 동전의 합이 k가 되는 경우의 수 ( 0 < w )
 * d[ k ][ w ] = 1 ,  k - w == 0
 */
public class Coin1 {

    public static int solve(int k, int... coins) {
        int[][] d = new int[ k + 1 ][ coins.length + 1 ];

        for ( int coin = 1; coin <= k; coin++ ) {
            for ( int coinsIndex = 0; coinsIndex < coins.length; coinsIndex++ ) {
                if ( coin - coins[ coinsIndex ] == 0 ) {
                    d[ coin ][ coinsIndex ] = 1;
                } else if ( coin - coins[ coinsIndex ] > 0 ) {
                    d[ coin ][ coinsIndex ] = sum(d[ coin - coins[ coinsIndex ] ], coinsIndex);
                }
            }
        }

        return IntStream.of(d[ k ]).sum();
    }

    public static int sum(int[] d, int to) {
        int sum = 0;
        for ( int i = 0; i <= to; i++ ) {
            sum += d[ i ];
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] coins = new int[ n ];
        for ( int i = 0; i < n; i++ ) {
            coins[ i ] = scanner.nextInt();
        }

        System.out.println(solve(k, coins));
    }


}
