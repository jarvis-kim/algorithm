package com.github.jarviskim.algorithm.boj.a10844_EasyStairs;

import java.util.Scanner;

/**
 * 쉬운 계단 수
 * https://www.acmicpc.net/problem/10844
 *
 * d[ i ][ j ] = 길이 i이가 마지막 숫자 j인 계단의 개수
 */
public class EasyStairs {

    static final int MOD = 1000000000;

    public static int solve(int n) {
        int d[][] = new int[ n + 1 ][ 11 ];
        for ( int j = 1; j <= 9; j++ ) {
            d[ 1 ][ j ] = 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(solve(n));
    }
}
