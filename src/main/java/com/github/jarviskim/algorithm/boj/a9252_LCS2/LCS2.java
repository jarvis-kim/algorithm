package com.github.jarviskim.algorithm.boj.a9252_LCS2;

import java.util.Scanner;

/**
 * LCS 2
 *
 * https://www.acmicpc.net/problem/9252
 */
public class LCS2 {

    static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return "Pos[y : " + y + ", x : " + x + "]";
        }
    }

    public static String solve(char[] str1, char[] str2) {
        int[][] lcs = new int[ str1.length + 1 ][ str2.length + 1 ];
        Pos[][] tracking = new Pos[ str1.length + 1 ][ str2.length + 1 ];

        for ( int i = 1; i < lcs.length; i++ ) {
            for ( int j = 1; j < lcs[ i ].length; j++ ) {
                if ( str1[ i - 1 ] != str2[ j - 1 ] ) {
                    if ( lcs[ i ][ j - 1 ] > lcs[ i - 1 ][ j ] ) {
                        lcs[ i ][ j ] = lcs[ i ][ j - 1 ];
                        tracking[ i ][ j ] = new Pos(i, j - 1);
                    } else {
                        lcs[ i ][ j ] = lcs[ i - 1 ][ j ];
                        tracking[ i ][ j ] = new Pos(i - 1, j);
                    }
                } else if ( str1[ i - 1 ] == str2[ j - 1 ] ) {
                    lcs[ i ][ j ] = lcs[ i - 1 ][ j - 1 ] + 1;
                    tracking[ i ][ j ] = new Pos(i - 1, j - 1);
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        int i = str1.length;
        int j = str2.length;

        while ( i != 0 && j != 0 ) {
            if ( tracking[ i ][ j ].y == i - 1 && tracking[ i ][ j ].x == j - 1 ) {
                builder.append(str1[ i - 1 ]);
            }

            Pos current = tracking[ i ][ j ];
            i = current.y;
            j = current.x;
        }

        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();

        String result = solve(str1.toCharArray(), str2.toCharArray());
        System.out.println(result.length());
        System.out.println(result);
    }
}
