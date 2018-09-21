package com.github.jarviskim.algorithm.boj.a2516_WineTaste;

import java.util.Scanner;

/**
 * 포도주 시식
 * https://www.acmicpc.net/problem/2156
 * <p>
 * max(d(i - 1) + w[ i ], d(i - 1)) = 포도주를 마시는 최대의 양
 */
public class WineTaste {

    public static int solve(int... wines) {
        int n = wines.length;
        int[] sums = new int[ n ];

        sums[ 0 ] = wines[ 0 ];
        if ( n == 1 ) {
            return sums[ 0 ];
        }
        sums[ 1 ] = wines[ 0 ] + wines[ 1 ];
        if ( n == 2 ) {
            return sums[ 1 ];
        }
        sums[ 2 ] = Math.max(sums[ 1 ], Math.max(sums[ 0 ] + wines[ 2 ], wines[ 1 ] + wines[ 2 ]));

        for ( int i = 3; i < n; i++ ) {
            sums[ i ] = Math.max(sums[ i - 1 ], Math.max(sums[ i - 2 ] + wines[ i ], sums[ i - 3 ] + wines[ i - 1 ] + wines[ i ]));
        }

        return sums[ n - 1 ];
    }


    private int[] wines;

    private int[][] memoization;

    public WineTaste(int... wines) {
        this.wines = wines;
        memoization = new int[ wines.length ][ 3 ];
    }

    public int solveWineTaste(int index, int jump) {
        if ( jump == 2 ) {
            if ( index - 1 < 0 ) {
                return 0;
            }

            if ( memoization[ index - 1 ][ 2 ] != 0 ) {
                return memoization[ index - 1 ][ 2 ];
            }

            return memoization[ index - 1 ][ 2 ] = solveWineTaste(index - 1, 0);
        }

        if ( index - 1 < 0 ) {
            if ( memoization[ index ][ jump + 1 ] == 0 ) {
                memoization[ index ][ jump + 1 ] = wines[ index ];
            }
        } else {
            if ( memoization[ index ][ jump + 1 ] == 0 ) {
                memoization[ index ][ jump + 1 ] = solveWineTaste(index - 1, jump + 1) + wines[ index ];
            }

            if ( memoization[ index  ][ 0 ] == 0 ) {
                memoization[ index ][ 0 ] = solveWineTaste(index - 1, 0);
            }
        }

        return Math.max(memoization[ index ][ jump + 1 ], memoization[ index ][ 0 ]);
    }

    public int solveWineTaste2(int index, int jump) {
        if ( index < 0 ) {
            return 0;
        }
        if ( jump == 2 ) {
            return solveWineTaste2(index - 1, 0);
        }

        return Math.max(solveWineTaste2(index - 1, jump + 1) + wines[ index ], solveWineTaste2(index - 1, 0));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] wines = new int[ n ];
        for ( int i = 0; i < n; i++ ) {
            wines[ i ] = scanner.nextInt();
        }

        System.out.println(solve(wines));
    }
}