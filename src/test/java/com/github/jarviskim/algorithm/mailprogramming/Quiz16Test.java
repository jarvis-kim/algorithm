package com.github.jarviskim.algorithm.mailprogramming;

import org.junit.Test;

import static com.github.jarviskim.algorithm.mailprogramming.Quiz16.mergeKeepSorted;
import static org.junit.Assert.assertArrayEquals;

public class Quiz16Test {

    @Test
    public void test() {
        int[] input_1_1 = {1, 2, 3};
        int[] input_1_2 = {1, 2, 3};
        int[] expected_1 = {1, 1, 2, 2, 3, 3};
        assertArrayEquals(expected_1, mergeKeepSorted(input_1_1, input_1_2));

        int[] input_2_1 = {1, 3, 5, 6};
        int[] input_2_2 = {2, 4};
        int[] expected_2 = {1, 2, 3, 4, 5, 6};
        assertArrayEquals(expected_2, mergeKeepSorted(input_2_1, input_2_2));
    }
}
