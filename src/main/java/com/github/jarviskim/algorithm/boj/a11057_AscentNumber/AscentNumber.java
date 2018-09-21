package com.github.jarviskim.algorithm.boj.a11057_AscentNumber;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 오르막 수
 * https://www.acmicpc.net/problem/11057
 *
 *  d[ i ][ j ] = i개수의 j를 마지막으로 갖는 오르막 수
 *  d[ i ][ j ] = j-1개수의 j보다 작거나 같은오르막 수 + .........
 *
 *  d[ i ][ j ] = < - 1개(n 값이 하나 작았던)것  +   j - 1(j 전의 값 들 )
 */
public class AscentNumber {

    static final int MOD = 10007;

    public static int solve(int n) {

        int d[][] = new int[ n + 1 ][ 10 ];
        for ( int j = 0; j < 10; j++ ) {
            d[ 1 ][ j ] = 1;
        }
        for ( int i =2; i <= n; i++ ) {
            d[ i ][ 0 ] = 1;
        }

        for ( int i = 2; i <= n; i++ ) {
            for ( int j = 1; j < 10; j++ ) {
                d[ i ][ j ] = (d[ i ][ j - 1 ] + d[ i - 1 ][ j ]) % MOD;
            }
        }

        return IntStream.of(d[ n ]).sum() % MOD;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        System.out.println(solve(n));

    }

}
