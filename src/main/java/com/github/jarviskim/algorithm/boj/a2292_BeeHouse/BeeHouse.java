package com.github.jarviskim.algorithm.boj.a2292_BeeHouse;

import java.util.Scanner;

/**
 * 벌집
 * https://www.acmicpc.net/problem/2292
 */
public class BeeHouse {

    static final int MULTIPLE = 6;

    public static int solve(int n) {
        int count = 1;
        int current = 1;
        while ( current < n ) {
            current += MULTIPLE * count;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(solve(n));
    }
}
