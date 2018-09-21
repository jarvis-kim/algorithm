package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a1463_NumberOne.NumberOne;
import org.junit.Assert;
import org.junit.Test;

public class NumberOneTest {

    @Test()
    public void test() {
        Assert.assertEquals(1, NumberOne.solve(2));
        Assert.assertEquals(3, NumberOne.solve(10));
    }

    @Test()
    public void test2() {
        Assert.assertEquals(0, NumberOne.solve2(1));
        Assert.assertEquals(1, NumberOne.solve2(2));
        Assert.assertEquals(3, NumberOne.solve2(10));
        Assert.assertEquals(4, NumberOne.solve2(30));
        Assert.assertEquals(5, NumberOne.solve2(25));
        Assert.assertEquals(3, NumberOne.solve2(8));
    }
}
