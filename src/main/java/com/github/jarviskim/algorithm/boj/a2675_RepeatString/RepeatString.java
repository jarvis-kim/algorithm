package com.github.jarviskim.algorithm.boj.a2675_RepeatString;

import java.util.Scanner;

/**
 * 반복 문자열
 * https://www.acmicpc.net/problem/2675
 */
public class RepeatString {

    public static String solve(int repeat, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = str.trim().toCharArray();

        for ( char character : chars ) {
            for ( int count = 0; count < repeat; count++ ) {
                stringBuilder.append(character);
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for ( int i = 0; i < n; i++ ) {
            int repeat = scanner.nextInt();
            String str = scanner.nextLine();
            System.out.println(solve(repeat, str));
        }
    }
}
