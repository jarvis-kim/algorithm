package com.github.jarviskim.algorithm.programmers;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 4단 고음
 * https://programmers.co.kr/learn/courses/30/lessons/1831
 *
 */
public class IU {

    class Solution {
        public int solution(int n) {
//            return solve(n, 3, 2);
            return solve2(n);
        }

        class Context {
            final int value;
            final int count;

            public Context(int value, int count) {
                this.value = value;
                this.count = count;
            }
        }

        /**
         * Error : OutOfMemoryError : Java heap space (n == 2147483647)
         * and very slow
         */
        public int solve2(int n) {
            int answer = 0;

            Deque<Context> stack = new LinkedList<>();
            stack.push(new Context(3, 2));

            while (!stack.isEmpty()) {
                Context ctx = stack.pop();
                if (ctx.value == n && ctx.count == 0) {
                    answer++;
                } else if (ctx.value < n) {
                    stack.push(new Context(ctx.value * 3, ctx.count + 2));
                    if (ctx.count > 0) {
                        stack.push(new Context(ctx.value + 1, ctx.count - 1));
                    }
                }
            }

            return answer;
        }

        /**
         * Error : StackOverflow (n == 2147483647)
         */
        public int solve(int n, int value, int count) {
            int answer = 0;

            if (n == value && count == 0) {
                return 1;
            } else if (n < value) {
                return 0;
            }

            answer += solve(n, value * 3, count + 2);

            if (count > 0) {
                answer += solve(n, value + 1, count - 1);
            }

            return answer;
        }

        String toString(Deque<Character> deque) {
            return new LinkedList<>(deque)
                    .stream()
                    .collect(StringBuilder::new, StringBuilder::append, (r, r2) -> {
                    })
                    .reverse()
                    .toString();
        }

        void print(Deque<Character> deque) {
            System.out.println(toString(deque));
        }
    }

    Solution createSolution() {
        return new Solution();
    }
}
