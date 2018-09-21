package com.github.jarviskim.algorithm.mailprogramming;

import java.util.HashSet;
import java.util.Set;

/**
 * 예제)
 * <p>
 * Input: “aabcbcbc”
 * Output: 3 // “abc”
 * <p>
 * Input: “aaaaaaaa”
 * Output: 1 // “a”
 * <p>
 * Input: “abbbcedd”
 * ﻿Output: 4 // “bced”
 */
public class Quiz10 {

    public static String solve(String str) {
        int startIndex = 0;
        String result = "";
        Set<Character> charSet = new HashSet<>();
        char[] chars = str.toCharArray();

        for (int index = 0; index < chars.length; index++) {
            if (charSet.contains(chars[index]) || charSet.isEmpty()) {
                if (result.length() <= index - startIndex) {
                    result = str.substring(startIndex, index);
                }
                charSet.clear();
                startIndex = index;
            }
            charSet.add(chars[index]);
        }

        if (result.length() <= chars.length - startIndex) {
            result = str.substring(startIndex, chars.length);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solve("aabcbcbc"));
        System.out.println(solve("aaaaaaaa"));
        System.out.println(solve("abbbcedd"));
        System.out.println(solve("a"));
        System.out.println(solve("abaaaaaa"));
        System.out.println(solve("aaaaaaab"));
    }
}
