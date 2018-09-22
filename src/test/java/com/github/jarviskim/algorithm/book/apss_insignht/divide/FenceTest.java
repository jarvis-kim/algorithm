package com.github.jarviskim.algorithm.book.apss_insignht.divide;

import org.junit.Test;

import static org.junit.Assert.*;

public class FenceTest {

    @Test
    public void solve() {
        Fence fence = new Fence();
        int[] input_case_1 = {7, 1, 5, 9, 6, 7, 3};
        int expect_case_1 = 20;

        int[] input_case_2 = {1, 4, 4, 4, 4, 1, 1};
        int expect_case_2 = 16;

        int[] input_case_3 = {1, 8, 2, 2};
        int expect_case_3 = 8;

        assertEquals(expect_case_1, fence.solve(input_case_1));
        assertEquals(expect_case_2, fence.solve(input_case_2));
        assertEquals(expect_case_3, fence.solve(input_case_3));
    }
}