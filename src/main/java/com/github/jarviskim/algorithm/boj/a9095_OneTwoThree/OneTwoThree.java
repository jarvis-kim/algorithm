package com.github.jarviskim.algorithm.boj.a9095_OneTwoThree;

import java.util.Scanner;

/**
 * 1, 2, 3 더하기
 * https://www.acmicpc.net/problem/9095
 */


public class OneTwoThree {

    public static int solve(int n) {
        if ( n == 0 ) {
            return 0;
        }
        if ( n == 1 ) {
            return 1;
        }
        if ( n == 2 ) {
            return 2;
        }

        int d[] = new int[ n + 1 ];
        d[ 0 ] = 1;
        d[ 1 ] = 1;
        d[ 2 ] = 2;
        for ( int x = 3; x <= n; x++ ) {
            d[ x ] = d[ x - 1 ] + d[ x - 2 ] + d[ x - 3 ];
        }

        return d[ n ];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int n;
        for ( int count = 0; count < t; count++ ) {
            n = scanner.nextInt();
            System.out.println(solve(n));
        }
    }
}
