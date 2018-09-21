package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a2965_ThreeCangaroo.ThreeKangaroo;
import org.junit.Assert;
import org.junit.Test;

public class ThreeKangarooTest {

    @Test
    public void test() {
        Assert.assertEquals(3, ThreeKangaroo.solve(3, 5, 9));
        Assert.assertEquals(0, ThreeKangaroo.solve(1, 2, 3));
        Assert.assertEquals(1, ThreeKangaroo.solve(1, 2, 4));
        Assert.assertEquals(2, ThreeKangaroo.solve(1, 2, 5));
        Assert.assertEquals(1, ThreeKangaroo.solve(1, 3, 5));
        Assert.assertEquals(2, ThreeKangaroo.solve(1, 3, 6));
    }
}
