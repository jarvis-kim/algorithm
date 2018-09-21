package com.github.jarviskim.algorithm.boj.a9251_LCS;

import java.util.Scanner;

/**
 * LCS
 *
 * https://www.acmicpc.net/problem/9251
 *
 * DP로 품.
 */
public class LCS {

    public static int solve(char[] str1, char[] str2) {
        int[][] lcs = new int[ str1.length + 1 ][ str2.length + 1 ];

        for ( int i = 1; i < lcs.length; i++ ) {
            for ( int j = 1; j < lcs[ i ].length; j++ ) {
                if ( str1[ i - 1 ] != str2[ j - 1 ] ) {
                    lcs[ i ][ j ] = Math.max(lcs[ i ][ j - 1 ], lcs[ i - 1 ][ j ]);
                } else if ( str1[ i - 1 ] == str2[ j - 1 ] ) {
                    lcs[ i ][ j ] = lcs[ i - 1 ][ j - 1 ] + 1;
                }
            }
        }

        return lcs[ str1.length ][ str2.length ];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();

        System.out.println(solve(str1.toCharArray(), str2.toCharArray()));
    }
}
