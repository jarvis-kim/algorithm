package com.github.jarviskim.algorithm.boj.A1934_LCM;

import java.util.Scanner;

/**
 * 최소공배수 2
 *
 * https://www.acmicpc.net/problem/13241
 */
public class LCM2 {
    public static long solve(long a, long b) {
        long aa = a, bb = b;
        long tmp;
        while ( aa % bb != 0 ) {
            tmp = aa;
            aa = bb % aa;
            bb = tmp;
        }

        return a * b / bb;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextInt();
        long b = scanner.nextInt();
        System.out.println(solve(a, b));
    }
}
