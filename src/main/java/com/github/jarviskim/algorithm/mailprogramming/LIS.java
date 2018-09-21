package com.github.jarviskim.algorithm.mailprogramming;

import java.util.Arrays;

/**
 * 정수 배열이 주어지면 가장 긴 커지는 원소들의 집한의 길이를 구하시오.
 * LIS - Longest Increasing Subsequence
 * 페이스북에 누가 LIS라고 했더라.
 * 그런데 난 LIS를 아주 오래전에 책에서 봤는데 기억이 하나도 안나네.-_-;
 */
public class LIS {

    /**
     * DP
     * 가장 긴 부분 집한 = max(d)
     * d[ i ] = d[ i ] 를 포함하고, d[ i ]의 전 부분집합 중 마지막 부분 집합의 크기보다 크다면 해당 부분집합의 + 1한 것중 가장 큰 수
     *
     * @param numbers
     * @return
     */
    public static int solve(int... numbers) {
        int[] maxSubset = new int[numbers.length];
        maxSubset[0] = 1;
        int max;
        for (int i = 1; i < numbers.length; i++) {
            max = 1;
            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[i]) {
                    max = Math.max(max, maxSubset[j] + 1);
                }
            }
            maxSubset[i] = max;
        }

        return Arrays.stream(maxSubset)
                .max()
                .getAsInt();
    }

    public static void main(String[] args) {

    }
}
