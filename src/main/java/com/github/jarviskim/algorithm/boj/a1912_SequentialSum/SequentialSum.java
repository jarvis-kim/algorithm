package com.github.jarviskim.algorithm.boj.a1912_SequentialSum;

import java.util.Scanner;

/**
 * 연속합
 * https://www.acmicpc.net/problem/1912
 * <p>
 * d[ i ] = i를 마지막으로 연속한 수열중 가장 큰합
 * d[ i ]
 * =  d[ i - 1] + a[ i ]        , d[ i - 1] + a[ i ] > max
 * = a[ i ]                         , d[ i - 1] + a[ i ] <= max
 */
public class SequentialSum {

    public static int solve(int... a) {
        int n = a.length;
        int[] d = new int[ n ];

        d[ 0 ] = a[ 0 ];
        int max = a[ 0 ];

        for ( int i = 1; i < n; i++ ) {
            d[ i ] = a[ i ];
            d[ i ] = Math.max(d[ i - 1 ] + a[ i ], a[ i ]);

            max = Math.max(d[ i ], max);
        }

        return max;
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
