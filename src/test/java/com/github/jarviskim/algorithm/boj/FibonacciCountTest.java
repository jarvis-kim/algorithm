package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a1003_FibonacciCount.FibonacciCount;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class FibonacciCountTest {

    @Test
    public void test() {
        assertArrayEquals(new int[] { 1, 0 }, FibonacciCount.solve(0));
        assertArrayEquals(new int[] { 0, 1 }, FibonacciCount.solve(1));
        assertArrayEquals(new int[] { 1, 2 }, FibonacciCount.solve(3));

    }
}
