package com.github.jarviskim.algorithm.boj.a2965_ThreeCangaroo;

import java.util.Scanner;

/**
 * 캥거루 세마리
 *
 * https://www.acmicpc.net/problem/2965
 *
 * comment : 뭔가 더 나은 방법이 있을거같은데...
 */
public class ThreeKangaroo {

    public static int solve(int a, int b, int c) {
        int moveCount = 0;

        while ( !(b - a <= 1 && c - b <= 1) ) {
            if ( b - a < c - b ) {
                int tmp = b;
                b = c - 1;
                a = tmp;
                moveCount++;
            } else {
                int tmp = b;
                b = a + 1;
                c = tmp;
                moveCount++;
            }
        }

        return moveCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        System.out.println(solve(a, b, c));
    }
}
