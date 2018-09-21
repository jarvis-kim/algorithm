package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a10844_EasyStairs.EasyStairs;
import org.junit.Assert;
import org.junit.Test;

public class EasyStairsTest {

    @Test(timeout = 1000)
    public void test() {
        Assert.assertEquals(9, EasyStairs.solve(1));
        Assert.assertEquals(17, EasyStairs.solve(2));
    }
}
