package com.github.jarviskim.algorithm.boj.a1932_NumberTriangle;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 숫자 삼각형
 * https://www.acmicpc.net/problem/1932
 */
public class NumberTriangle {

    public static int solve(int[][] numbers) {

        int n = numbers.length;
        int[][] result = new int[ numbers.length ][ numbers.length ];
        result[ 0 ][ 0 ] = numbers[ 0 ][ 0 ];
        for ( int i = 1; i < n; i++ ) {
            result[ i ][ 0 ] = numbers[ i ][ 0 ] + result[ i - 1 ][ 0 ];
        }

        for ( int i = 1; i < numbers.length; i++ ) {
            for ( int j = 1; j <= i; j++ ) {
                result[ i ][ j ] = numbers[ i ][ j ] + Math.max(result[ i - 1 ][ j - 1 ], result[ i - 1 ][ j ]);
            }
        }

        return IntStream.of(result[ n - 1 ]).max().getAsInt();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] input = new int[ n ][ n ];

        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j <= i; j++ ) {
                input[ i ][ j ] = scanner.nextInt();
            }
        }

        System.out.println(solve(input));
    }
}
