package com.github.jarviskim.algorithm.book.apss_insignht.dp;

import static java.lang.Math.max;
import static java.util.Objects.nonNull;

/**
 * 최대 증가 부분 수열<Longest Increasing Sub-Sequence> (난이도 : 하)
 * 문제 : 주어진 수열 중 증가하는 부분수열의 최대 길이
 * 페이지 : 230p
 */
public class LIS {

    private int[] numbers;
    private Integer[] memoization;

    public LIS(int[] numbers) {
        this.numbers = numbers;
        this.memoization = new Integer[numbers.length];
    }

    /**
     * 수열 중 최대로 증가하는 부분 수열의 길이 반환 한다.
     *
     * @return 최대로 증가하는 부분 수열의 길이
     */
    public int solve() {
        return solve(0, numbers[0]);
    }

    public int solve(int index, int beforeNumber) {
        if (nonNull(memoization[index])) {
            return memoization[index];
        }

        int max = 1;
        for (int next = index + 1; next < numbers.length; next++) {
            if (beforeNumber < numbers[next]) {
                max = max(max, solve(next, numbers[next]) + 1);
            }
        }

        return memoization[index] = max;
    }

}
