package com.github.jarviskim.algorithm.book.apss_insignht.dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrianglePathTest {

    @Test
    public void maxSum() {
        int[][] input_case1 = {
                {6, 0, 0, 0, 0},
                {1, 2, 0, 0, 0},
                {3, 7, 4, 0, 0},
                {9, 4, 1, 7, 0},
                {2, 7, 5, 9, 4}
        };
        int expected_case1 = 28;

        int[][] input_case2 = {
                {1, 0, 0, 0, 0},
                {2, 4, 0, 0, 0},
                {8, 16, 8, 0, 0},
                {32, 64, 32, 64, 0},
                {128, 256, 128, 256, 128}
        };
        int expected_case2 = 341;


        assertEquals(expected_case1, new TrianglePath(input_case1).maxSum());
        assertEquals(expected_case2, new TrianglePath(input_case2).maxSum());
    }
}