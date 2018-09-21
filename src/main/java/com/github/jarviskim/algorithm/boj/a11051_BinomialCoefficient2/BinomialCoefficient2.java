package com.github.jarviskim.algorithm.boj.a11051_BinomialCoefficient2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 이항계수2
 * https://www.acmicpc.net/problem/11051
 */
public class BinomialCoefficient2 {

    private static int MOD = 10007;

    public static int solve(int n, int k) {
        int[][] pascalTriangle = new int[ n + 1 ][ n + 1 ];
        Arrays.fill(pascalTriangle[ 0 ], 1);
        for ( int i = 0; i <= n; i++ ) {
            pascalTriangle[ i ][ 0 ] = 1;
        }
        pascalTriangle[ 1 ][ 1 ] = 1;

        for ( int ni = 2; ni <= n; ni++ ) {
            for ( int ki = 1; ki <= ni; ki++ ) {
                pascalTriangle[ ni ][ ki ] = (pascalTriangle[ ni - 1 ][ ki - 1 ] + pascalTriangle[ ni - 1 ][ ki ]) % MOD;
            }
        }

        return pascalTriangle[ n ][ k ];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solve(scanner.nextInt(), scanner.nextInt()));
    }
}
