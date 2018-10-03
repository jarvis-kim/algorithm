package com.github.jarviskim.algorithm.book.apss_insignht.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LISTest {

    @Test
    public void solve() {
        int[] input_case1 = {1, 5, 2, 4, 7};
        int expected_case1 = 4;

        int[] input_case2 = {1, 3, 4, 2, 4};
        int expected_case2 = 3;

        int[] input_case3 = {1};
        int expected_case3 = 1;

        int[] input_case4 = {1, 1, 1};
        int expected_case4 = 1;

        assertEquals(expected_case1, new LIS(input_case1).solve());
        assertEquals(expected_case2, new LIS(input_case2).solve());
        assertEquals(expected_case3, new LIS(input_case3).solve());
        assertEquals(expected_case4, new LIS(input_case4).solve());
    }
}