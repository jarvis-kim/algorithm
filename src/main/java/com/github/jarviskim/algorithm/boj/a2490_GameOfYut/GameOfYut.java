package com.github.jarviskim.algorithm.boj.a2490_GameOfYut;

import java.util.Scanner;

/**
 * 윷놀이
 *
 * https://www.acmicpc.net/problem/2490
 */
public class GameOfYut {

    private static char[] YUT = new char[] { 'E', 'A', 'B', 'C', 'D' };

    public static char solve(int[] yut) {
        if ( yut.length != 4 ) {
            throw new IllegalArgumentException("yut's is four.");
        }

        int index = 0;
        for ( int y : yut ) {
            if ( y == 0 ) {
                index++;
            } else if ( y != 1 ){
                throw new IllegalArgumentException("yot is one or zero");
            }
        }

        return YUT[ index ];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for ( int i = 0; i < 3; i++ ) {
            int[] yut = new int[ 4 ];
            for ( int j = 0; j < 4; j++ ) {
                yut[ j ] = scanner.nextInt();
            }

            System.out.println(solve(yut));
        }

    }
}
