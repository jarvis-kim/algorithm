package com.github.jarviskim.algorithm.boj.a10250_AcmHotel;

import java.util.Scanner;

/**
 * ACM 호텔
 * https://www.acmicpc.net/problem/10250
 */
public class AcmHotel {

    public static int solve(int h, int w, int n) {
        int back = (n - 1) / h + 1;
        int front = (n - 1) % h + 1;

        return front * 100 + back;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int caseN = scanner.nextInt();
        for ( int i = 0; i < caseN; i++ ) {
            int h = scanner.nextInt();
            int w = scanner.nextInt();
            int n = scanner.nextInt();
            System.out.println(solve(h, w, n));
        }
    }
}
