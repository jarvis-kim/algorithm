package com.github.jarviskim.algorithm.boj.a1193_Fraction;

import java.util.Scanner;

/**
 * 분수 찾기
 * https://www.acmicpc.net/problem/1193
 */
public class Fraction {

    public static String solve(int n) {
        int count = 1;
        int current = 1;
        while ( current < n ) {
            current += ++count;
        }

        int remainder = n - (current - count)  ;
        if ( count % 2 == 0 ) {
            return remainder + "/" + (count + 1 - remainder );
        } else {
            return count + 1 - remainder + "/" + remainder;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(solve(n));
    }

}
