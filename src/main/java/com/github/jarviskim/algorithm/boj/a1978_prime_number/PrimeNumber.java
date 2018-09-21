package com.github.jarviskim.algorithm.boj.a1978_prime_number;

import java.util.Arrays;
import java.util.Scanner;

public class PrimeNumber {

    public static boolean checkPrimeNumber(int number) {
        if ( number < 2 ) {
            return false;
        }

        int m = (int) Math.sqrt(number);

        for ( int i = 2; i <= m; i++ ) {
            if ( number % i == 0 ) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[ n ];
        for ( int i = 0; i < n; i++ ) {
            numbers[ i ] = scanner.nextInt();
        }

        /* BOJ 에서는 Class 이름이 Main이라 래퍼런스 사용 불가. */
        long count = Arrays.stream(numbers)
                .filter(num -> checkPrimeNumber(num))
                .count();

        System.out.println(count);
    }
}
