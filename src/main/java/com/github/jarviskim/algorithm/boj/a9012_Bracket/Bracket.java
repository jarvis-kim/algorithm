package com.github.jarviskim.algorithm.boj.a9012_Bracket;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * 괄호
 * https://www.acmicpc.net/problem/9012
 */
public class Bracket {

    private static final char LEFT_BRACKET = '(';
    private static final char RIGHT_BRACKET = ')';

    public static boolean solve(String bracket) {
        char[] brackets = bracket.toCharArray();

        Deque<Character> stack = new ArrayDeque<>();

        for ( char bracketChar : brackets ) {
            if ( bracketChar == LEFT_BRACKET ) {
                stack.add(bracketChar);
            } else if ( bracketChar == RIGHT_BRACKET ) {
                if ( stack.poll() == null ) {
                    return false;
                }
            } else {
                throw new IllegalArgumentException("괄호가 아니것이 포함됨.");
            }
        }

        return stack.isEmpty();
    }

    public static String solveToString(String bracket) {
        return solve(bracket) ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if ( scanner.hasNext() ) {
            scanner.nextLine();
        }
        for ( int i = 0; i < n; i++ ) {
            System.out.println(solveToString(scanner.nextLine().trim()));
        }

    }
}
