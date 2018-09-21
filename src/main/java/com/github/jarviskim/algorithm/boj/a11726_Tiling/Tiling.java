package com.github.jarviskim.algorithm.boj.a11726_Tiling;

import java.util.Scanner;

/**
 * n 타일링
 * https://www.acmicpc.net/problem/11726
 * DP 문제.
 */

public class Tiling {

    public static final int MOD = 10007;

    public static int solve(int n) {
        if ( n == 1 ) {
            return 1;
        }
        if ( n == 2 ) {
            return 2;
        }

        int[] d = new int[ n + 1 ];
        d[ 1 ] = 1;
        d[ 2 ] = 2;

        for ( int x = 3; x <= n; x++ ) {
            d[ x ] = (d[ x - 1 ] + d[ x - 2 ]) % MOD;
        }

        return d[ n ];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();

        System.out.println(solve(x));
    }
}
