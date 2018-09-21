package com.github.jarviskim.algorithm.mailprogramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LISTest {

    @Test
    public void test() {
        assertEquals(3, LIS.solve(10, 9, 0, 7, 2, 5));
        assertEquals(6, LIS.solve(0, 8, 12, 2,6,14, 9, 5, 13, 3, 11, 7, 15));
        assertEquals(6, LIS.solve(10, 12, 14, 0, 16, 13, 14, 15, 16));
    }
}
