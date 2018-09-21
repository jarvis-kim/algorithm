package com.github.jarviskim.algorithm.boj.a4948_prime_number;

import java.util.Scanner;

/**
 * 베르트랑 공준
 * 
 */
public class ChebyshevTheorem {

    public static int solve(int n) {
        final int end = n * 2;

        int count = 0;
        boolean[] numbers = new boolean[ end + 1 ];
        int root = (int) Math.sqrt(end);
        for ( int number = 2; number <= root; number++ ) {
            for ( int index = number * 2; index <= end; index += number ) {
                numbers[ index ] = true;
            }
        }

        int index = n + 1;
        for ( ; index < numbers.length; index++ ) {
            if ( !numbers[ index ] ) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        while ( (number = scanner.nextInt()) != 0 ) {
            System.out.println(solve(number));
        }
    }
}
