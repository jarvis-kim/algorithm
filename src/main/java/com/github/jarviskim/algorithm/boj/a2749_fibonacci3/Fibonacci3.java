package com.github.jarviskim.algorithm.boj.a2749_fibonacci3;

import java.util.Scanner;

public class Fibonacci3 {

    private static int MOD = 1000000;
    private static int p = MOD / 10 * 15;

    public static long solve(long n) {
        if ( n < 2 ) {
            return n;
        }
        long[] array = new long[ p ];
        array[ 1 ] = 1;

        for ( int index = 2; index < p; index++ ) {
            array[ index ] = (array[ index - 1 ] + array[ index - 2 ]) % MOD;
        }

        return array[ (int) (n % p) ];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        System.out.println(solve(n));

    }
}
