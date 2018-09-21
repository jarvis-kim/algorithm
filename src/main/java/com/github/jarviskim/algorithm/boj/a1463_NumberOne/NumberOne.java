package com.github.jarviskim.algorithm.boj.a1463_NumberOne;
/**
 * 1로 만들기
 * https://www.acmicpc.net/problem/1463
 *
 * DP로 품
 */

import java.util.Scanner;
import java.util.stream.IntStream;

public class NumberOne {

    /**
     * 2018. 01. 31일 다시 품.
     * 기존 solve()는 n=1 일때 처리를 안해줘서 오답이 나옴.
     * @param n
     * @return
     */
    public static int solve2(int n) {
        if ( n == 1 ) {
            return 0;
        }
        if ( n <= 3 ) {
            return 1;
        }
        int[] array = new int[ n + 1 ];
        array[ 1 ] = 0;
        array[ 2 ] = 1;
        array[ 3 ] = 1;

        int number3;
        int number2;
        int number1;
        for ( int number = 4; number <= n; number++ ) {
            number3 = Integer.MAX_VALUE;
            number2 = Integer.MAX_VALUE;
            number1 = array[ number - 1 ] + 1;
            if ( number % 3 == 0 ) {
                number3 = array[ number / 3 ] + 1;
            }
            if ( number % 2 == 0 ) {
                number2 = array[ number / 2 ] + 1;
            }

            array[ number ] = IntStream.of(number1, number2, number3).min().getAsInt();
        }

        return array[ n ];
    }

    public static int solve(int n) {
        if ( n <= 3 ) {
            return 1;
        }
        int d[] = new int[ n + 1 ];
        d[ 2 ] = 1;
        d[ 3 ] = 1;
        int min;
        for ( int x = 4; x <= n; x++ ) {
            min = Integer.MAX_VALUE;
            if ( x % 3 == 0 ) {
                min = Math.min(min, d[ x / 3 ] + 1);
            }
            if ( x % 2 == 0 ) {
                min = Math.min(min, d[ x / 2 ] + 1);
            }
            min = Math.min(min, d[ x - 1 ] + 1);
            d[ x ] = min;
        }

        return d[ n ];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.println(solve2(x));
    }

}
