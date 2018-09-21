package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a13913_HideAndSeek4.HideAndSeek4;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class HideAndSeek4Test {

    private final static long LIMIT_TIME = 2 * 1000;

    @Test(timeout = LIMIT_TIME)
    public void test() {
        HideAndSeek4 hideAndSeek = new HideAndSeek4();
        int[] result = hideAndSeek.solve(5, 17);
        assertArrayEquals(new int[] { 5, 4, 8, 16, 17 }, result);
        assertEquals(4, result.length - 1);

        result = hideAndSeek.solve(1, 1);
        assertArrayEquals(new int[] { 1 }, result);
        assertEquals(0, result.length - 1);

        result = hideAndSeek.solve(4, 1);
        assertArrayEquals(new int[] { 4, 3, 2, 1 }, result);
        assertEquals(3, result.length - 1);

        result = hideAndSeek.solve(0, 100000);
        assertEquals(22, result.length - 1);
        assertArrayEquals(new int[] { 0, 1, 2, 3, 6, 12, 24, 48, 49, 98, 196, 195, 390, 780, 781, 1562, 3124, 3125, 6250, 12500, 25000, 50000, 100000 }, result);

        result = hideAndSeek.solve(3, 99999);
        assertEquals(20, result.length - 1);
        assertArrayEquals(new int[] { 3, 6, 12, 24, 48, 49, 98, 196, 195, 390, 780, 781, 1562, 3124, 3125, 6250, 12500, 25000, 50000, 100000, 99999 }, result);

        hideAndSeek.solve(1000, 400);

        hideAndSeek.solve(1, 99999);
        hideAndSeek.solve(0, 99999);
        hideAndSeek.solve(3, 99999);
        hideAndSeek.solve(0, 99999);
        hideAndSeek.solve(99999, 99999);
        hideAndSeek.solve(0, 0);
        hideAndSeek.solve(100000, 100000);
    }
}
