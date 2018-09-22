package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a1932_NumberTriangle.NumberTriangle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberTriangleTest {

    @Test
    public void test() {
        int[][] input = new int[][] {
                new int[] { 7 },
                new int[] { 3, 8 },
                new int[] { 8, 1, 0 },
                new int[] { 2, 7, 4, 4 },
                new int[] { 4, 5, 2, 6, 5 },
        };

        assertEquals(30, NumberTriangle.solve(input));
    }
}
