package com.github.jarviskim.algorithm.boj.a11654_AsciiCode;

import java.util.Scanner;

/**
 * 아스키코드
 * https://www.acmicpc.net/problem/11654
 */
public class AsciiCode {

    public static int solve(char c) {
        return c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char c = s.toCharArray()[ 0 ];
        System.out.println(solve(c));
    }
}
