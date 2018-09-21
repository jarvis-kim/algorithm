package com.github.jarviskim.algorithm.mailprogramming;

/**
 *
 * 정수(int)가 주어지면, 팰린드롬(palindrome)인지 알아내시오. 팰린드롬이란, 앞에서부터 읽으나 뒤에서부터 읽으나 같은 단어를 말합니다. 단, 정수를 문자열로 바꾸면 안됩니다.
 */
public class IntegerPalindrome {

    public static boolean solve(int input) {
        if (input < 10) {
            return false;
        }

        int reverse = 0;
        int number = input;
        while (number != 0) {
            reverse *= 10;
            reverse += number % 10;
            number /= 10;
        }

        return reverse == input;
    }

    public static void main(String[] args) {

    }
}
