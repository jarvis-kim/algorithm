package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a11053_LongSubset.LongSubset;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongSubsetTest {

    @Test(timeout = 1000)
    public void test() {
        assertEquals(4, LongSubset.solve(10, 20, 10, 30, 20, 50));
        assertEquals(4, LongSubset.solve(10, 40, 20, 5, 6, 50, 7, 8, 6));
    }
}
