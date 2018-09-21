package com.github.jarviskim.algorithm.boj.A1934_LCM;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 최소 공배수
 *
 * https://www.acmicpc.net/problem/1934
 */
public class LCM {

    public static int solve(int a, int b) {
        int aa = a, bb = b;
        int tmp;
        while ( aa % bb != 0 ) {
            tmp = aa;
            aa = bb % aa;
            bb = tmp;
        }

        return a * b / bb;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        IntStream.range(0, testCase)
                .forEach(value -> {
                    System.out.println(value);
                    int a = scanner.nextInt();
                    int b = scanner.nextInt();
                    System.out.println(solve(a, b));
                });
    }
}
