package com.github.jarviskim.algorithm.mailprogramming;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * 주어진 string 에 모든 단어를 거꾸로 하시오.
 *
 * 예제)
 * Input: “abc 123 apple”
 * Output: “cba 321 elppa”
 */
public class ReverseString {

    public static String reverse(String string) {
        return Stream.of(string.split(" "))
                .map(str -> convertString(reverse(str.toCharArray())))
                .collect(Collectors.joining(" "));
    }

    private static char[] reverse(char[] characters) {
        char[] reverseChars = new char[characters.length];
        for (int i = characters.length; i > 0 ; i--) {
            reverseChars[ characters.length - i ] = characters[i - 1];
        }

        return reverseChars;
    }

    private static String convertString(char[] characters) {
        return new String(characters);
    }

    public static void main(String[] args) {
        System.out.println(reverse("한글 abc 123 apple"));
    }

}
