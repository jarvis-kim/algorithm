package com.github.jarviskim.algorithm.boj.a9461_PadovanSequence;

import java.util.Scanner;

/**
 * 파도반 수열
 *
 * https://www.acmicpc.net/problem/9461
 */
public class PadovanSequence {

    private final static long[] initData = new long[] { 1, 1, 1, 2, 2 };

    public static long solve(int n) {
        int len = Math.max(n, 5);
        long[] d = new long[ len ];
        System.arraycopy(initData, 0, d, 0, initData.length);

        for ( int i = 5; i < n; i++ ) {
            d[ i ] = d[ i - 1 ] + d[ i - 5 ];
        }

        return d[ n - 1 ];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseCount = scanner.nextInt();
        for ( int i = 0; i < caseCount; i++ ) {
            int n = scanner.nextInt();
            System.out.println(solve(n));
        }
    }
}
