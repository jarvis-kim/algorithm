package com.github.jarviskim.algorithm.boj.a1003_FibonacciCount;

import java.util.Scanner;
import java.util.stream.Stream;

/**
 * 피보나치 함수
 * https://www.acmicpc.net/problem/1003
 *
 * 0, 1의 호출 Finonacci 함수가 몇번되는지 찾는 문제.
 * 동적계획법으로 품.
 */
public class FibonacciCount {

    public static int[] solve(int n) {
        if ( n == 0 ) {
            return new int[] { 1, 0 };
        }
        int[][] result = new int[ n +1 ][ 2];
        result[ 0 ][ 0 ] = 1;
        result[ 0 ][ 1 ] = 0;
        result[ 1 ][ 0 ] = 0;
        result[ 1 ][ 1 ] = 1;


        for ( int i = 2; i <= n; i++ ) {
            result[ i ][ 0 ] = result[ i - 1 ][ 0 ] + result[ i - 2 ][ 0 ];
            result[ i ][ 1 ] = result[ i - 1 ][ 1 ] + result[ i - 2 ][ 1  ];
        }

        return Stream.of(result).skip(n).map(ints -> new int[] { ints[ 0 ], ints[ 1 ] }).findFirst().get();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for ( int i = 0; i < t; i++ ) {
            int n = scanner.nextInt();
            int result[]= solve(n);
            System.out.printf("%d %d", result[ 0 ], result[ 1 ]);
            System.out.println();
        }
    }


}
