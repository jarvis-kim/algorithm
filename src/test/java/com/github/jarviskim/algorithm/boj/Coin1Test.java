package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a2293_Coin1.Coin1;
import org.junit.Assert;
import org.junit.Test;

public class Coin1Test {

    @Test
    public void test() {
        Assert.assertEquals(10, Coin1.solve(10, 1, 2, 5));
    }
}
