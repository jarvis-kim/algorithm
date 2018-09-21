package com.github.jarviskim.algorithm.mailprogramming;

import org.junit.Assert;
import org.junit.Test;

public class MaxSequenceSumTest {

    @Test
    public void basic() {
        Assert.assertEquals(7, MaxSequenceSum.solve(-1, 3, -1, 5));
        Assert.assertEquals(-1, MaxSequenceSum.solve(-5, -3, -1));
        Assert.assertEquals(9, MaxSequenceSum.solve(2, 4, -2, -3, 8));
    }
}
