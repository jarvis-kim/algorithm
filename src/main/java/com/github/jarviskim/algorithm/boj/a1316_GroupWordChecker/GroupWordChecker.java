package com.github.jarviskim.algorithm.boj.a1316_GroupWordChecker;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 그룹 단어 체커
 * https://www.acmicpc.net/problem/1316
 */
public class GroupWordChecker {

    public static int solve(String word) {
        Map<Character, Boolean> hasMap = new HashMap<>();
        char[] chars = word.trim().toCharArray();

        hasMap.put(chars[ 0 ], true);
        for ( int pos = 1; pos < chars.length; pos++ ) {
            if ( chars[ pos - 1 ] == chars[ pos ] ) {
            } else if ( hasMap.get(chars[ pos ]) == null ) {
                hasMap.put(chars[ pos ], true);
            } else {
                return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int result = 0;
        for ( int i = 0; i < n; i++ ) {
            String str = scanner.nextLine();
            result += solve(str);
        }

        System.out.println(result);
    }
}
