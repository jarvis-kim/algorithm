package com.github.jarviskim.algorithm.boj.a2839_Secer;

/**
 * 설탕 배달
 * https://www.acmicpc.net/problem/2839
 */
public class Secer {

    public static int solve(int n) {
        if ( n == 3 || n == 5) {
            return 1;
        }
        if ( n < 5 ) {
            return -1;
        }

        int b = 0, a = 0;
        a = solve(n - 5);
        b = solve(n - 3);

        if ( a == -1 && b == -1 ) {
            return -1;
        }
        if ( a < 0 ) {
            return b + 1;
        }
        if ( b < 0 ) {
            return a + 1;
        }
        
        return Math.min(a, b) + 1;
    }

    public static int solve2(int n) {
        if ( n == 3 ) {
            return 1;
        }
        if ( n < 5 ) {
            return -1;
        }

        int[] d = new int[ n + 1];
        d[ 1 ] = Integer.MAX_VALUE;
        d[ 2 ] = Integer.MAX_VALUE;
        d[ 3 ] = 1;
        d[ 4 ] = Integer.MAX_VALUE;

        int a, b;
        for ( int i = 5; i <= n; i++ ) {
            a = d[ i - 3 ];
            b = d[ i - 5 ];
            if ( a == Integer.MAX_VALUE && b == Integer.MAX_VALUE ) {
                d[ i ] = Integer.MAX_VALUE;
            } else {
                d[ i ] = Math.min(a, b) + 1;
            }
        }

        return d[ n ] == Integer.MAX_VALUE ? -1 : d[ n ];
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(solve2(n));
    }

}