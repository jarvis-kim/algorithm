package com.github.jarviskim.algorithm.programmers;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 올바른 괄호
 * Level 8
 *
 * https://programmers.co.kr/learn/challenge_codes/73
 *
 * DP로 풀었는데, 피보나치 수열과 비슷하게 나온다.
 *
 * n = 5일때
 * 1  1  1  1  1
 *    1  2  3  4
 *       2  5  9
 *          5  14
 *             14
 *
 * n=5라면, 답은 dp[0][n] 번째를 모두 더한 값이 답이다.(정확한 이유를 분석해야하겠다..)
 *
 *
 * 다른 사람 풀이를 보니 DP를 안풀고도 O(N)값에 푸는 사람이 있다..
 * (factorial을 이용해서 푸는 사람이 있고, 재귀로 돌리면서 multiply 연산으로 하는 사람도 보인다.
 * 대단한 사람들이다...)
 */
class CorrectParenthesis {

    public static void main(String[] args) {
        CorrectParenthesis cp = new CorrectParenthesis();
        if (cp.parenthesisCase(3).equals(new BigInteger("5"))) {
            System.out.println("parenthesisCase(3)이 정상 동작합니다. 제출을 눌러서 다른 경우에도 정답인지 확인해 보세요.");
        } else {
            System.out.println("parenthesisCase(3)이 정상 동작하지 않습니다.");
        }
    }

    public BigInteger parenthesisCase(int n) {
        BigInteger[] dp = new BigInteger[n + 1];
        dp[0] = BigInteger.ZERO;
        dp[1] = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            BigInteger sum = BigInteger.ONE;
            for (int j = 2; j < i; j++) {
                sum = sum.add(dp[j]);
                dp[j] = sum;
            }
            dp[i] = new BigInteger(sum.toString());
        }

        return Arrays.stream(dp).reduce(BigInteger::add).get();
    }
}
