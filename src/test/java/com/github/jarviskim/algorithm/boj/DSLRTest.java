package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a9019_DSLR.DSLR;
import org.junit.Assert;
import org.junit.Test;

public class DSLRTest {

    private static final int TIME_OUT = 6 * 1000;

    @Test(timeout = TIME_OUT)
    public void test() {
        Assert.assertEquals("LL", new DSLR().solve(1234, 3412));
        Assert.assertEquals("L", new DSLR().solve(1000, 1));
        Assert.assertEquals("DDDD", new DSLR().solve(1, 16));
        Assert.assertEquals("", new DSLR().solve(16, 16));
        Assert.assertEquals("S", new DSLR().solve(0, 9999));
    }
}
