package com.github.jarviskim.algorithm.mailprogramming;

import org.junit.Assert;
import org.junit.Test;

public class TwoSumTest {

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[] {0, 2}, TwoSum.solve(new int[] {2, 5, 6, 1, 10}, 8));
        Assert.assertArrayEquals(new int[] {0, 1}, TwoSum.solve(new int[] {2, 5, 6, 1, 10}, 7));
        Assert.assertArrayEquals(new int[] {1, 3}, TwoSum.solve(new int[] {2, 5, 6, 1, 10}, 6));

    }
}
