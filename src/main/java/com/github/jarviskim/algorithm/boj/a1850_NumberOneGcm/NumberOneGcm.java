package com.github.jarviskim.algorithm.boj.a1850_NumberOneGcm;

import java.util.Scanner;
import java.util.stream.LongStream;

/**
 * 최대 공약수
 * https://www.acmicpc.net/submit/1850
 */
public class NumberOneGcm {

    public static long solve(long a, long b) {
        long aa = a;
        long bb = b;
        long tmp = aa % bb;
        while (tmp > 0) {
            aa = bb;
            bb = tmp;
            tmp = aa % bb;
        }

        return nToNUmberOne(bb);
    }

    private static long nToNUmberOne(long n) {
        return LongStream.range(1, n)
                .reduce(1, (left, right) -> {
                    return left * 10 + 1;
                });
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        System.out.println(solve(a, b));
    }
}
