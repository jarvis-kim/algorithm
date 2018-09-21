package com.github.jarviskim.algorithm.boj.a2577_NumberCount;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 숫자의 개수
 * https://www.acmicpc.net/problem/2577
 */
public class NumberCount {

    public static int[] solve(int a, int b, int c) {
        int[] result = new int[10];
        int  multiply = a * b * c;

        if (multiply == 0) {
            result[0]++;
            return result;
        }

        while (multiply != 0) {
            result[multiply % 10]++;
            multiply = multiply / 10;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        Arrays.stream(solve(a, b, c))
                .forEach(System.out::println);
    }
}
