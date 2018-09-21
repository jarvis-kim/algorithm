package com.github.jarviskim.algorithm.boj.a2747_fibonacci;

import java.util.Scanner;

public class Fibonacci {

    public static int solve(int n) {
        int[] array = new int[ n + 1 ];
        array[ 1 ] = 1;
        for ( int index = 2; index <= n; index++ ) {
            array[ index ] = array[ index - 1 ] + array[ index - 2 ];
        }

        return array[ n ];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(solve(n));
    }
}
