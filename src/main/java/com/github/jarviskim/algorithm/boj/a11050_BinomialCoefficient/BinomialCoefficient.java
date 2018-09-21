package com.github.jarviskim.algorithm.boj.a11050_BinomialCoefficient;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 이항 계수
 * https://www.acmicpc.net/problem/11050
 */
public class BinomialCoefficient {

    public static int solve(int n, int k) {
        if ( k < 0 || k > n ) {
            return 0;
        }

        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    public static int factorial(int number) {
        return IntStream.rangeClosed(2, number).reduce(1, (x, y) -> x * y);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solve(scanner.nextInt(), scanner.nextInt()));
    }

}
