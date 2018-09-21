package com.github.jarviskim.algorithm.boj.a1929_prime_number;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Eratos {

    public static List<Integer> eratos(int start, int end) {
        List<Integer> primeNumbers = new LinkedList<>();
        boolean[] numbers = new boolean[ end + 1 ];
        int root = (int) Math.sqrt(end);
        for ( int number = 2; number <= root; number++ ) {
            for ( int index = number * 2; index <= end; index += number ) {
                numbers[ index ] = true;
            }
        }

        int index = start > 1 ? start : 2;
        for ( ; index < numbers.length; index++ ) {
            if ( !numbers[ index ] ) {
                primeNumbers.add(index);
            }
        }

        return primeNumbers;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();

        eratos(m, n).forEach(System.out::println);
    }


}
