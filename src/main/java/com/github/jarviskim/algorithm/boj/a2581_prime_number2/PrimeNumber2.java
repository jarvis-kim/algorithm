package com.github.jarviskim.algorithm.boj.a2581_prime_number2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeNumber2 {

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

    public static List<Integer> result(int m, int n) {
        List<Integer> primeNumbers = new ArrayList<>();

        int i = m == 1 ? 2 : m;
        for ( ; i <= n; i++ ) {
            if ( checkPrimeNumber(i) ) {
                primeNumbers.add(i);
            }
        }

        return primeNumbers;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        List<Integer> list = result(m, n);

        if ( list.size() > 0 ) {
            int sum = list.stream()
                    .mapToInt(Integer::intValue)
                    .sum();
            System.out.println(sum);

            list.stream()
                    .mapToInt(Integer::intValue)
                    .min()
                    .ifPresent(System.out::println);

        } else {
            System.out.println(-1);
        }
    }
}
