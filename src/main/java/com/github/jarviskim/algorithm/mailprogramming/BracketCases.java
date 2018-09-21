package com.github.jarviskim.algorithm.mailprogramming;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 정수 n이 주어지면, n개의 여는 괄호 “(“와 n개의 닫는 괄호 “)”로 만들 수 있는 괄호 조합을 모두 구하시오. (시간 복잡도 제한 없습니다).
 * <p>
 * 예제)
 * <p>
 * Input: 1
 * Output: [“()”]
 * <p>
 * Input: 2
 * Output: [“(())”, “()()”]
 * <p>
 * Input: 3
 * Output: [“((()))”, “(()())”, “()(())”, “(())()”, “()()()”]
 */
public class BracketCases {

    public static char LEFT_BRACKET = '(';

    public static char RIGHT_BRACKET = ')';

    public static void solve(Deque<Character> stack, int n, final int leftCount, final int rightCount) {
        if (stack.size() == n * 2) {
            print(stack);
            return;
        }

        if (leftCount < n) {
            stack.push(LEFT_BRACKET);
            solve(stack, n, leftCount + 1, rightCount);
            stack.pop();
        }

        if (rightCount < n && rightCount < leftCount) {
            stack.push(RIGHT_BRACKET);
            solve(stack, n, leftCount, rightCount + 1);
            stack.pop();
        }
    }


    private static void print(Deque<Character> stack) {
        StringBuilder builder = new StringBuilder();
        stack.forEach(character -> {
            builder.append(character);
        });

        System.out.println(builder.reverse().toString());
    }


    public static void main(String[] args) {
        solve(new ArrayDeque<>(), 3, 0, 0);

    }

}