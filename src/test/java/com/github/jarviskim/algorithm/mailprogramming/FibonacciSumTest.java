package com.github.jarviskim.algorithm.mailprogramming;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciSumTest {

    @Test
    public void test() {
        Assert.assertEquals(10, FibonacciSum.sum(12));
        Assert.assertEquals(188, FibonacciSum.sum(144));
    }
}
