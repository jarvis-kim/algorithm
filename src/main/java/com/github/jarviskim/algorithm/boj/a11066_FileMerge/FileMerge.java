package com.github.jarviskim.algorithm.boj.a11066_FileMerge;

import java.util.Scanner;

/**
 * 파일 합치기
 * <p>
 * https://www.acmicpc.net/problem/11066
 */
public class FileMerge {

    public static int solve(int... fileCosts) {
        int n = fileCosts.length;
        int[][] sums = new int[ n ][ n ];
        int[][] accumulates = new int[ n ][ n ];

        for ( int i = 0; i < n; i++ ) {
            sums[ i ][ i ] = fileCosts[ i ];
        }

        for ( int i = 0; i < n; i++ ) {
            int k = 0;
            for ( int j = i + 1; j < n; j++, k++ ) {
                fileMergeOfMin(sums, accumulates, k, j);
            }

        }

//        for ( int i = 0; i < n; i++ ) {
//            for ( int j = 0; j < n; j++ ) {
//                System.out.printf("%4d", sums[ i ][ j ]);
//            }
//            System.out.println();
//        }
//
//        System.out.println();
//        for ( int i = 0; i < n; i++ ) {
//            for ( int j = 0; j < n; j++ ) {
//                System.out.printf("%4d", accumulates[ i ][ j ]);
//            }
//            System.out.println();
//        }
//
//        System.out.println();

        return accumulates[ 0 ][ n - 1 ];
    }

    private static void fileMergeOfMin(int[][] sums, int[][] accumulates, int i, int j) {
        int min = Integer.MAX_VALUE;
        int y = i;
        for ( int x = i; x < j; x++  ) {
            int accumulate = (sums[ y ][ x ] + sums[ x + 1 ][ j ]) + (accumulates[ y ][ x ] + accumulates[ x + 1 ][ j ]);
            if ( accumulate < min ) {
                min = accumulate;
                accumulates[ i ][ j ] = min;
                sums[ i ][ j ]  = sums[ y ][ x ] + sums[ x + 1 ][ j ];
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCount = scanner.nextInt();
        for ( int i = 0; i < testCount; i++ ) {
            int n = scanner.nextInt();
            int[] data = new int[ n ];
            for ( int j = 0; j < n; j++ ) {
                data[ j ] = scanner.nextInt();
            }
            System.out.println(solve(data));
        }
    }
}
