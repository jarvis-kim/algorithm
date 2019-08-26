package com.github.jarviskim.algorithm.mailprogramming;

import java.util.Arrays;

/**
 * 크기가 n인 배열에 1부터 n-1까지의 수가 들어 있고,
 * 중복된 수가 한 개 더 들어 있다고 할 때,
 * 중복된 수가 무엇인지 찾으시오.
 *
 * Input: [1, 2, 3, 4, 4]
 * Output: 4
 *
 * Input: [1, 2, 3, 4, 2]
 * Output: 2
 */
public class Quiz20190825 {

    public int resolve(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        int n = arr.length - 1;

        int result = n * (n + 1) / 2;
        return sum - result;
    }
}
