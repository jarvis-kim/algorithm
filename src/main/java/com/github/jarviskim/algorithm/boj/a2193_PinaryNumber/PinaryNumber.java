package com.github.jarviskim.algorithm.boj.a2193_PinaryNumber;

import java.util.Scanner;

/**
 * 이친수
 * https://www.acmicpc.net/problem/2193
 *
 * d[ i ][ j ] = i번째 자시수의 j(0 or 1)수로 끝나는 이친수의 개수
 * d[ i ][ j ] =
 *       {
 *               j == 0,    d[ i - 1][ 0 ] + d[ i - 1][ 1]
 *               j == 1,    d[ i - 1][ 0 ]
 *        }
 */
public class PinaryNumber {

    public static long solve(int n) {
        long[][] d = new long[ n + 1 ][ 2 ];
        d[ 1 ][ 1 ] = 1;

        for ( int i = 2; i <= n; i++ ) {
            d[ i ][ 0 ] = d[ i - 1 ][ 0 ] + d[ i - 1 ][ 1 ];
            d[ i ][ 1 ] = d[ i - 1 ][ 0 ];
        }

        return d[ n ][ 0 ] + d[ n ][ 1 ];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(solve(n));
    }

}
